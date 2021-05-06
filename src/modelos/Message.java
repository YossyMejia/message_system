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
    Process sender;
    Process receiver;
    String message;
    int priority;
    LocalDateTime LocalDateTimeCreated;

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
    }// </editor-fold>

    public Message(Process sender, Process receiver, String message, int priority, LocalDateTime LocalDateTimeCreated) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.priority = priority;
        this.LocalDateTimeCreated = LocalDateTimeCreated;
    }
    
}
