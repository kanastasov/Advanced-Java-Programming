package ajpportal;

import java.util.HashMap;

/**
 * <p>Portal represents the portals which allow the agents to communicate.</p>
 *
 * <p>This program is part of the solution for the second ICA for AJP in Teesside
 * University.</p>
 *
 * <p>AJP middleware 2013-SOLUTION is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.</p>
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
 * <p>Copyright Chris </p>
 * <p>Copyright Sean 13-Dec-2012 </p>
 */ 
public class Portal extends MetaAgent {
    

    
    /**
     * routingTable
     */
    
    HashMap routingTable;
    
    Portal portal;

    public void msgHandler(String msg) {
        routingTable.get(portal.enqueue(msg));
    }

    public void addAgent(Agent agent, Character scope) {
        
        String agentName = agent.getName();
        
//        routingTable.set(name, agent);
         routingTable.put(agentName, agent);
         
         
    }

    
     /**
     * associates an agent with this portal
     *
     * @param agent
     */
    public void addAgent(Agent agent) {
        addAgent(agent, LOCAL);
    }
    
    
    public String sendMessage(String to, String msg)
    {
        
        return to + msg;
    }
    
    /**
     * forward message to named agent
     *
     * @param from name of agent to send message
     * @param to name of agent to recieve message
     * @param msg the message
     * @param id the message id
     * @return
     */
    public String sendMessage(String from, String to, String msg, String id) {

        //incomplete

        return "forward message to named agent";
    }
    
  
    public String sendReply(MsgId msgId, String msgReply)
    {
        
        
        return msgReply;
    }
    
    

//    public Portal enqueue(String wrap) {
//
//        return new Portal();
//    }
}
