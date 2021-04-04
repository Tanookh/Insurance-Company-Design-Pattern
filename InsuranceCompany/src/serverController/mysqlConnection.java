package serverController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * This class connects the us with the database
 */

public class mysqlConnection {


	public static Connection connector(String a, String b, String c, String d) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");

		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {
			String myConnectionString = "jdbc:mysql://localhost:3306/" + b + "?serverTimezone=IST";
			conn = DriverManager.getConnection(myConnectionString, c, d);
			System.out.println("Connected");
			System.out.println("SQL connection succeed");
		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}

}
