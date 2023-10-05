
public class BuyBook {
	Book book;
	LibraryMember member;
	Librarian librarian;
	String receipt;
	
	//Constructor
	public BuyBook(Book book, LibraryMember member, Librarian librarian, String receipt) {
		this.book = book;
		this.member = member;
		this.librarian = librarian;
		this.receipt = receipt;
	}

	//toString
	public String toString() {
		return "Receipt number : " + receipt+ "\nOne copy of the book "+book.getTitle()+" was sold by " + 
	librarian.getName() + " to " + member.getName() + "\nNumber of books available now : " + book.getCopies() + "\n\n";
	}
}
