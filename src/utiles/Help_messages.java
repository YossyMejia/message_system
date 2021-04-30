
package utiles;


public enum Help_messages {
    //Opciones sincronizacion
    SEND_BLOCK ("El proceso se bloquea.....");
    
    public final String message;
    
    private Help_messages(String message) {
        this.message = message;
    }
}
