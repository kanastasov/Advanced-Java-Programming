package ajpportal;

/**UserAgent is responsible for
 *
 * @author Anastasov
 */
public class UserAgent extends MetaAgent {

    String name;
    
    public UserAgent(String name)
    {
        this.name = name;
    }
    
    public void messageRecieved(String message)
    {
        
        
    }
    
    
    public String getSender(String message)
    {
        
        return message;
    }
    
   public String getRecipient(String message)
    {
        
        return message;
    }
     
    public String getMessageBody(String message)
    {
        
        return message;
    }
      
    public String getMessageID(String message)
    {
        
        return message;
    }
    public String getSessionID(String message)
    {
        
        return message;
    }
}
