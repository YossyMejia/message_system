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
public class Process {
    String name;
    String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void sendMessage(){
    };

    public void receiveMessage(){
    };
    
    public Process(String name, String state) {
        this.name = name;
        this.state = state;
    }
    
    
}
