import java.util.Date;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Library {
	Vector<Book> books = new Vector<Book>();
	Vector<Librarian> librarians = new Vector<Librarian>();
	Vector<LibraryMember> libraryMembers = new Vector<LibraryMember>();
	Vector<Supplier> suppliers = new Vector<Supplier>();
	Vector<BuyBook> soldBooks = new Vector<BuyBook>();
	Vector<Order> orders = new Vector<Order>();
	Vector<Borrow> borrows = new Vector<Borrow>();
	
	public void borrowBook(Borrow b) {
		if (b.isAvailable()){
			if (b.ifUnder5()) {
				borrows.add(b); // Add borrow to vector of borrows
				b.book.lessBook(); //Update number of available copies
				b.member.addBook(); //Update number of borrowed books of the member
				System.out.print(b); // Prints its details
			}
			else System.out.print("Error: "+b.member.getName() +" can't borrow more than 5 books.\n \n");
		}
		else System.out.print("There is no available copy of the book "+b.book.getTitle() +".\n \n");
	}

	public void OrderBook(Order order) {
		orders.add(order);// Adds this borrow to the vector		
		System.out.print(order); // Prints its details
	}
	
	public void buyBook(BuyBook bb) {
		if (bb.book.getCopies()>0) {
			bb.book.lessBook(); // Subtracts one copy from the available copies
			bb.librarian.saleBooks(); // Adds one copy to the number of books the librarian sold
			if(bb.book.getCopies() == 1) {
				System.out.print("The last copy of the book "+ bb.book.getTitle() + " sold!\n\n"); // Prints it's the last copy
			}
			else
				{System.out.print(bb);} 
		}
		else
			System.out.print("There is no available copy of the book "+bb.book.getTitle() +".\n \n");
	}
	
	//Allows the librarian to make an order from a file.
	//First line the librarian code, second line the supplier code.Then, in each line the book code, a space, the number of copies
	public void orderFromFile(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));	
			Calendar calendar = Calendar.getInstance();
		    Date today = calendar.getTime();
		    int book =-1;
			String line;
			String[] temp = new String[2];
			
			// put librarian id and supplier id in temp array
			for (int i=0 ;i<2 ; i++) {
				line = reader.readLine();
				temp[i] = line;
			}
			int[] index = findDetails(temp) ; // 0 = librarian ; 1 = supplier
				    
			//Deals with the books			
			while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(" ");
	            if (parts.length == 2) {
	                String bookID = parts[0];
	                try {
	                    int numCopies = Integer.parseInt(parts[1]);
	                    book = findBook(bookID); //Use the function to find the book in the vector
	                    if (book == -1) continue; //If the book doesn't exist in the vector
	                    	
	                    Order order = new Order(librarians.elementAt(index[0]), books.elementAt(book),
	                            suppliers.elementAt(index[1]), today, numCopies); //Make an order
	                    this.OrderBook(order); //Adds the order to the vector
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid integer format in the input file: " + line);
	                    // Handle this case as needed, e.g., continue to the next line or break the loop.
	                }
	            }
	        }

	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//Write to file all the books that are available with their details
	public void writeToFile(String filePath) {
		String content="";
		    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
		    	for(int i=0;i<books.size();i++) {
		    		if(books.elementAt(i).availableCopies>0) {
		         content +=books.elementAt(i).toString();
		         content+="\n-----------------------------\n";
		    		}
		    	}
		        
		        // Write the content to the file
		        bw.write(content);

		        System.out.println("Data has been written to the file.");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}
	
	// find details of librarian and supplier
	// If exist returns the index of them in the vector
	public int[] findDetails(String s[] ) {
		int[] idex = {-1,-1,-1}; // 0 = librarian ; 1 = supplier ; 2 = book	
		//Thread use
		ThreadSuppliers TS= new ThreadSuppliers(suppliers,s[1]);
		ThreadLibrarian TL = new ThreadLibrarian(librarians,s[0]);
		TS.run();
		TL.run();
		idex[0] = TL.res;
		idex[1] = TS.res;
		System.out.print(idex[0]+"   "+idex[1]+"\n\n");
		return idex;
	}
	
	// Find book in the vector
	public int findBook(String id) {
		int index =-1;
		for (int i=0;i<books.size();i++) {
			if(books.elementAt(i).getId().equals(id))
				index = i;
		}
		if (index == -1) {
			System.out.print("The book ID doesn't exist in the system.\n");			
			return index;
		}			
		return index;
	}

}