/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 * @author XPC
 */
public enum Opciones {
    //Opciones sincronizacion
    SEND_BLOCK ("Blocking"),
    SEND_NONBLOCKIN("Nonblocking"),
    RECEIVE_BLOCKING("Blocking"),
    RECEIVE_NONBLOCKIN("Nonblocking"),
    RECEIVE_TFA("Prueba de llegada"),
    //Opciones Addressing
    RECEIVE_EXPLICIT("Explicito"),
    RECEIVE_IMPLICIT("Implicito"),
    INDIRECT_STATIC("Estatico"),
    INDIRECT_DINAMIC("Dinamico"),
    //Opciones formato
    LENGTH_FIXED("Fijo"),
    LENGTH_VARIABLE("Variable"),
    //Opciones cola
    DISCIPLINE_FIFO("FIFO"),
    DISCIPLINE_PRIORITY("Prioridad");
    
    public final String opcion;
    
    private Opciones(String opcion) {
        this.opcion = opcion;
    }
}
