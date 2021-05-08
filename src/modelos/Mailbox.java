
package modelos;

import java.util.PriorityQueue;

/**
 *
 * @author Adrian
 */
public class Mailbox {
    
    private PriorityQueue queue;
    private String mailbox_id;

    public String getMailbox_id() {
        return mailbox_id;
    }

    public void setMailbox_id(String mailbox_id) {
        this.mailbox_id = mailbox_id;
    }

    public PriorityQueue getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue queue) {
        this.queue = queue;
    }

    public Mailbox(String id, PriorityQueue queue) {
        this.mailbox_id = id;
        this.queue = queue;
    }
    
    public Mailbox(String id, int size) {
        this.mailbox_id = id;
        this.queue = new PriorityQueue(size);
    }      
    
   
    public Mailbox(String id) {
        this.mailbox_id = id;
        //this.queue = new PriorityQueue();
    }
    
    public void createQueue(int size) {
        this.queue = new PriorityQueue(size);
        
    }
}
