package ad17.unit2.examples.XstreamXMLtoHTML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateBinFile {
	public static void main(String[] args) throws IOException {
		Department dep;
		
		Path output = Paths.get("Department.txt");
		
		// Creates the file. Uses OutputStream for working byte by byte
		OutputStream ostream = Files.newOutputStream(output);
			
		ObjectOutputStream os = new ObjectOutputStream(ostream);
		
		String names[] = { "IT", "MARKETING", "ACCOUNTING",
				"SALES", "PURSHASING", "PERSONNEL", "RESOURCES", 
                           "ADMINISTRATION","FINANCES" };
		int num[] = { 10, 15, 20, 25, 30, 35, 40, 45, 50 };
		String loc[] = { "MADRID", "SEVILLA", "LEON", "TOLEDO", "GUADALAJARA",
				"CUENCA", "OVIEDO", "BILBAO", "VALENCIA" };

		for (int i = 0; i < num.length; i++) { 
			dep = new Department(names[i], num[i], loc[i]);
			os.writeObject(dep); // writes the Department object to the file
		}
		os.close(); // Closes the file
		Listing();
	}//fin main()

	//------------------------------------------------------------------
	public static void Listing() throws IOException {
		Department dep;
		Path input = Paths.get("Department.txt");
		InputStream istream = Files.newInputStream(input);
			
		ObjectInputStream ois = new ObjectInputStream(istream);

		System.out.println("LIST OF DEPARTMENTS:");
		System.out.println("====================================");
		
		try {
			while (true) { // Reads the file
				dep = (Department) ois.readObject(); 
				System.out.println("Department: "+dep.getNrDep()+
                        ", Name: " + dep.getName()
			    + ", Town: " + dep.getLoc());
			}						
		} catch (Exception e) {	
			//EOFException at the end of the file
			if(e.toString()== "java.io.EOFException")
				System.err.println("End of file...");
			else System.err.println("Problem reading the file: "+e.toString());
		}		
		System.out.println("=======================================================");
		
		ois.close(); // Closes the input file
	}//END Listing()

}
