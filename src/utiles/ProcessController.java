
package utiles;

import java.util.ArrayList;
import modelos.Proceso;


public class ProcessController {
    
    //Variables
    private int cantidad_procesos;
    private String sincr_receive_opt;
    private String sincr_send_opt;
    private ArrayList<Proceso> procesos = new ArrayList<Proceso>();
    public ProcessController() {
        
    }
    
    //Initialize the configuration of the environment 
    public void setConfig(String sincr_receive_opt, String sincr_send_opt, 
            int cantidad_procesos){
        this.sincr_receive_opt = sincr_receive_opt;
        this.sincr_send_opt = sincr_send_opt;
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
            String id =  "Proceso ID #"+Integer.toString(cantidad_procesos);
            Proceso proceso = new Proceso(id);
            this.procesos.add(proceso);
            cantidad_procesos -= 1;
        }
    }

    
    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }
    
    //Return the process that match with the ID
    public Proceso getProcessByID(String ID){
        Proceso proc_find = null;
        for (Proceso proceso: this.procesos) {
            if(proceso.getProces_id() == ID){
                proc_find = proceso;
                break;
            }
        }
        return proc_find;
    }
    
    //Execute a command and return a output based on the result of the execution 
    public String executeCommand(String command_input, String time){
        Command command = new Command(command_input);
        if (command.getCorrect() == true){
            String type = command.getCommand_type();
            if(type == CommandTypes.SEND.type){
                //aqui llamar funcion de send y hacer las comparaciones o cal
                //culos que se necesiten segun la configuracion del usuario
                
                String message = time+" SEND: el comando es de tipo send el destination es: "
                        + command.getDestination()+ " y el mensaje es: "+command.getMessage()+"\n";
                return message;
            }
            else if(type == CommandTypes.RECEIVE.type){
                //aqui llamar funcion de receive y hacer las comparaciones o cal
                //culos que se necesiten segun la configuracion del usuario
                
                String message = time+" RECEIVE: el comando es de tipo receive el source es: "
                        + command.getSource() + " y el mensaje es: "+command.getMessage()+"\n";
                return message;
            }
        }
        else{
            String error_message = time+" ERROR: sintaxis del comando ''"
                    + command.getCommand_input() +"'' erronea \n";
            //TODO: GUARDAR COMANDO EN EL ARCHIVO DE LOG
            return error_message;
        }
        String error_message = time+" ERROR: ejecutando el siguiente comando ''"
                    + command.getCommand_input() +"'' \n";
        //TODO: GUARDAR COMANDO EN EL ARCHIVO DE LOG
        return error_message;
    }
    
    
}
