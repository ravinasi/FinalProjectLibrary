
public class Librarian extends Person {
	private float salary;
	private String password;
	private int numOfSales;
	
	//Constructor
	public Librarian (String ID,String address,String name,String phoneNum,float salary,String password) {
		super(ID,address,name,phoneNum);
		this.salary=salary;
		this.password=password;
		this.numOfSales=0;
	}
	
	//Gets and sets
	public void update(float salary) {
		this.salary=salary;
	}
	public float getSalary() {
		return this.salary;
	}
	public int getNumOfSales() {
		return this.numOfSales;
	}
	
	//Adds one to the number of books the librarian sold
	public void saleBooks() {
		this.numOfSales++;
	}
	
	//toString
	public String toString() {
		return "Librarian:\n"+super.toString()+".\n"+"The number of book sold: "+this.numOfSales+".\n";
	}
	

}