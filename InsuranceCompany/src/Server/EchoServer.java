// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package Server;

import java.util.ArrayList;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import serverController.DBFunctions;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */

public class EchoServer extends AbstractServer {
	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;

	/**
	 * These strings are used in a switch case, The string are in static to make in
	 * easier to check how many functions we have
	 */
	public static final String userExist = "checkUserExistance";
	public static final String SaveData = "SaveInsuranceData";
	public static final String GetSpecificData = "GetSpecificInsuranceData";
	public static final String GetData = "getData";

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 * 
	 */

	public EchoServer(int port) {
		super(port);
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 * 
	 * the message from the client contains info about what function to do next so
	 * the message is separated and checked in a switch case to determine which of
	 * the case to continue with
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 * @param
	 */

	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		boolean flag = false;
		String[] checkThis = (String[]) msg.toString().split("#");
		switch (checkThis[0]) {
		case userExist: {
			flag = DBFunctions.checkUserExist(checkThis[1] + "#" + checkThis[2]);
			if (flag) {
				this.sendToAllClients("userExist#userExists");
			} else {
				this.sendToAllClients("userExist#userDoesNotExists");
			}
			break;
		}
		case SaveData: {
			DBFunctions.SaveData(checkThis[1] + "#" + checkThis[2] + "#" + checkThis[3] + "#" + checkThis[4] + "#" + checkThis[5]);
			this.sendToAllClients("meh");
			break;
		}
		case GetSpecificData: {
			flag = DBFunctions.GetSpecificData(
					checkThis[1] + "#" + checkThis[2] + "#" + checkThis[3] + "#" + checkThis[4] + "#" + checkThis[5]);
			if (flag) {
				this.sendToAllClients("DataSaved#Success");
			} else {
				this.sendToAllClients("DataSaved#Failed");
			}
			break;
		}
		case GetData: {
			ArrayList<String> InsuranceData = new ArrayList<String>();
			InsuranceData = DBFunctions.GetInsuranceData();
			this.sendToAllClients("GetData#" + InsuranceData);
			break;
		}
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}
}
//End of EchoServer class
