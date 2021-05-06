
package modelos;

import java.util.ArrayList;

public class Process {
    
    private Boolean blocked;
    private Boolean ready;
    private Boolean running;
    private ArrayList<String> buffer_messages = new ArrayList<String>();    //TODO: Hacer que sea de tipo Mensaje el arraylist no tipo string
    //private ArrayList<String> mensajes_enviados = new ArrayList<String>();
    private String process_id;

    public Process(String id) {
        this.process_id = id;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public ArrayList<String> getBuffer_messages() {
        return buffer_messages;
    }

    public void setBuffer_messages(ArrayList<String> buffer_messages) {
        this.buffer_messages = buffer_messages;
    }

   
    public String getProcess_id() {
        return process_id;
    }

    public void setProcess_id(String proces_id) {
        this.process_id = proces_id;
    }
    
    
    
    
}
