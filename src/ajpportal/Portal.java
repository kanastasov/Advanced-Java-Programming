package ajpportal;

import sun.management.Agent;

/**
 * <p>Portal represents the portals which allow the agents to communicate.</p>
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
public class Portal extends MetaAgent {

    /**
     * routingTable is hashing structure which maps agent names onto their
     * queues (or their agent instances).
     */
    MetaAgent routingTable;
    Portal portal;

    public Portal(String portalName) {
        super();
    }

    public void msgHandler(String msg) {
        routingTable.get(portal.enqueue(msg));

    }

    /**
     * associates an agent with this portal
     *
     * @param agent the agent itself (not just its name!)
     * @param agentScope indicates the visibility of an agent, this can be as
     * follows : Poral.GLOBAL/LOCAL/INTERNAL Portal.GLOBAL - the agent is
     * visible (can be messaged) by all other agents; Portal.LOCAL - the agents
     * is visible only to other agents whose portals are connected to the same
     * router. ie: the local router will not inform other routers about this
     * agent; Portal.INTERNAL - the agent is internal to the portal, the portal
     * will not advertise the extance of this agent to its router or to other
     * portals
     */
    public void addAgent(Agent agent, Character agentScope) {
    }

    /**
     * associates an agent with this portal
     *
     * @param agent
     */
    public void addAgent(Agent agent) {
    }

//    public void addAgent(String name, MetaAgent agent) {
//        routingTable.set(name, agent);
//
//        Portal portal = null;
//        String msg = null;
//        MetaAgent recipient = null;
//
//        agent.sendMessage(recipient, msg);
//        portal.enqueue(wrap(name, recipient, msg));
//
//    }
    /**
     * forward message to named agent
     *
     * @param from name of agent to send message
     * @param to name of agent to recieve message
     * @param msg the message
     * @return
     */
    public String sendMessage(String from, String to, String msg) {

        //incomplete

        return "forward message to named agent";
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

    /**
     * called whenever the portal receives a message through its socket, this
     * method takes a raw message in String form (ie: in the form the message is
     * transmitted)
     *
     * @param rawMsg the msg
     */
    public void messageRecieved(String rawMsg) {
    }

    /**
     * called as a message is delivered to an agent, with non-cloned agents this
     * might occur sometime after the portal first receives the message since
     * processingMessage will only be called after a message is de-queued
     *
     * @param from
     * @param to
     * @param msg
     * @param msgId
     */
    public void processingMessage(String from, String to, String msg, String msgId) 
    {
        
        
    }

    public String wrap(String name, MetaAgent portal, String msg) {
        return "x";
    }

    public Portal enqueue(String wrap) {

        return new Portal("PortalName");
    }
}
