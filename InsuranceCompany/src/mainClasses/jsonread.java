package mainClasses;

import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class jsonread {
	
	public static String version;
	public static String firstName;
	public static String secondName;
	public static String port;
	public static String name;
	public static String server;
	public static String password;
	public static String username;
	public static String loginpassword;
	
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("/PairsData/input.json"));
			JSONObject jsonObject = (JSONObject) obj;
			version = (String) jsonObject.get("version");
			firstName = (String) jsonObject.get("student_name_1");
			secondName = (String) jsonObject.get("student_name_2");
			port = (String) jsonObject.get("port");
			name = (String) jsonObject.get("name");
			server = (String) jsonObject.get("server");
			password = (String) jsonObject.get("password");
			username = (String) jsonObject.get("username");
			loginpassword = (String) jsonObject.get("loginpassword");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}