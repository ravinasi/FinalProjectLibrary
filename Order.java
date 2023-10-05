import java.util.Date;
public class Order {
	Librarian librarian;
	Book book;
	Supplier supplier;
	Date date;
	int quantity;
	
	//Constructor
	public Order(Librarian librarian, Book book, Supplier supplier, Date date, int quantity) {
		this.librarian = librarian;
		this.book = book;
		this.supplier = supplier;
		this.date = date;
		this.quantity = quantity;
		this.book.orderBook(quantity); // Adds the number of available copies of the book
	}
	
	//toString
	public String toString() {
	 	   return "Order of the book " + book.getTitle() +" of "
	 				+quantity+" copies was made by the librarian "+librarian.getName()+" from the supplier "+supplier.getCompanyName()+" .\n\n";
	    }
}
