// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.ChatIF;
//import entity.Car;
//import entity.StationOrder;
//import entity.StockReport;
//import entity.Client;
//import entity.Employee;
//import entity.HomeOrder;
//import entity.IncomeReport;
//import entity.Order;
//import entity.ProductStation;
//import entity.Purchese;
//import entity.Sale;
//import entity.Station;
//import entity.Subscription;
//import entity.purcheseReport;
//import entity.NewFuelRate;
import mainClasses.Insurance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//import clientController.Purchase;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient {
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */

	ChatIF clientUI;

	/**
	 * The code below saves all the data about the Client that we are interacting
	 * with at the moment to get the specific data about a client, we take it from
	 * here.
	 * 
	 * The code saves all the data that we need for other entities too
	 * 
	 * we save the data after a call to the database
	 *
	 * 
	 */

	public static String userExistance = new String();
	public static String DataSaved = new String();
	public static List<Insurance> InsuranceList = new ArrayList<Insurance>();

	public static boolean awaitResponse = false;
	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host     The server to connect to.
	 * @param port     The port number to connect on.
	 * @param clientUI The interface type variable.
	 */

	public ChatClient(String host, int port, ChatIF clientUI) throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 * 
	 * checks what was the SQL function that was used and saves the correct data
	 * according to the function
	 *
	 * @param msg The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		System.out.println("--> handleMessageFromServer");
		awaitResponse = false;
		String[] checkThis = (String[]) msg.toString().split("#");
		switch (checkThis[0]) {
		case "userExist": {
			if (checkThis[1].equals("userExists"))
				userExistance = "userExist";
			else
				userExistance = "userDoesNotExist";
			break;
		}
		case "DataSaved": {
			if (checkThis[1].equals("Success"))
				DataSaved = "true";
			else
				DataSaved = "false";
			break;
		}
		case "GetData": {
			setDataArray(checkThis);
			break;
		}

		}
	}

	public void setDataArray(String[] checkThis) {
		String[] Insurances = checkThis[1].substring(1, checkThis[1].length()-1).split(",");
		int len = Insurances.length;
		InsuranceList = new ArrayList<Insurance>();
		if (len == 1) {
			InsuranceList.add(new Insurance(null, null, null, null, null));
		} else {
			for (int i = 0; i < len; i += 5) {
				Insurance newInsurance = new Insurance(Insurances[i].trim(), Insurances[i + 1].trim(), Insurances[i + 2].trim(), Insurances[i + 3].trim(), Insurances[i + 4].trim());
				InsuranceList.add(newInsurance);
			}
		}

	}

	public void handleMessageFromClientUI(String message) {
		try {
			openConnection();
			awaitResponse = true;
			sendToServer(message);
			// wait for response
			while (awaitResponse) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			clientUI.display("Could not send message to server: Terminating client." + e);
			quit();
		}
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
//End of ChatClient class
