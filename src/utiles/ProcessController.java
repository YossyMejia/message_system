
package utiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    
    private Command command;           //store the command object descomposed
    private MessageLog messageLog;
    private ArrayList<Message> messages = new ArrayList<Message>();
    private ArrayList<Process> processes = new ArrayList<Process>();
    private ArrayList<Mailbox> mailboxes = new ArrayList<Mailbox>();
    private String output_message; //The execution result message
    private String time; //The actual time 
    
    public ProcessController() {
        
    }
    
    //Initialize the configuration of the environment 
    public void setConfig(String sincr_receive_opt, String sincr_send_opt,
            String addressing_type, int cantidad_procesos){
        this.sincr_receive_opt = sincr_receive_opt;
        this.sincr_send_opt = sincr_send_opt;
        this.addressing_type = addressing_type;
        this.cantidad_procesos = cantidad_procesos;
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
                        +" invoca el comando, proceso destino: " + this.command.getDestination()
                        + " y el mensaje es: "+this.command.getMessage()+"\n\n";
                command_v.writeInConsole(message); //write in the view console
                sendCommand();
                command_v.writeInConsole(this.output_message); //write in the view console
            }
            
            else if(type == CommandTypes.RECEIVE_IMPLICIT.type){
                String message = time+" Tipo comando -> RECIVE IMPLICITO: el proceso "              //LOG
                        + this.command.getProcessID()+" invoca el comando \n\n";
                command_v.writeInConsole(message); //write in the view console
                //receiveImplicitCommand();
                command_v.writeInConsole(this.output_message); //write in the view console
            }
            else if(type == CommandTypes.RECEIVE_EXPLICIT.type){
                String message = time+" Tipo comando -> RECIVE EXPLICITO: el proceso "              //LOG
                        + this.command.getProcessID()+" invoca el comando, desea leer "
                        + "mensaje proveniente del proceso" + this.command.getSource() + " \n\n";
                command_v.writeInConsole(message); //write in the view console
                //receiveExplicitCommand();
                command_v.writeInConsole(this.output_message); //write in the view console
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
    
    
    //DIRECT MODE FUNCTIONS *************************************************
    // **********************************************************************
    
    //Choose what function call in base of the send option 
    public void DirectSendOpt(){
        
        try {
            Process send_process = this.getProcessByID(this.command.getProcessID());
            if(sincr_send_opt == ConfigOptions.SEND_NONBLOCKIN.option){
                send_process.setBlocked(false);
                send_process.setReady(true); 
            }
            else if(sincr_send_opt == ConfigOptions.SEND_BLOCK.option){
                send_process.setBlocked(true);
                send_process.setReady(false); 
            }
            this.directMessage(send_process);
            send_process.setRunning(false);
            this.processes.set(this.processes.indexOf(send_process), send_process);

        }
        catch(Exception e){
            this.output_message = this.time+" ERROR: El identificador '"
                    + this.command.getProcessID()+ "' no coincide con ningun proceso \n\n";
        }
        this.saveLogMessSendProcess();    //save the log message in the send process
        this.saveLogMessDestinationProcess(); //save the log message in the destination process
    }
    
    //create a message and send it to the destination process
    public void directMessage(Process send_process){
        try {
                Process destination_process = this.getProcessByID(this.command.getDestination());
                Message message = this.createMessageDirectMode(send_process, destination_process);
                this.sendMessageDirectMode(message, destination_process);
            }
            catch(Exception e){
                this.output_message = this.time+" ERROR: El mensaje '"+ this.command.getMessage()
                    +"' enviado por el proceso '"+this.command.getProcessID()+ "'"
                    + " no se ha entregado al proceso " + this.command.getDestination() 
                    + " debido a que no existe un proceso con ese identificador \n\n";
            }
    }
    
    //Create a message ONLY for the direct mode 
    public Message createMessageDirectMode(Process send_process, Process destination_process){
        Message message = new Message(send_process, destination_process, 
                this.command.getMessage(), this.time);
        return message;
    }
    
    //Send a message  ONLY for the direct mode 
    public void sendMessageDirectMode(Message message, Process destination_process){
        try{
            destination_process.saveMessageDirectMode(message);
            this.processes.set(this.processes.indexOf(destination_process), destination_process);
            this.output_message = this.time+" EXITOSO: El mensaje '"+ message.getMessage()
                    +"' enviado por el proceso '"+this.command.getProcessID()+ "'"
                    + " se ha entregado al proceso '" + this.command.getDestination() 
                    + "' de forma exitosa \n\n";
        }
        catch(Exception e){
            this.output_message = this.time+" ERROR: No se ha podido ingresar el"
                    + " mensaje '"+ message.getMessage()+ "' enviado por '"
                    +this.command.getProcessID() + "' al buzon del proceso '"
                    +this.command.getDestination() + "\n\n";
        }
        
    }
            
    //Save the log messages in the send and destination process, ONLY for the direct mode 
    public void saveLogMessSendProcess(){
        try{
            Process send_process = this.getProcessByID(this.command.getProcessID());
            String extra_message = "PROCESO_ESTADO: Bloqueado: "
                    + send_process.getBlocked() + " , Preparado: "
                    + send_process.getReady() + " , Corriendo: "
                    + send_process.getRunning() + "\n\n";
            send_process.saveLogMessage(this.output_message + extra_message);
            this.processes.set(this.processes.indexOf(send_process), send_process);
        }
        catch(Exception e){}
    }
    
    public void saveLogMessDestinationProcess(){
        try{
            Process destination_process = this.getProcessByID(this.command.getDestination());
            String extra_message = "PROCESO_ESTADO: Bloqueado: "
                    + destination_process.getBlocked() + " , Preparado: "
                    + destination_process.getReady() + " , Corriendo: "
                    + destination_process.getRunning() + "\n\n";
            destination_process.saveLogMessage(this.output_message + extra_message);
            this.processes.set(this.processes.indexOf(destination_process), destination_process);
        }
        catch(Exception e){}
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
            String id =  "p"+Integer.toString(cantidad_mailboxes);
            Mailbox mailbox = new Mailbox(id, largo_cola);
            this.mailboxes.add(mailbox);
            cantidad_mailboxes -= 1;
        }
    }      
    
    public void IndirectSendOpt(){
        //Aqui se preguntan las condiciones que deben ser preguntadas para
        //decidir como enviar los datos a la cola, no esta implementado aun 
        //primero se esta implementando la parte de entrega de mensajes sin un 
        //mailbox asociado
        //"NOT IMPLEMENTED YET";
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
    public MessageLog getMessageLog() {
        return messageLog;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
        
    public ArrayList<Process> getProcesos() {
        return processes;
    }

    public String getOutput_message() {
        return output_message;
    }

    public String getAddressing_type() {
        return addressing_type;
    }
    
    
}
