
package utiles;


public enum HelpMessages {
    //Mensajes ayuda 
    SINCRONIZATION_SEND ("<html>Se tienen dos opciones a elegir, si se elige blocking "
            + "el proceso se bloqueara el enviar un mensaje<br> hasta recibir "
            + "confirmacion de que fue recibido, si se elije "
            + "nonblocking el proceso no se bloquea al enviar mensajes.</html>"),
    
    SINCRONIZATION_RECEIVE ("<html>Se tienen tres opciones a elegir, si se elige blocking "
            + "el proceso se bloqueara hasta que reciba un mensaje de otro proceso,<br> "
            + "la opcion de nonblocking es que el proceso continua haciendo cosas "
            + "aunque no haya recibido ningun mensaje y por ultimo en la opcion<br> "
            + "prueba de llegada el proceso esta bloqueado pero se mantiene preguntando "
            + "constantemente si ha recibido mensajes.</html>" ),
    
    FORMAT_CONTENT ("<html>Se elige el contenido que va a tener el mensaje por "
            + "ejemplo <br> si se elige la opcion 'texto' el mensaje tendra unicamente "
            + "texto en su contenido.</html>" ),
    
    FORMAT_LENGHT ("<html>Indica si el contenido del mensaje va a tener un largo "
            + "fijo o si puede ser variable, en caso de <br> seleccionar fijo se debe "
            + "tambien indicar el largo del mensaje.</html>" ),
    
    QUEQUE_DISCIPLINE ("<html>Indica la forma en la que la cola de mensajes va a ser "
            + "leida, la opcion de FIFO <br> trabaja de la forma que su nombre lo indica "
            + "donde el primer mensaje en entrar es <br> el primero en salir de la cola, "
            + "la otra opcion Priority elige el mensaje en salir <br> segun su nivel "
            + "de prioridad, los de prioridad mas alta  son los primeros en salir.</html>" ),
    
    PROCESS_QUANTITY ("<html>Se ingresa la cantidad de procesos que se desea"
            + " que tenga la aplicacion.</html>" ),
    
    QUEUE_SIZE ("<html>Se ingresa el tamaño que se desea que tenga la cola en <br>"
            + "la aplicacion. Por ejemplo si se especifica que la cola tiene <br>"
            + "tamaño 3 unicamente podra almacenar un maximo de 3 mensajes. </html>" ),
    
    MAILBOX_QUANTITY ("<html>Se ingresa la cantidad de mailbox que se desea que <br>"
            + "tenga la aplicacion. Por ejemplo si se eligen 2 mailbox entonces <br>"
            + "los procesos podran elegir a cual de los dos enviar el mensaje.</html>" ),
    
    ADDRESSING_TYPE ("<html>Dice si el direccionamiento es directo o indirecto. <br>"
            + "Directo en general significa que la comunicación es de proceso a <br>"
            + "proceso, por lo tanto los procesos involucrados en la comunicación <br>"
            + "están claramente definidos y en el indirecto interviene lo que se <br>"
            + "dice mailbox, el mensaje se envía a un mailbox (cola) donde queda <br>"
            + "a la espera que un proceso llegue a recogerlo.</html>" ),
    
    ADDRESSING_RECEIEVE ("<html>En esta opcion se debe elegir si el direccionamiento <br>"
            + "al proceso que se recibe es explicito o implicito, si es explicito se <br>"
            + "especifica quien debe ser el proceso que reciba el mensaje y si es <br>"
            + "implicito el proceso que recibe el mensaje es el que informa cuando <br>"
            + "recibe el mensaje y de quien lo recibe.</html>" ),
    
    ADDRESSING_INDIRECT ("<html>PREGUNTAR AUN NO ESTOY SEGURO</html>" );
    
    

    public final String message;
    
    private HelpMessages(String message) {
        this.message = message;
    }
}
