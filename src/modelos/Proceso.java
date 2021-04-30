
package modelos;

import java.util.ArrayList;

public class Proceso {
    
    private Boolean blocked;
    private ArrayList<String> mensajes_leidos = new ArrayList<String>();    //TODO: Hacer que sea de tipo mensaje el arraylist no tipo string
    private ArrayList<String> mensajes_enviados = new ArrayList<String>();
    private String proces_id;

    public Proceso(String id) {
        this.proces_id = id;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public ArrayList<String> getMensajes_leidos() {
        return mensajes_leidos;
    }

    public void setMensajes_leidos(ArrayList<String> mensajes_leidos) {
        this.mensajes_leidos = mensajes_leidos;
    }

    public ArrayList<String> getMensajes_enviados() {
        return mensajes_enviados;
    }

    public void setMensajes_enviados(ArrayList<String> mensajes_enviados) {
        this.mensajes_enviados = mensajes_enviados;
    }

    public String getProces_id() {
        return proces_id;
    }

    public void setProces_id(String proces_id) {
        this.proces_id = proces_id;
    }
    
    
    
    
}
