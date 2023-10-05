public class Book {
String bookID;
String title;
String author;
double cost;
int availableCopies;
// Constructor, get and set
public Book(String id, String title, String author, double cost, int copies) {
	bookID = id;
	this.title = title;
	this.author = author;
	this.cost = cost;
	availableCopies = copies;
}
public String getTitle() {return this.title;}
public String getAuthor() {return this.author;}
public double getCost() {return this.cost;}
public int getCopies() {return this.availableCopies;}
public String getId() {return this.bookID;}
public void setID(String id) {this.bookID = id;}
public void setTitle(String title) {this.title = title;}
public void setAuthor(String author) {this.author = author;}
public void setCost(double cost) {this.cost = cost;}
public void setCopies(int copies) {this.availableCopies = copies;}
// toString
public String toString() {
	return "Book ID:"+bookID+".\nTitle:"+title+".\nAuthor:"+author+".\nCost:"+cost+".\nAvailable Copies:"+availableCopies + "\n";
}

// Deducts one copy after borrowing a book
public void lessBook() {this.availableCopies -=1;}

//Adds copies after ordering books
public void orderBook(int copies) {this.availableCopies += copies;}
}

