
package modelos;

import java.time.*;
import utiles.ConfigOptions;


public class Message  implements Comparable<Message>{
    
    private Process sender;
    private Process receiver;
    private String message;
    private int priority;
    private LocalDateTime LocalDateTimeCreated;
    private String time;
    private String message_id; 
    private static String LENGTH_TYPE;
    private static int LENGTH;
    private static String MESSAGE_TYPE;

    
    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    public Process getSender() {
        return sender;
    }

    public void setSender(Process sender) {
        this.sender = sender;
    }

    public Process getReceiver() {
        return receiver;
    }

    public void setReceiver(Process receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDateTime getTimeCreated() {
        return LocalDateTimeCreated;
    }

    public void setTimeCreated(LocalDateTime LocalDateTimeCreated) {
        this.LocalDateTimeCreated = LocalDateTimeCreated;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
        
    }

    public LocalDateTime getLocalDateTimeCreated() {
        return LocalDateTimeCreated;
    }

    public void setLocalDateTimeCreated(LocalDateTime LocalDateTimeCreated) {
        this.LocalDateTimeCreated = LocalDateTimeCreated;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static String getLENGTH_TYPE() {
        return LENGTH_TYPE;
    }

    public static void setLENGTH_TYPE(String LENGTH_TYPE) {
        Message.LENGTH_TYPE = LENGTH_TYPE;
    }

    public static int getLENGTH() {
        return LENGTH;
    }

    public static void setLENGTH(int LENGTH) {
        Message.LENGTH = LENGTH;
    }

    public static String getMESSAGE_TYPE() {
        return MESSAGE_TYPE;
    }

    public static void setMESSAGE_TYPE(String MESSAGE_TYPE) {
        Message.MESSAGE_TYPE = MESSAGE_TYPE;
    }

    
// </editor-fold>

    //Constructor for the direct mode
     public Message(Process sender, Process receiver, String message, String time) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.checkMessageOptions();
        this.time = time;
    }
     
    public Message(Process sender, Process receiver, String message, int priority, LocalDateTime LocalDateTimeCreated, String id) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.checkMessageOptions();
        this.priority = priority;
        this.LocalDateTimeCreated = LocalDateTimeCreated;
        this.message_id = id;
    }
    
    //Constructor to set the lenght_type, the max length of the message and the type
    public Message(String LENGTH_TYPE, int LENGTH, String MESSAGE_TYPE){
        this.LENGTH = LENGTH;
        this.LENGTH_TYPE = LENGTH_TYPE;
        this.MESSAGE_TYPE = MESSAGE_TYPE;
    }
    
    //Constructor to set the lenght_type and the type of the messages
    public Message(String LENGTH_TYPE, String MESSAGE_TYPE){
        this.LENGTH_TYPE = LENGTH_TYPE;
        this.MESSAGE_TYPE = MESSAGE_TYPE;
    }
    
    public Message(){}
    
    //Check if the message have length type have been set as fixed, if its true take just 
    //the first N elements of the message
    public void checkMessageOptions(){
        if(this.LENGTH_TYPE == ConfigOptions.LENGTH_FIXED.option){
            this.message = this.message.substring(0,this.LENGTH+1);
        }
    }
    
    //Constructor for the indirect mode
    //PriorityQueue
    public Message(Process sender, String message, int priority, String time) {
        this.sender = sender;
        this.message = message;
        this.priority = priority;
        this.time = time;
        //this.message_id = id;
    }
 
    //Constructor for the indirect mode
    //FIFO
    public Message(Process sender, String message, String time) {
        this.sender = sender;
        this.message = message;
        this.priority = 1;
        this.time = time;
        //this.message_id = id;
    }    
    
    @Override
    public int compareTo(Message o) {
      return 0;
    }
}
