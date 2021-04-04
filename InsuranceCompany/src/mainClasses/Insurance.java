package mainClasses;

public class Insurance {
	
	private String name;
	private String ID;
	private String date;
	private String remarks;
	private String type;
	
	public Insurance(String name, String ID, String date, String remarks, String type)
	{
		this.name = name;
		this.ID = ID;
		this.date = date;
		this.remarks = remarks;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
