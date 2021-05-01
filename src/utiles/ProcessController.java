
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
    
    //Create the N processes specified by the user 
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
    
    //Return the process that mathc with the ID
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
    
}
