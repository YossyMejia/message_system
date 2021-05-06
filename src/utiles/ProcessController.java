
package utiles;

import java.util.ArrayList;
import modelos.Process;
import modelos.*;


public class ProcessController {
    
    //Variables
    private int cantidad_procesos;  //quantity of process specified by the user
    private String sincr_receive_opt;  //sincronization recevie option (could be blocking, nonblocking, test for arrival
    private String sincr_send_opt;     //sincronization send option (could be blocking, nonblocking)
    private String addressing_type;    //addressing type (could be direct or indirect) 
    private Command command;           //store the command object descomposed
    private MessageLog messageLog;
    private ArrayList<Message> messages = new ArrayList<Message>();
    private ArrayList<Process> processes = new ArrayList<Process>();
    private String output_message; //The execution result message
    
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
    public void executeCommand(String command_input, String time){
        Command command = new Command(command_input);
        this.command = command;
        if (this.command.getCorrect() == true){
            String type = this.command.getCommand_type();   
            
            if(type == CommandTypes.SEND.type){
                sendCommand();;
            }
            
            else if(type == CommandTypes.RECEIVE.type){
                //aqui llamar funcion de receive y hacer las comparaciones o cal
                //culos que se necesiten segun la configuracion del usuario, aun no implementada
                String message = time+" RECEIVE: el proceso "+ command.getProcessID()+" invoca el comando es de tipo receive el source es: "
                        + command.getSource() + " y el mensaje es: "+command.getMessage()+"\n";
                this.output_message = message;
            }
        }
        
        else{
            String error_message = time+" ERROR: algo resulto mal ejecutando el comando''"
                    + command.getCommand_input() +"'' \n";
            //TODO: GUARDAR output_message y comando EN EL ARCHIVO DE LOG
            this.output_message = error_message;
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
    
    //Choose what function call in base of the send option 
    public void DirectSendOpt(){
        if(sincr_send_opt == ConfigOptions.SEND_BLOCK.option){
            try {
                Process p = this.getProcessByID(this.command.getProcessID());
                p.setBlocked(false);
                p.setRunning(true); 
                //this.sendMessage()            //Aqui se deberia enviar el mensaje al proceso receptor this.command.getDestination()
                p.setRunning(false);
                this.processes.set(this.processes.indexOf(p), p);
                System.out.println(this.processes.indexOf(p));
            }
            catch(Exception e){
                this.output_message = "ERROR: El identificador de proceso no coincide";
            }
        }
        else if(sincr_send_opt == ConfigOptions.SEND_NONBLOCKIN.option){
            //Implementacion cuando el send esta en blocking
            this.output_message = "Opcion unblock";
        }
    }
    
    
    public void IndirectSendOpt(){
        //Aqui se preguntan las condiciones que deben ser preguntadas para
        //decidir como enviar los datos a la cola, no esta implementado aun 
        //primero se esta implementando la parte de entrega de mensajes sin un 
        //mailbox asociado
        //"NOT IMPLEMENTED YET";
    }

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
}
