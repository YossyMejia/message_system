
package utiles;

//Enum con los distintos tipos de comandos
public enum CommandTypes {
    SEND ("SEND"),
    RECEIVE ("RECEIVE");
    
    public final String type;
    
    private CommandTypes(String type) {
        this.type = type;
    }
}