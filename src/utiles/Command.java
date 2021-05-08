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
    private String processID;

    public Command(String command_input) {
        this.command_input = command_input;
        this.check_command();
    }
    
    
    //Verify with regular expressions if the command input is correct to extract
    //the information otherwise set the variable correct to false
    public void check_command(){
        Pattern pattern_send = Pattern.compile("[a-zA-Z0-9\\s*\\S]+.send(\\s*)[(](\\s*)"
                + "[a-zA-Z0-9\\s*\\S]+(\\s*),(\\s*)[a-zA-Z0-9\\s*\\S]+(\\s*)[)]");
        
        Pattern pattern_receive_explicit = Pattern.compile("[a-zA-Z0-9\\s*\\S]+."
                + "receive(\\s*)[(][a-zA-Z0-9\\S]+[)]");
        
        Pattern pattern_receive_implicit = Pattern.compile("[a-zA-Z0-9\\s*\\S]+."
                + "receive(\\s*)[(][)]");
        
        Matcher match_send = pattern_send.matcher(this.command_input);   
        Matcher match_receive_explicit = pattern_receive_explicit.matcher(this.command_input);  
        Matcher match_receive_implicit = pattern_receive_implicit.matcher(this.command_input); 
        
        if (match_send.matches()) {
            this.correct = true;
            this.extractSendData();
            
        } 
        else if (match_receive_explicit.matches()) {
            this.correct = true;
            this.extractReceiveExplicitData();
        }
        else if(match_receive_implicit.matches()){ 
            this.correct = true;
            this.extractReceiveImplicitData();
        }
        else{
            this.correct = false;
        }
    }
     
    //Extract the procces ID in the command
    public String extractProcessID(){
        Pattern pattern_process = Pattern.compile("^([^.]+)");
        
        Matcher matcher_process = pattern_process.matcher(this.command_input);
        matcher_process.find();
        
        return matcher_process.group();
    }
    
    //Extract the first atribute of the command
    public String extractFirstAtribute(){
        Pattern pattern_firstAtribute = Pattern.compile("(?<=\\().*(\\s*)"
                    + "[a-zA-Z0-9\\s*\\S]+(\\s*)(?=,)");
        
        Matcher matcher_firstAtribute = pattern_firstAtribute.matcher(this.command_input);
        matcher_firstAtribute.find();
        
        return matcher_firstAtribute.group();
    }
    
    //Extract the second atribute of the command
    public String extractSecondAtribute(){
        Pattern pattern_secondAtribute = Pattern.compile("(?<=\\,).*(\\s*)"
                + "[a-zA-Z0-9\\s*\\S]+(\\s*)(?=\\))");
        
        Matcher matcher_secondAtribute = pattern_secondAtribute.matcher(this.command_input);
        matcher_secondAtribute.find();
        
        return matcher_secondAtribute.group();
    }
    
    //Extract the unique atribute in the command
    public String extractUniqueAtribute(){
        Pattern pattern_uniqueAtribute = Pattern.compile("(?<=\\().*"
                + "[a-zA-Z0-9\\S]+(?=\\))");
        
        Matcher matcher_uniqueAtribute = pattern_uniqueAtribute.matcher(this.command_input);
        matcher_uniqueAtribute.find();
        
        return matcher_uniqueAtribute.group();
    }
    
   //Asign the send important data in the command
    public void extractSendData(){
        this.command_type = CommandTypes.SEND.type;
        this.processID = this.extractProcessID();
        this.destination = this.extractFirstAtribute();
        this.message = this.extractSecondAtribute();
    }
    
    //Asign the extracted information of the command in the variables
    public void extractReceiveExplicitData(){
        this.command_type = CommandTypes.RECEIVE_EXPLICIT.type;
        this.processID = this.extractProcessID();
        this.source = this.extractUniqueAtribute();
    }
    
    //Asign the extracted information of the command in the variables
    public void extractReceiveImplicitData(){
        this.command_type = CommandTypes.RECEIVE_IMPLICIT.type;
        this.processID = this.extractProcessID();
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

    public String getProcessID() {
        return processID;
    }
}