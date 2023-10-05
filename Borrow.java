import java.util.Date;

public class Borrow {
    Date date;
    int quantity;
    LibraryMember member;
    Book book;

    // Checks if there are available copies of the book 
    public boolean isAvailable(){
     if (book.getCopies() > 0)
         return true;
     else
        return false;
    }
    
    //Checks if the borrower has less than five books
    public boolean ifUnder5(){
        if(member.getNumOfBooks() < 5 && (member.getNumOfBooks() + quantity <= 5))
            return true;
        else
            return false;
    }
    
    //Constructor
    public Borrow(LibraryMember member, Book book, Date date, int quantity) {
        this.member = member;
        this.book = book;
        this.date = date;
        this.quantity = quantity;
    }
    
    //toString
    public String toString() {
        return "The book " + book.getTitle() + " has been borrowed by " +member.getName() +"\nNumber of borrowed books by " + 
    member.getName() +" until now : " + member.getNumOfBooks() + "\nNumber of books available now : " + book.getCopies() + "\n \n" ;
    }
}
