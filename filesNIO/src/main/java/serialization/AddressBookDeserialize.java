package serialization;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddressBookDeserialize {	
	public static void main(String[] args) {
		ABook a1 = null;
		ABook a2 = null;
		Path input = Paths.get("testFiles/ABook.txt");
		try {
			InputStream istream = Files.newInputStream(input);
			
			ObjectInputStream os = new ObjectInputStream(istream);
			
			// readObject() reconstructs the object
			
			a1 = (ABook) os.readObject();
			a2 = (ABook) os.readObject();
			
			System.out.println(a1.getFullName() + "\n" + a2.getFullName());
			
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}