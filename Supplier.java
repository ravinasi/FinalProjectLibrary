import java.util.Scanner;
public class Supplier {
    private String supplierID;
    private String companyName;
    private String address;
    public String comment;

    //Constructor 
    public Supplier (String supplierID, String companyName, String address){
        this.supplierID = supplierID;
        this.companyName= companyName;
        this.address = address;
        this.comment="";
    }

    //Sets and Gets
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
    public String getSupplierID() {
        return supplierID;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    
    //Allows you to add comments about the supplier
    public void addComment() {
    	System.out.println("Please write a comment");
    	Scanner scan=new Scanner(System.in);
    	this.comment=scan.nextLine();
    	 scan.close();

    }
    
    //toString
    public String toString() {
    	return "Supplier ID: "+supplierID+".\nCompany Name: "+companyName+ ".\nAddress: "+address+".\n";
    }
}