
package utiles;

import java.util.ArrayList;
import modelos.Proceso;


public class Configurador {
    
    //Variables
    private int cantidad_procesos;
    private String sincr_receive_opt;
    private String sincr_send_opt;
    private ArrayList<Proceso> procesos = new ArrayList<Proceso>();
    
    public Configurador() {
        
    }
    
    public void setConfig(String sincr_receive_opt, String sincr_send_opt, 
            int cantidad_procesos){
        
        this.sincr_receive_opt = sincr_receive_opt;
        this.sincr_send_opt = sincr_send_opt;
        this.cantidad_procesos = cantidad_procesos;
    }
    
    public void create(){
        this.createProcesses();
    }
    
    public void createProcesses(){
        while (cantidad_procesos != 0){
            String id =  "Proceso ID #"+Integer.toString(cantidad_procesos);
            Proceso proceso = new Proceso(id);
            this.procesos.add(proceso);
        }
    }
}
