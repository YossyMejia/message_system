
package modelos;

import java.util.ArrayList;

public class Process {
    
    private Boolean blocked = false;
    private Boolean ready = true;
    private Boolean running = false;
    private ArrayList<Message> buffer_messages = new ArrayList<Message>();
    private ArrayList<String>  log_messages = new ArrayList<String>(); //no cambiar el tipo del arrelgo esta en uso
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

    public ArrayList<Message> getBuffer_messages() {
        return buffer_messages;
    }

    public void setBuffer_messages(ArrayList<Message> buffer_messages) {
        this.buffer_messages = buffer_messages;
    }
 
    public String getProcess_id() {
        return process_id;
    }

    public void setProcess_id(String proces_id) {
        this.process_id = proces_id;
    }

    public ArrayList<String> getLog_messages() {
        return log_messages;
    }
    
    
    public void saveMessageDirectMode(Message message){
        this.buffer_messages.add(message);
    }
    
    public void saveLogMessage(String message){
        this.log_messages.add(message);
    }
    
}
