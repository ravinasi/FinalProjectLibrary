import java.util.Date;
import java.util.Calendar;

//Ravin Asi - 208686162
//Omer Dahan - 208911958
//Tamir Mareli - 206862146 
//Natan Ouaki - 341070217

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a Library instance
        Library library = new Library();

        // Create some books
        Book book1 = new Book("B001", "Harry Potter and the Goblet of Fire", "J.K. Rowling", 49.99, 10);
        Book book2 = new Book("B002", "Percy Jackson and the Olympians", "Rick Riordan", 29.99, 5);
        Book book3 = new Book("B003", "Hunger Games", "Suzanne Collins", 39.99, 1);

        // Create some librarians
        Librarian librarian1 = new Librarian("L001", "35 Yehuda Halevi St", "Omer Dahan", "053.708.1234", 3000.0f, "OmerD123");
        Librarian librarian2 = new Librarian("L002", "16 Klausner St", "Tamir Mareli", "053.708.4321", 3200.0f, "TamirM456");

        // Create some library members
        Calendar calendar = Calendar.getInstance();
        Date member1RegistrationDate = calendar.getTime();
        LibraryMember member1 = new LibraryMember("M001", "78 Ben Gurion St", "Natan Ouaki", "055.505-2626", 1, member1RegistrationDate);

        Date member2RegistrationDate = calendar.getTime();
        LibraryMember member2 = new LibraryMember("M002", "101 Hamaalot St", "Ravin Asi", "058.120.5432", 3, member2RegistrationDate);

        // Create some suppliers
        Supplier supplier1 = new Supplier("S001", "Steimatzky", "123 Supplier St");
        Supplier supplier2 = new Supplier("S002", "Tzomet Sfarim", "456 Supplier Ave");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(librarian1);
        System.out.println(librarian2);
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(supplier1);
        System.out.println(supplier2);           

        // Create some orders
        Order order1 = new Order(librarian1, book1, supplier1, new Date(), 10);
        Order order2 = new Order(librarian2, book2, supplier2, new Date(), 5);


        // Create some borrows
        Borrow borrow1 = new Borrow(member1, book1, new Date(), 1);
        Borrow borrow2 = new Borrow(member1, book2, new Date(), 1);
        Borrow borrow3 = new Borrow(member2, book3, new Date(), 1);



        // Create some BuyBook transactions
        BuyBook buyBook1 = new BuyBook(book1, member1, librarian1, "R041");
        BuyBook buyBook2 = new BuyBook(book3, member2, librarian2,"R021");


        // Add objects to the library
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);


        library.librarians.add(librarian1);
        library.librarians.add(librarian2);

        library.libraryMembers.add(member1);
        library.libraryMembers.add(member2);

        library.suppliers.add(supplier1);
        library.suppliers.add(supplier2);

        // Borrow a book
        library.borrowBook(borrow1);
        library.borrowBook(borrow3);

        // Try to borrow more books than allowed
        borrow2.quantity = 5;
        library.borrowBook(borrow2);
        library.borrowBook(borrow3);

        // Buy a book
        library.buyBook(buyBook1);
        library.buyBook(buyBook2);

        // Order books from a file
        library.orderFromFile("order.txt");     

        // Write available books to a file
        library.writeToFile("available_books.txt");
        
        //GUI
        App a = new App();
        while(a.f.isVisible())
            Thread.sleep(100);
        a.orderGUI(library);
        
        //  Write available books to a file again to make sure the order has been made 
        library.writeToFile("available_books_update.txt");
        
    }
}
