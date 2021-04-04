package serverController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import JavaFxController.ServerController;

/**
 * This class contains all the functions that work with the database it contains
 * SQL sentences
 */

public class DBFunctions {

	public static boolean checkUserExist(String msg) {
		Statement stmt;
		String[] checkThis = (String[]) msg.toString().split("#");
		ArrayList<String> stringUser = new ArrayList<String>();
		try {
			stmt = ServerController.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee where firstname ='" + checkThis[0] + "'"
					+ " AND password ='" + checkThis[1] + "'");
			while (rs.next()) {
				stringUser.add(rs.getString(1));
				stringUser.add(rs.getString(2));
			}
			rs.close();
			if (!stringUser.isEmpty())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void SaveData(String msg) {
		Statement stmt;
		String[] checkThis = (String[]) msg.toString().split("#");
		try {
			stmt = ServerController.conn.createStatement();
			stmt.executeUpdate(
					"insert into insurance(namee , id ,  datee, remarks, insurancetype) value('" + checkThis[0] + "','"
							+ checkThis[1] + "','" + checkThis[2] + "','" + checkThis[3] + "','" + checkThis[4] + "')");
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static boolean GetSpecificData(String msg) {
		Statement stmt;
		String[] checkThis = (String[]) msg.toString().split("#");
		ArrayList<String> stringUser = new ArrayList<String>();
		try {
			stmt = ServerController.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM insurance where namee ='" + checkThis[0] + "'"
					+ " AND id ='" + checkThis[1] + "'" + " AND datee ='" + checkThis[2] + "'" + " AND remarks ='"
					+ checkThis[3] + "'" + " AND insurancetype ='" + checkThis[4] + "'");
			while (rs.next()) {
				stringUser.add(rs.getString(1));
				stringUser.add(rs.getString(2));
				stringUser.add(rs.getString(3));
				stringUser.add(rs.getString(4));
				stringUser.add(rs.getString(5));
			}
			rs.close();
			if (!stringUser.isEmpty())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<String> GetInsuranceData() {
		Statement stmt;
		ArrayList<String> InsData = new ArrayList<String>();
		try {
			stmt = ServerController.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM insurance");
			while (rs.next()) {
				InsData.add(rs.getString(1));
				InsData.add(rs.getString(2));
				InsData.add(rs.getString(3));
				InsData.add(rs.getString(4));
				InsData.add(rs.getString(5));
			}
			rs.close();
			return (InsData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (InsData);
	}
}