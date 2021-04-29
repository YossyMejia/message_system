
package modelos;

import java.util.ArrayList;

public class Proceso {
    
    private String send_block_type;
    private String receive_block_type;
    private Boolean blocked;
    private ArrayList<String> mensajes_leidos = new ArrayList<String>();    //TODO: Hacer que sea de tipo mensaje
    private ArrayList<String> mensajes_enviados = new ArrayList<String>();
    private String proces_id;

    public Proceso(String id) {
        this.proces_id = id;
    }

    public String getSend_block_type() {
        return send_block_type;
    }

    public void setSend_block_type(String send_block_type) {
        this.send_block_type = send_block_type;
    }

    public String getReceive_block_type() {
        return receive_block_type;
    }

    public void setReceive_block_type(String receive_block_type) {
        this.receive_block_type = receive_block_type;
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
