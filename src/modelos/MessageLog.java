/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class MessageLog {
    
    private ArrayList<Message> messages = new ArrayList<Message>();
    private ArrayList<String> log_messages = new ArrayList<String>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<String> getLog_messages() {
        return log_messages;
    }

    public void setTexts(ArrayList<String> texts) {
        this.log_messages = texts;
    }
    
    public void saveLogMessage(String message){
        this.log_messages.add(message);
    }
    public MessageLog() {
    }

    
}
