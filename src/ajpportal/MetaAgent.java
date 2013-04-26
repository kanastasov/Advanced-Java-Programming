package ajpportal;

/**
 * <p>MetaAgent represents the agents</p>
 *
 * <p>This program is part of the solution for the second ICA for AJP in
 * Teesside University.</p>
 *
 * <p>AJP middleware 2013-SOLUTION is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.</p>
 *
 * <p>This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.</p>
 *
 * <p>You should have received a copy of the GNU General Public License along
 * with this program. If not, see http://www.gnu.org/licenses/.</p>
 *
 * <p>Copyright Kiril Anastasov L1087591@live.tees.ac.uk 10-April-2013 </p>
 * <p>Copyright Chris </p> <p>Copyright Sean 13-Dec-2012 </p>
 */
class MetaAgent extends BlockingQueue implements Runnable {

    MetaAgent name;
    Portal portal;
    
    Thread thread;
    BlockingQueue bq;
//    LinkedBlockingQueue lbq =  new LinkedBlockingQueue();

    
    public MetaAgent()
    {
        
        
    }
    public MetaAgent(MetaAgent name, Portal portal)
    {
        super();
        this.name = name;
        this.portal = portal;
        
        msgHandler(bq.dequeue().toString());
        
        thread = new Thread()
        {
//            msgHandler(lbq.peek());
        };
       
    }
    
    
    public void msgHandler(String msg)
    {
//        reactive behaviour to messages
        
    }
    
    
    public void sendMessage(String recipient, String msg)
    {
     
        portal.enqueue(wrap(name,recipient,msg));
        
    }
    
    public String wrap(MetaAgent name, String recipient, String msg) {
        System.out.println(name + recipient + msg);
        return name + recipient + msg;
    }
    
    @Override
    public  void run() {
       //continually extract messages from the agent's queue 
//        pass them to the agen'ts message handler.
       
       
       
    }
        
}
