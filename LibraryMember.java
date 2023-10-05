import java.util.Date;
public class LibraryMember extends Person {
	private int numOfBooks;
	private  Date registrationDate;
	
	//Constructor
	public LibraryMember(String ID,String address,String name,String phoneNum,int numOfBooks,Date registrationDate) {
		super(ID,address,name,phoneNum);
		this.numOfBooks=numOfBooks;
		this.registrationDate=registrationDate;
	}
	
	//Gets and sets
	public void update(int numOfBooks) {
		this.numOfBooks=numOfBooks;
	}
	public int getNumOfBooks() {
		return this.numOfBooks;
	}
	public Date getRegistrationDate() {
		return this.registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate=registrationDate;
	}
	
	//toString
	public String toString() {
		return "Library Member:\n"+super.toString()+"\nNumber Of Books: "+numOfBooks+".\nRegistration Date: "+registrationDate + "\n";
	}
	
	//Adds one to the number of books that are borrowed
	public void addBook() {
		numOfBooks +=1;
		
	}

}
