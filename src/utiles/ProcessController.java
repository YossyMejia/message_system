
package utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelos.Process;
import modelos.*;
import vistas.Principal_view;


public class ProcessController {
    
    //Variables
    private int cantidad_procesos;  //quantity of process specified by the user
    private int cantidad_mailboxes; //quantity of mailboxes specified by the user
    private int largo_cola;         //queue length
    private String sincr_receive_opt;  //sincronization recevie option (could be blocking, nonblocking, test for arrival
    private String sincr_send_opt;     //sincronization send option (could be blocking, nonblocking)
    private String addressing_type;    //addressing type (could be direct or indirect) 
    private String direct_receive_opt; //Adressing direct receive options (explicit or implicit)
    private String indirect_opt;       //Indirect addressing options (static or dynamic)
    private Command command;           //store the command object descomposed
    private MessageLog messageLog = new MessageLog();
    private ArrayList<Message> messages = new ArrayList<Message>();
    private ArrayList<Process> processes = new ArrayList<Process>();
    private ArrayList<Mailbox> mailboxes = new ArrayList<Mailbox>();
    private String output_message; //The execution result message
    private String time; //The actual time 
    
    //File managment variables
    private File command_file;
    private int N_stop;
    private ArrayList<String> buffer_command;
    
    public ProcessController() {
        
    }
    
    //Initialize the configuration of the environment 
    public void setConfig(String sincr_receive_opt, String sincr_send_opt,
            String addressing_type, String direct_receive_opt, int cantidad_procesos){
        this.sincr_receive_opt = sincr_receive_opt;
        this.sincr_send_opt = sincr_send_opt;
        this.addressing_type = addressing_type;
        this.cantidad_procesos = cantidad_procesos;
        this.direct_receive_opt = direct_receive_opt;
    }
    
    //Call the create processes and create mailbox functions
    public void create(){
        this.createProcesses();
        this.createMailboxes();
        //Llamar a crear el mailbox en caso de que la configuracion lo necesite
    }
    
    //Create N processes specified by the user 
    public void createProcesses(){
        while (cantidad_procesos != 0){
            String id =  "p"+Integer.toString(cantidad_procesos);
            Process process = new Process(id);
            this.processes.add(process);
            cantidad_procesos -= 1;
        }
    }  
    
    //Return the process that match with the ID 
    public Process getProcessByID(String ID){
        Process proc_find = null;
        for (Process proceso: this.processes) {
            if(proceso.getProcess_id().equals(ID)){
                proc_find = proceso;
                break;
            }
        }
        return proc_find;
    }
    
    //Execute a command and return a output based on the result of the execution 
    public void executeCommand(String command_input, String time, Principal_view command_v){
        this.command = new Command(command_input);
        this.time = time;
        this.output_message = null;
        if (this.command.getCorrect() == true){
            String type = this.command.getCommand_type();   
            
            if(type == CommandTypes.SEND.type){
                String message = time+" Tipo comando -> SEND: el proceso "+ this.command.getProcessID()  //LOG
                        +" invoca el comando, el destino es: " + this.command.getDestination()
                        + " y el mensaje es: "+this.command.getMessage();
                command_v.writeInConsole(message); //write in the view console
                sendCommand();
                command_v.writeInConsole(this.output_message); //write in the view console
            }
            else if(type == CommandTypes.RECEIVE_IMPLICIT.type){
                if(this.direct_receive_opt == ConfigOptions.RECEIVE_IMPLICIT.option){
                    String message = time+" Tipo comando -> RECEIVE IMPLICITO: el proceso "              //LOG
                        + this.command.getProcessID()+" invoca el comando";
                    command_v.writeInConsole(message); //write in the view console
                    receiveExplicitCommand();
                    command_v.writeInConsole(this.output_message); //write in the view console
                }
                else{
                    String message = time+" Tipo comando -> RECEIVE IMPLICITO: "
                            + "comando invalido la configuracion esta establecida "
                            + "en receive explicito y el comando es tipo implicito\n\n";
                    command_v.writeInConsole(message); //write in the view console
                }
                
            }
            else if(type == CommandTypes.RECEIVE_EXPLICIT.type){
                if(this.direct_receive_opt == ConfigOptions.RECEIVE_EXPLICIT.option){
                    String message = time+" Tipo comando -> RECEIVE EXPLICITO: el proceso "              //LOG
                            + this.command.getProcessID()+" invoca el comando, desea leer "
                            + "mensaje proveniente de " + this.command.getSource();
                    command_v.writeInConsole(message); //write in the view console
                    receiveExplicitCommand();
                    command_v.writeInConsole(this.output_message); //write in the view console
                }
                else{
                    String message = time+" Tipo comando -> RECEIVE EXPLICITO: "
                            + "comando invalido la configuracion esta establecida "
                            + "en receive implicito y el comando es tipo explicito\n\n";
                    command_v.writeInConsole(message); //write in the view console
                }
            }
            
            else if(type == CommandTypes.CONTINUE.type){
                if(this.command_file != null){
                    String message = time+" Tipo comando -> CONTINUE: "
                            + "Corriendo comandos desde archivo cargado...";
                    command_v.writeInConsole(message); //write in the view console
                    if(this.N_stop > 0){
                        this.executeNBufferCommands(command_v);
                    }
                    else{
                        String message2 = time + "ERROR: para ejecutar este comando "
                                + "la cantidad de comandos para parar debe ser distinta de 0 \n\n";
                        command_v.writeInConsole(message2); //write in the view console
                    }
                    
                }
                else{
                    String message = time+" Tipo comando -> READ: "
                            + "No se ha cargado ningun documento de comandos";
                    command_v.writeInConsole(message); //write in the view console
                }
            }
            
            else if(type == CommandTypes.READ.type){
                if(this.command_file != null){
                    String message = time+" Tipo comando -> READ: "
                            + "Corriendo comandos desde archivo cargado...";
                    command_v.writeInConsole(message); //write in the view console
                    if(this.N_stop > 0)
                        this.executeNBufferCommands(command_v);
                    else
                        this.executeAllBufferCommands(command_v);
                }
                else{
                    String message = time+" Tipo comando -> READ: "
                            + "No se ha cargado ningun documento de comandos\n\n";
                    command_v.writeInConsole(message); //write in the view console
                }
            }
            
        }
        
        else{
            String error_message = time+" ERROR: algo resulto mal ejecutando el comando''"          //LOG
                    + this.command.getCommand_input() +"''\n\n";
            command_v.writeInConsole(error_message); //write in the view console
        }
    }
    
    //Choose the function to be called in base of the options decided by the user
    public void sendCommand(){
        //Choose what function call in base of the addressing mode 
        if(this.addressing_type == ConfigOptions.ADDRESSING_INDIRECT.option){
            this.IndirectSendOpt();
        }
        else if(this.addressing_type == ConfigOptions.ADDRESSING_DIRECT.option){
            this.DirectSendOpt();
        }
    }
    
    
    //Choose the receive function to be called in base of the options decided by the user
    public void receiveExplicitCommand(){
        //Choose what function call in base of the addressing mode 
        if(this.addressing_type == ConfigOptions.ADDRESSING_INDIRECT.option){
            this.IndirectReceiveOpt();
        }
        else if(this.addressing_type == ConfigOptions.ADDRESSING_DIRECT.option){
            this.DirectReceiveOpt();
        }
    }
    
    //DIRECT MODE FUNCTIONS *************************************************
    // **********************************************************************
    
    //SEND MODE --------------------
    //Choose what function call in base of the send option 
    public void DirectSendOpt(){
        try {
            Process send_process = this.getProcessByID(this.command.getProcessID());
            if(send_process.getBlocked() == false){
                this.directMessage(send_process);
            }
            else{
                this.output_message = this.time+" ERROR: El mensaje '"+ command.getMessage()
                    +"' no se ha enviado a '"+this.command.getDestination() + "'"
                    + " debido a que el proceso emisor '" + this.command.getProcessID()
                    + "' se encuentra bloqueado \n\n";
            }

        }
        catch(Exception e){
            this.output_message = this.time+" ERROR: El identificador '"
                    + this.command.getProcessID()+ "' no coincide con ningun proceso \n\n";
        }
        this.saveLogMessSProcessSend();    //save the log message in the send process
        this.saveLogMessDProcessSend(); //save the log message in the destination process
    }
    
    //create a message and send it to the destination process
    public void directMessage(Process send_process){
        Process destination_process = this.getProcessByID(this.command.getDestination());
        Message message = this.createMessageDirectMode(send_process, destination_process);
        this.sendMessageDirectMode(message, destination_process, send_process);
    }
    
    //Create a message ONLY for the direct mode 
    public Message createMessageDirectMode(Process send_process, Process destination_process){
        Message message = new Message(send_process, destination_process, 
                this.command.getMessage(), this.time);
        return message;
    }
    
    //Send a message  ONLY for the direct mode 
    public void sendMessageDirectMode(Message message, Process destination_process, 
            Process send_process){
        try{
            Boolean receive_available = this.receiveSignal(destination_process, send_process);
            if(receive_available){
                destination_process.saveMessageDirectMode(message);
                this.output_message = this.time+" EXITOSO: El mensaje '"+ message.getMessage()
                        +"' enviado por el proceso '"+this.command.getProcessID()+ "'"
                        + " se ha entregado al proceso '" + this.command.getDestination() 
                        + "' de forma exitosa \n\n";

                this.sendSignalReceive(destination_process, send_process, message);

                if(sincr_send_opt == ConfigOptions.SEND_NONBLOCKIN.option){
                        send_process.setReady(true); 
                }
                else if(sincr_send_opt == ConfigOptions.SEND_BLOCK.option){
                    send_process.setBlocked(true);
                    send_process.setReady(false); 
                }
                 send_process.setRunning(false);
                 this.processes.set(this.processes.indexOf(send_process), send_process);
            }
            else{
                this.output_message = this.time+" ERROR: No se ha podido ingresar el"
                    + " mensaje '"+ message.getMessage()+ "' enviado por '"
                    +this.command.getProcessID() + "' al buzon del proceso '"
                    +this.command.getDestination() + " debido a que el proceso "
                    + "receptor se encuentra bloqueado esperando un mensaje del "
                    + "proceso '"+ destination_process.getUnblockProcessID() +"'\n\n";
            }
        }
        catch(Exception e){
            this.output_message = this.time+" ERROR: No se ha podido ingresar el"
                    + " mensaje '"+ message.getMessage()+ "' enviado por '"
                    +this.command.getProcessID() + "' al buzon del proceso '"
                    +this.command.getDestination() + "\n\n";
        }
        
    }
    
    //Send a signal if the destination process could recive a message
    public Boolean receiveSignal(Process destination_process, Process send_process){
        if(destination_process.getBlocked() == true){
            if(destination_process.getUnblockProcessID().equals("ANYONE")
                || destination_process.getUnblockProcessID().equals(send_process.getProcess_id())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }
    
    //Send a signal to unlock the receive process
    public void sendSignalReceive(Process destination_process, Process send_process, 
            Message message){
        if(this.sincr_receive_opt == ConfigOptions.RECEIVE_BLOCKING.option ){
            destination_process.setBlocked(false);
            destination_process.setReady(false);
        }
        else if(this.sincr_receive_opt == ConfigOptions.RECEIVE_TFA.option 
                && destination_process.getBlocked() == true){
           if(destination_process.getUnblockProcessID().equals("ANYONE")
               || destination_process.getUnblockProcessID().equals(send_process.getProcess_id())){
               send_process.setBlocked(false);
               destination_process.setBlocked(false);
               destination_process.setReady(false);
               saveLogMessRTFA(destination_process, message);
           }
        }
        else{
           destination_process.setReady(true);
        }
        destination_process.setRunning(false);
        this.processes.set(this.processes.indexOf(send_process), send_process);
        this.processes.set(this.processes.indexOf(destination_process), destination_process);
    }
            
    //Save the log messages in the send and destination process, ONLY for the direct mode 
    public void saveLogMessSProcessSend(){
        try{
            Process send_process = this.getProcessByID(this.command.getProcessID());
            String extra_message = "PROCESO_ESTADO: Bloqueado: "
                    + send_process.getBlocked() + " , Preparado: "
                    + send_process.getReady() + " , Corriendo: "
                    + send_process.getRunning()+"\n";
            send_process.saveLogMessage(extra_message+this.output_message);
            this.processes.set(this.processes.indexOf(send_process), send_process);
        }
        catch(Exception e){}
    }
    
    //Save a log message in the respectly process
    public void saveLogMessDProcessSend(){
        try{
            Process destination_process = this.getProcessByID(this.command.getDestination());
            String extra_message = "PROCESO_ESTADO: Bloqueado: "
                    + destination_process.getBlocked() + " , Preparado: "
                    + destination_process.getReady() + " , Corriendo: "
                    + destination_process.getRunning() +"\n";
            destination_process.saveLogMessage(extra_message+this.output_message);
            this.processes.set(this.processes.indexOf(destination_process), destination_process);
        }
        catch(Exception e){}
    }
    
    //Save a log message in the receive process that was in TFA mode
    public void saveLogMessRTFA(Process process, Message message){
       try{
           this.output_message = this.time
                   +" EXITOSO: El mensaje '"+ message.getMessage()
                   +"' enviado por el proceso '"+ message.getSender().getProcess_id()+ "'"
                   + " se ha leido por el proceso '" + process.getProcess_id()
                   + "' de forma exitosa\n";
            String extra_message = "PROCESO_ESTADO: Bloqueado: "
                    + process.getBlocked() + " , Preparado: "
                    + process.getReady() + " , Corriendo: "
                    + process.getRunning() +"\n";
            process.getBuffer_messages().remove(message);
            System.out.println(process.getBuffer_messages().get(0));
            process.saveLogMessage(extra_message+this.output_message);
            this.processes.set(this.processes.indexOf(process), process);
        }
        catch(Exception e){}
    }
    
    //SEND MODE --------------------
    
    
    
    //RECEIVE MODE -----------------
    
    //Function for direct implicit receive option 
    public void DirectReceiveOpt(){
        try {
            Process receive_process = this.getProcessByID(this.command.getProcessID());
            if(receive_process.getBlocked() == false){
                if(this.command.getCommand_type() == CommandTypes.RECEIVE_IMPLICIT.type)
                    this.readMessageImplicitM(receive_process);
                else if(this.command.getCommand_type() == CommandTypes.RECEIVE_EXPLICIT.type)
                    this.readMessageExplicitM(receive_process);
            }
            else{
                this.output_message = this.time+" ERROR: El proceso '"+ this.command.getProcessID()
                    +"' no ha podido leer ningun mensaje debido a que se encuentra bloqueado"
                    +" esperando un mensaje de "+ receive_process.getUnblockProcessID() + " \n\n";
            }
        }
        catch(Exception e){
            this.output_message = this.time+" ERROR: El identificador '"
                    + this.command.getProcessID()+ "' no coincide con ningun proceso \n\n";
        }
        this.saveLogMessRProcessReceive();    //save the log message in the receive process
    }
    
    //Try to read a message of the function in case it didn't have available messages 
    //inform to the user (Implicit mode)
    public void readMessageImplicitM(Process receive_process){
        ArrayList<Message> buffer = receive_process.getBuffer_messages();
        if(buffer.isEmpty()){
            if(this.sincr_receive_opt == ConfigOptions.RECEIVE_BLOCKING.option 
                    || this.sincr_receive_opt == ConfigOptions.RECEIVE_TFA.option ){
                receive_process.setBlocked(true);
                receive_process.setReady(false);
                receive_process.setRunning(false);
                receive_process.setUnblockProcessID("ANYONE");
            }
            this.output_message = this.time+" ERROR: El proceso '"
                    + this.command.getProcessID()+ "' no tiene ningun mensaje en espera \n\n";
        }
        else{
            Message message = buffer.get(0);
            buffer.remove(0);
            this.output_message = this.time+" EXITOSO: El mensaje '"+ message.getMessage()
                        +"' enviado por el proceso '"+ message.getSender().getProcess_id()+ "'"
                        + " se ha leido por el proceso '" + this.command.getProcessID()
                        + "' de forma exitosa \n\n";
            this.sendSignalSource(message.getSender());
        }
        receive_process.setBuffer_messages(buffer);
        this.processes.set(this.processes.indexOf(receive_process), receive_process);
        
    }
    
    //Try to read a message of the function in case it didn't have available messages 
    //inform to the user (Explicit mode)
    public void readMessageExplicitM(Process receive_process){
        ArrayList<Message> buffer = receive_process.getBuffer_messages();
        Message message = this.getMessageFromBuffer(buffer, this.command.getSource());
        if(message == null){
            if(this.sincr_receive_opt == ConfigOptions.RECEIVE_BLOCKING.option 
                    || this.sincr_receive_opt == ConfigOptions.RECEIVE_TFA.option ){
                receive_process.setBlocked(true);
                receive_process.setReady(false);
                receive_process.setRunning(false);
                receive_process.setUnblockProcessID(this.command.getSource());
            }
            this.output_message = this.time+" ERROR: El proceso '"
                    + this.command.getProcessID()+ "' no tiene ningun mensaje en"
                    + " espera del proceso '"+ this.command.getSource() +"\n\n";
        }
        else{
            buffer.remove(buffer.indexOf(message));
            this.output_message = this.time+" EXITOSO: El mensaje '"+ message.getMessage()
                        +"' enviado por el proceso '"+ message.getSender().getProcess_id()+ "'"
                        + " se ha leido por el proceso '" + this.command.getProcessID()
                        + "' de forma exitosa \n\n";
            this.sendSignalSource(message.getSender());
        }
        receive_process.setBuffer_messages(buffer);
        this.processes.set(this.processes.indexOf(receive_process), receive_process);
    }
    
    //Return the message that match with the source ID from the buffer
    public Message getMessageFromBuffer(ArrayList<Message> buffer, String processID){
        Message message = null;
        for (Message buff_message: buffer) {
            if(buff_message.getSender().getProcess_id().equals(processID)){
                message = buff_message;
                break;
            }
        }
        return message;
    }
    
    //Save a log message in the receive mode
    public void saveLogMessRProcessReceive(){
       try{
            Process send_process = this.getProcessByID(this.command.getProcessID());
            String extra_message = "PROCESO_ESTADO: Bloqueado: "
                    + send_process.getBlocked() + " , Preparado: "
                    + send_process.getReady() + " , Corriendo: "
                    + send_process.getRunning()+"\n";
            send_process.saveLogMessage(extra_message+this.output_message);
            this.processes.set(this.processes.indexOf(send_process), send_process);
        }
        catch(Exception e){}
    }
    
    //Send a signal to unlock the send process
    public void sendSignalSource(Process process){
        if(this.sincr_send_opt == ConfigOptions.SEND_BLOCK.option){
            process.setBlocked(false);
        }
        process.setReady(true);
        process.setRunning(false);
        this.processes.set(this.processes.indexOf(process), process);
    }
    
    //DIRECT MODE FUNCTIONS END ********************************************
    // **********************************************************************
 
    //INDIRECT MODE FUNCTIONS *************************************************
    // **********************************************************************

    public int getCantidad_mailboxes() {
        return cantidad_mailboxes;
    }

    public void setCantidad_mailboxes(int cantidad_mailboxes) {
        this.cantidad_mailboxes = cantidad_mailboxes;
    }

    public int getLargo_cola() {
        return largo_cola;
    }

    public void setLargo_cola(int largo_cola) {
        this.largo_cola = largo_cola;
    }
     
    //Create N mailboxes specified by the user 
    public void createMailboxes(){
        while (cantidad_mailboxes != 0){
            String id =  "m"+Integer.toString(cantidad_mailboxes);
            Mailbox mailbox = new Mailbox(id, this.largo_cola);
            this.mailboxes.add(mailbox);
            cantidad_mailboxes -= 1;
        }
    }      
  
    public void IndirectSendOpt(){

        try {
            Process send_process = this.getProcessByID(this.command.getProcessID());
            if(send_process.getBlocked() == false){
                this.indirectMessage(send_process);
            }
            else{
                this.output_message = this.time+" ERROR: El mensaje '"+ command.getMessage()
                    +"' no se ha enviado a '"+this.command.getDestination() + "'"
                    + " debido a que el proceso emisor '" + this.command.getProcessID()
                    + "' se encuentra bloqueado \n\n";
            }           
        }
        catch(Exception e) {
            this.output_message = this.time+" ERROR: El identificador '"
                    + this.command.getProcessID()+ "' no coincide con ningun proceso \n\n";            
        }
        this.saveLogMessSProcessSend();    //save the log message in the send process
        this.saveLogMessQueue();           //save the log message in the receiving queue
    }

       //create a message and send it to the destination mailbox
    public void indirectMessage(Process send_process){
        Mailbox destination_mailbox = this.getMailboxByID(this.command.getDestination());
        Message message = this.createMessageIndirectMode(send_process);
        this.sendMessageIndirectMode(message, destination_mailbox, send_process);
    } 
    
    //Create a message ONLY for the indirect mode 
    public Message createMessageIndirectMode(Process send_process){
        Message message = new Message(send_process, 
                this.command.getMessage(), 1, this.time);
        return message;
    }
    
    public Boolean verifyQueue(Mailbox mailbox) {
        
        int queue_available = mailbox.getQueue().size();
        if (queue_available < this.largo_cola){
            return true;}
        else {
        return false;}
    }

    //Send a message  ONLY for the indirect mode 
    public void sendMessageIndirectMode(Message message, Mailbox destination_mailbox, 
            Process send_process) {
        try{
            /*Receive available. Queue, exists, not full*/
            Boolean queue_notfull = verifyQueue(destination_mailbox);
            if (queue_notfull) {
                String message_local = message.getMessage();
                this.setOutput_message(this.time+" EXITOSO: El mensaje '"+ message_local
                        +"' enviado por el proceso '"+this.command.getProcessID()+ "'"
                        + " ha sido ingresado a la cola '" + this.command.getDestination() 
                        + "' de forma exitosa \n\n");
                //meter en la cola
                destination_mailbox.getQueue().add(message);  
                
                if(sincr_send_opt == ConfigOptions.SEND_NONBLOCKIN.option){
                        send_process.setReady(true); 
                }
                else if(sincr_send_opt == ConfigOptions.SEND_BLOCK.option){
                    send_process.setBlocked(true);
                    send_process.setReady(false); 
                }
                send_process.setRunning(false);
                this.processes.set(this.processes.indexOf(send_process), send_process);                
            }
            else {
                this.output_message = this.time+" ERROR: No se ha podido ingresar el"
                    + " mensaje '"+ message.getMessage()+ "' enviado por '"
                    +this.command.getProcessID() + "' al mailbox '"
                    +this.command.getDestination() + " debido a que el mailbox "
                    + "se encuentra lleno. \n\n'";                
            }

        }        
        catch(Exception e){

            this.output_message = this.time+" ERROR: No se ha podido ingresar el"
                    + " mensaje '"+ message.getMessage()+ "' enviado por '"
                    +this.command.getProcessID() + "' al mailbox '"
                    +this.command.getDestination() + "' porque el receptor no existe "
                    + "o no es un mailbox. \n\n";
        }

    }
    
    public void saveLogMessQueue() {
        try {
            Mailbox destination_mailbox = this.getMailboxByID(this.command.getDestination());
            String extra_message = "MAILBOX ESTADO: Tamaño: "
                    + destination_mailbox.getQueue().size() + " , Capacidad:"
                    + this.largo_cola+"\n";
            this.messageLog.saveLogMessage(extra_message+this.output_message);
            this.mailboxes.set(this.mailboxes.indexOf(destination_mailbox), destination_mailbox);
        }
        catch (Exception e) {
            
        }
    }

    public void saveLogMessSourceQueue() {
        try {
            Mailbox source_mailbox = this.getMailboxByID(this.command.getSource());
            String extra_message = "MAILBOX ESTADO: Tamaño: "
                    + source_mailbox.getQueue().size() + " , Capacidad:"
                    + this.largo_cola+"\n";
            this.messageLog.saveLogMessage(extra_message+this.output_message);
            this.mailboxes.set(this.mailboxes.indexOf(source_mailbox), source_mailbox);
        }
        catch (Exception e) {
            
        }
    }
    
    //RECEIVE MODE ----------------- 
     public void IndirectReceiveOpt(){
        try {
            Process receive_process = this.getProcessByID(this.command.getProcessID());
            Mailbox source_mailbox = this.getMailboxByID(this.command.getSource());
            if (!source_mailbox.getQueue().isEmpty())
            {
                if(receive_process.getBlocked() == false){
                    if (this.indirect_opt == ConfigOptions.INDIRECT_STATIC.option) {

                        this.removeQueueStatic(receive_process);
                    }
                    else if (this.indirect_opt == ConfigOptions.INDIRECT_DINAMIC.option) {

                        this.removeQueueDynamic(source_mailbox, receive_process);
                    }
                }
                else {
                    //receiving process is blocked
                    this.output_message = this.time+" ERROR: El mensaje '"+ command.getMessage()
                        +"' no se ha liberado de '"+ source_mailbox.getMailbox_id() + "'"
                        + " debido a que el proceso receptor '" + receive_process.getProcess_id()
                        + "' se encuentra bloqueado \n\n";                
                }
            }
            else {
                //source mailbox is empty
                this.output_message = this.time+" ERROR: No se puede "
                    +" recibir ningun mensaje del mailbox '"+ this.command.getSource() + "'"
                    + " debido a que se encuentra vacio \n\n";     
            }
        }
        catch (Exception e) {
            this.output_message = this.time+" ERROR: El identificador '"
                    + this.command.getSource()+ "' no coincide con ningun mailbox \n\n";            
        }
        this.saveLogMessRProcessReceive();    //save the log message in the receive process
        this.saveLogMessSourceQueue();        //save the log message in the source queue
    }

    //Removes message from Queue in Static mode
    public void  removeQueueStatic(Process receive_process) {
        //try {
            if (this.sincr_receive_opt == ConfigOptions.RECEIVE_BLOCKING.option 
                    || this.sincr_receive_opt == ConfigOptions.RECEIVE_TFA.option) {
                receive_process.setBlocked(true);
                receive_process.setReady(false);
                receive_process.setRunning(false);
                receive_process.setUnblockProcessID(this.command.getSource());
                
                this.output_message = this.time+" EXITOSO: El mensaje '"+ command.getMessage()
                        +"' en la cola '"+ command.getSource()+ "'"
                        + " se ha leido por el proceso '" + this.command.getProcessID()
                        + "' de forma exitosa \n\n";
                
                //sacar cola
                
            }
            else if (this.sincr_receive_opt == ConfigOptions.RECEIVE_NONBLOCKIN.option){
                
                this.output_message = this.time+" EXITOSO: El mensaje '"+ command.getMessage()
                        +"' en la cola '"+ command.getSource()+ "'"
                        + " se ha leido por el proceso '" + this.command.getProcessID()
                        + "' de forma exitosa \n\n";
                
                //sacar cola
            }
            
        /*}
        catch (Exception e) {
            
        }*/
    }
 
    //Removes message from Queue in Dynamic mode
    public void  removeQueueDynamic(Mailbox source_mailbox, Process receive_process) {
        //try {
            if (this.sincr_receive_opt == ConfigOptions.RECEIVE_BLOCKING.option 
                    || this.sincr_receive_opt == ConfigOptions.RECEIVE_TFA.option) {
                receive_process.setBlocked(true);
                receive_process.setReady(false);
                receive_process.setRunning(false);
                receive_process.setUnblockProcessID(this.command.getSource());
                
                this.output_message = this.time+" EXITOSO: El mensaje '"+ command.getMessage()
                        +"' en la cola '"+ command.getSource()+ "'"
                        + " se ha leido por el proceso '" + this.command.getProcessID()
                        + "' de forma exitosa \n\n";
                
                //sacar cola
                
            }
            else if (this.sincr_receive_opt == ConfigOptions.RECEIVE_NONBLOCKIN.option){
                
                this.output_message = this.time+" EXITOSO: El mensaje '"+ command.getMessage()
                        +"' en la cola '"+ command.getSource()+ "'"
                        + " se ha leido por el proceso '" + this.command.getProcessID()
                        + "' de forma exitosa \n\n";
                
                //sacar cola
            }         
        /*}
        catch (Exception e) {
            
        }*/      
    }
        
    //Finds mailbox by ID 
    public Mailbox getMailboxByID(String ID){
        Mailbox mail_find = null;
        for (Mailbox mail: this.mailboxes) {
            if(mail.getMailbox_id().equals(ID)){
                mail_find = mail;
                break;
            }
        }
        return mail_find;
    }
    
     //INDIRECT MODE FUNCTIONS END ********************************************
    // **********************************************************************  
    
      
     //FILE FUNCTIONS ********************************************
    // **********************************************************************
     
    //Load the commands in the file to the command buffer
    public void loadCommandsToBuffer(){
        try{
            ArrayList<String> buffer = new ArrayList<String>();
            Scanner myReader = new Scanner(this.command_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                buffer.add(data);
            }
            myReader.close();
            this.buffer_command = buffer;
        }
        catch(Exception e){
            System.out.println("An error occurred.");
        }
    }
    
    //Execute N commands in the buffer
    public void executeNBufferCommands(Principal_view command_v){
        int n = this.N_stop;
        while( n != 0 ){
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
            Date date = new Date();  
            String time = formatter.format(date);
            if(this.buffer_command.isEmpty()){
                String message = time+" Se han agotado los comandos del archivo...\n\n";
                command_v.writeInConsole(message);
                break;
            }
            else{
                String command = this.buffer_command.get(0);
                this.buffer_command.remove(0);
                this.executeCommand(command, time, command_v);
                n--;
            }
        }
    }
    
    //Execute all the commands in the buffer
    public void executeAllBufferCommands(Principal_view command_v){
        while( this.buffer_command.isEmpty() == false ){
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
            Date date = new Date();  
            String time = formatter.format(date);
            String command = this.buffer_command.get(0);
            this.buffer_command.remove(0);
            this.executeCommand(command, time, command_v);
        }
        String message = time+" Se han agotado los comandos del archivo...\n\n";
        command_v.writeInConsole(message);
    }
    //FILE END ********************************************
    // **********************************************************************
      
     
    public MessageLog getMessageLog() {
        return messageLog;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
        
    public ArrayList<Process> getProcesos() {
        return processes;
    }

    public ArrayList<Mailbox> getMailboxes() {
        return mailboxes;
    }

    public void setOutput_message(String output_message) {
        this.output_message = output_message;
    }

    public String getOutput_message() {
        return output_message;
    }

    public String getIndirect_opt() {
        return indirect_opt;
    }

    public void setIndirect_opt(String indirect_opt) {
        this.indirect_opt = indirect_opt;
    }

    public String getAddressing_type() {
        return addressing_type;
    }

    public File getCommand_file() {
        return command_file;
    }

    public void setCommand_file(File command_file) {
        this.command_file = command_file;
        this.loadCommandsToBuffer();
    }

    public int getN_stop() {
        return N_stop;
    }

    public void setN_stop(int N_stop) {
        this.N_stop = N_stop;
    }
    
    
}
