
package utiles;

//Enum con los distintos tipos de comandos
public enum CommandTypes {
    SEND ("SEND"),
    RECEIVE_EXPLICIT ("EXPLICIT RECEIVE"),
    RECEIVE_IMPLICIT ("IMPLICIT RECEIVE"),
    READ ("READ"),
    CONTINUE ("CONTINUE");
    
    public final String type;
    
    private CommandTypes(String type) {
        this.type = type;
    }
}