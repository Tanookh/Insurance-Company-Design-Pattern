package mainClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Singleton {

	private static Singleton _instance = null;

	public ArrayList<String> newInsurance = new ArrayList<String>();

	String fileName = "c:\\PairsData\\output.csv";
	String ActionsName = "c:\\PairsData\\Actions.txt";
	
	private PrintWriter writer = null;
	private FileWriter actions = null;

	private Singleton() {
		System.out.println("constructor was called");
	}

	public static Singleton getInstance() {
		if (_instance == null) {
			System.out.println("creating new instance");
			_instance = new Singleton();
		}
		return _instance;
	}

	public void addToFileStart() throws FileNotFoundException {
		writer = new PrintWriter(new File(fileName));
		StringBuilder sb = new StringBuilder();
		sb.append("Name,");
		sb.append("Id,");
		sb.append("Date,");
		sb.append("Remarks,");
		sb.append("Insurance type");
		sb.append('\n');

		writer.write(sb.toString());
		writer.close();
		System.out.println("done!");
	}

	public void addToFile(StringBuilder sb) throws IOException{
		FileWriter writerr = new FileWriter(fileName, true);
		writerr.write(sb.toString());
		writerr.close();
		System.out.println("done!");
	}
	
	public void printBought() throws IOException {
		actions = new FileWriter(new File(ActionsName));
		for (String insurances : newInsurance) {
			actions.write(insurances + '\n');
		}
		actions.close();
	}
}
