
public class Person {
	private String ID;
	private String address;
	private String name;
	private String phoneNum;
	
	//Constructor
	public Person(String ID,String address,String name,String phoneNum) {
		this.ID=ID;
		this.address=address;
		this.name=name;
		this.phoneNum=phoneNum;
	}
	
	//Gets and sets
	public String getID() {
		return this.ID;
	}
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPhoneNum() {
		return this.phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum=phoneNum;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	
	//toString
	public String toString() {
		return "ID: "+ID+".\nName:"+name+".\nPhone Number:"+phoneNum;
	}

}
