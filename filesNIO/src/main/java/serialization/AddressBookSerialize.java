package serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddressBookSerialize {
	public static void main(String[] args) {
		ABook a1 = new ABook("Mary Johns", "12-123rd Street", "New York");
		ABook a2 = new ABook("Peter Kyle", "45-54th Street", "Washington");
		Path output = Paths.get("testFiles/ABook.txt");
		try {
			// Creates the file. Uses OutputStream for working byte by byte
			OutputStream ostream = Files.newOutputStream(output);
			
			ObjectOutputStream os = new ObjectOutputStream(ostream);
			
			// writeObject() serializes the objects and writes them to the file
			os.writeObject(a1);
			os.writeObject(a2);

			// Closes the file
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}