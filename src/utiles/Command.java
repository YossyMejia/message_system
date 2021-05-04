
package utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Command {
    private String command_input;
    private String command_type;
    private String message;
    private String destination;
    private String source;
    private Boolean correct;

    public Command(String command_input) {
        this.command_input = command_input;
        this.check_command();
    }
    
    //Verify with regular expressions if the command input is correct to extract
    //the information otherwise set the variable correct to false
    public void check_command(){
        Pattern pattern_send = Pattern.compile("send(\\s*)[(](\\s*)"
                + "[a-zA-Z0-9\\s*\\S]+(\\s*),(\\s*)[a-zA-Z0-9\\s*\\S]+(\\s*)[)]");
        
        Pattern pattern_receive = Pattern.compile("receive(\\s*)[(](\\s*)"
                + "[a-zA-Z0-9\\s*\\S]+(\\s*),(\\s*)[a-zA-Z0-9\\s*\\S]+(\\s*)[)]");
        
        Matcher match_send = pattern_send.matcher(this.command_input);   
        Matcher match_receive = pattern_receive.matcher(this.command_input);  
        
        
        if (match_send.matches()) {
            this.correct = true;
            this.extractSendData();
            
        } 
        else if (match_receive.matches()) {
            this.correct = true;
            this.extractReceiveData();
        }
        else{
            this.correct = false;
        }
    }
     
   //Exctract the send important data in the command using regular expressions
    public void extractSendData(){
        Pattern pattern_destination = Pattern.compile("(?<=\\().*(\\s*)"
                    + "[a-zA-Z0-9\\s*\\S]+(\\s*)(?=,)");
        Pattern pattern_message = Pattern.compile("(?<=\\,).*(\\s*)"
                + "[a-zA-Z0-9\\s*\\S]+(\\s*)(?=\\))");
            
        Matcher matcher_destination = pattern_destination.matcher(this.command_input);
        matcher_destination.find();
        
        Matcher matcher_message = pattern_message.matcher(this.command_input);
        matcher_message.find();
        
        this.command_type = CommandTypes.SEND.type;
        this.destination = matcher_destination.group();
        this.message = matcher_message.group();
    }
    
    //Exctract the receive important data in the command using regular expressions
    public void extractReceiveData(){
        Pattern pattern_source = Pattern.compile("(?<=\\().*(\\s*)"
                    + "[a-zA-Z0-9\\s*\\S]+(\\s*)(?=,)");
        Pattern pattern_message = Pattern.compile("(?<=\\,).*(\\s*)"
                + "[a-zA-Z0-9\\s*\\S]+(\\s*)(?=\\))");
            
        Matcher matcher_source = pattern_source.matcher(this.command_input);
        matcher_source.find();
        
        Matcher matcher_message = pattern_message.matcher(this.command_input);
        matcher_message.find();
        
        this.command_type = CommandTypes.RECEIVE.type;
        this.destination = matcher_source.group();
        this.message = matcher_message.group();
    }

    //Getters
    public Boolean getCorrect() {
        return correct;
    }

    public String getCommand_type() {
        return command_type;
    }

    public String getCommand_input() {
        return command_input;
    }

    public String getMessage() {
        return message;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }
    
    
}
