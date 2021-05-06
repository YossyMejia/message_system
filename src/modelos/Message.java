/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import java.time.*;

/**
 *
 * @author Adrian
 */
public class Message {
    
    private Process sender;
    private Process receiver;
    private String message;
    private int priority;
    private LocalDateTime LocalDateTimeCreated;
    private String message_id;

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
    }// </editor-fold>

    public Message(Process sender, Process receiver, String message, int priority, LocalDateTime LocalDateTimeCreated, String id) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.priority = priority;
        this.LocalDateTimeCreated = LocalDateTimeCreated;
        this.message_id = id;
    }
    
}
