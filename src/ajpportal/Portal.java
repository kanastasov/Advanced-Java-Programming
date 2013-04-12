package ajpportal;

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

    MetaAgent routingTable;
    Portal portal;

    public void msgHandler(String msg) {
        routingTable.get(portal.enqueue(msg));
    }

    public void addAgent(String name, MetaAgent agent) {
        routingTable.set(name, agent);

        Portal portal = null;
        String msg = null;
        MetaAgent recipient = null;

        agent.sendMessage(recipient, msg);
        portal.enqueue(wrap(name, recipient, msg));

    }

    public String wrap(String name, MetaAgent portal, String msg) {
        return "x";
    }

    public Portal enqueue(String wrap) {

        return new Portal();
    }
}
//portal extends meta-agent
// variables: routing-table
//
// void msg-handler(msg)
// | routing-table.get(
// |     recipient-of(msg)).enqueue(msg)
//
//void add-agent( name, agent )
//|  routing-table.set( name, agent )
//
//so...	meta-agent.send-message(recipient, msg)
//		| portal.enqueue(
//		|    wrap(name, recipient, msg)
