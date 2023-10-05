import java.util.Vector;


//Checks if the librarian exists in the vector, if so returns its index, if not returns -1 and prints a message
public class ThreadLibrarian implements Runnable{
	Vector <Librarian> v;
	String s;
	public int res = -1;
	
	public void run() {
		 
		for (int i=0;i<v.size();i++) {
		if(v.elementAt(i).getID().equals(s))
			res = i;
	}
	if (res == -1) {
		System.out.print("The librarian ID doesn't exist in the system.\n");		
	}		
	}
	
	public ThreadLibrarian(Vector<Librarian> v, String s) {
		this.v = v;
		this.s = s;
	}

}
