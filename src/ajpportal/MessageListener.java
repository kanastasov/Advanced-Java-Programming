package ajpportal;

/** MessageListener is responsible for 
 *
 * @author Anastasov
 */
public interface MessageListener {
    public abstract void messageReceived(String s, String s1, String s2, MsgId msgid);
}
