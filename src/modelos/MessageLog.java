/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Adrian
 */
public class MessageLog {
    
    Message message[];

    public Message[] getMessage() {
        return message;
    }

    public void setMessage(Message[] message) {
        this.message = message;
    }

    public MessageLog(Message[] message) {
        this.message = message;
    }    
    
}
