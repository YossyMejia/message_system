/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.PriorityQueue;

/**
 *
 * @author Adrian
 */
public class Mailbox {
    
    String name;
    PriorityQueue queue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriorityQueue getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue queue) {
        this.queue = queue;
    }

    public Mailbox(String name, PriorityQueue queue) {
        this.name = name;
        this.queue = queue;
    }
    
    
}
