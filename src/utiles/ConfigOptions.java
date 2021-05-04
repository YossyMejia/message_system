
package utiles;

//Enum con las distintas opciones de las variables de configuracion
public enum ConfigOptions {
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
    
    private ConfigOptions(String opcion) {
        this.opcion = opcion;
    }
}
