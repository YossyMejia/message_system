
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
            + "de prioridad, los de prioridad mas alta  son los primeros en salir. <br>"
            + "Si el modo es estático el índice del proceso y del mailbox <br>"
            + "deben ser el mismo. </html>" ),
    
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
            + "especifica quien debe ser el proceso del que se recibe un mensaje <br>"
            + "y si es implicito el proceso leera el primer mensaje almacenado en el buffer.</html>" ),
    
    ADDRESSING_INDIRECT ("<html>Direccionamiento indirecto estatico es que  <br>"
            + " existe una cola por proceso receptor mientras que en dinamico <br>"
            + " un proceso puede tomar mensajes de varias colas.</html>" ),
    
    COMMAND_HELP ("<html>La sintaxis de los comandos es la siguiente: <br>"
            + "Modo Directo: <br>"
            + "- pID.send(pID2, message) comando para enviar mensaje, pID es el <br>"
            + "proceso que envia el mensaje, pID2 es el proceso que lo recibe y <br> "
            + "message es el mensaje a enviar.<br>"
            + "- pID.receive() comando para hacer un receive implicito, donde pID es <br>"
            + "el proceso que desea hacer el receive. <br>"
            + "- pID.receive(pID2) comando para hacer un receive explicito, donde <br>"
            + "pID es el proceso que desea hacer el receive y pID2 el proceso del que"
            + "desea recibir. <br>"
            + "Modo Indirecto: <br>"
            + "- pID.send(mID2, message) comando para enviar mensaje, pID es el <br>"
            + "proceso que envia el mensaje, mID2 es el mailbox que lo recibe y <br> "
            + "message es el mensaje a enviar.<br>"
            + "- pID.receive(mID2) comando para hacer un receive, donde <br>"
            + "pID es el proceso que desea hacer el receive y mID2 el mailbox del que <br>"
            + "desea tomar un mensaje. <br>"
            + "Lectura de archivos: <br>"
            + "- read() despues de cargar un archivo de texto se ejecutan sus comandos, <br>"
            + "se ejecutaran los N comandos especificados por el usuario en el apartado <br>"
            + "de cargar documento.<br>"
            + "- continue() en caso de que el usuario especifique detener la ejecucion <br>"
            + "de los comandos del archivo de texto podra continuar con la ejecucion <br>"
            + "de los N siguientes comandos con este comando.</html>"),
    
    PROCESS_LOG_HELP ("<html>El usuario tiene la posibilidad de elegir un proceso <br>"
            + "para poder ver su estado acutal y los mensajes LOG asociados a <br>"
            + "este proceso y con los que ha tenido interaccion.</html>"),
    
    N_COMMAND_HELP ("<html>El usuario tiene la posibilidad de ingresar cada cuantos <br>"
            + "comandos se debe para la ejecucion de los comandos del archivo <br> "
            + "y esperar que el usuario decida continuarla (con el comando continue()).<br>"
            + "Si el usuario ingresa 0 se ejecutara todo el archivo.</html>"),
    
    FILE_READER_HELP("<html>El usuario tiene la posibilidad de elegir un archivo <br>"
            + "de texto del cual quiere leer comandos para el sistema de mensajes.</html>");
    
    

    public final String message;
    
    private HelpMessages(String message) {
        this.message = message;
    }
}
