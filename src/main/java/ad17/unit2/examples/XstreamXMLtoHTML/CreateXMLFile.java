package ad17.unit2.examples.XstreamXMLtoHTML;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.thoughtworks.xstream.XStream;


class DepartmentList {	
    private List<Department> listD = new ArrayList<Department>();
    
    public DepartmentList(){ }

    public void add(Department dep) {
            listD.add(dep);
    }   
    public List<Department> getDepartmentList() {
            return listD;
    }
}//end DepartmentList


public class CreateXMLFile {
  public static void main(String[] args) throws IOException, 
                                                ClassNotFoundException {   	
		Path input = Paths.get("Department.txt");
		Path output = Paths.get("Department.xml");

		InputStream istream = Files.newInputStream(input);		
		ObjectInputStream ois = new ObjectInputStream(istream);
   
    System.out.println("Creating XML file ...");
				
    DepartmentList listDep = new DepartmentList();	 
     
    try {
      while (true) { //Reads the file and adds it to object DepartmentList 
	    Department department= (Department) ois.readObject();	
          listDep.add(department);  
      }	
    }catch (EOFException eo) {}
    ois.close();      
    
    try {
		XStream xstream = new XStream();   
		//Aliases XML tags
		xstream.alias("DepartmentList", DepartmentList.class);		
		xstream.alias("DepartmentInfo", Department.class);

		xstream.addImplicitCollection(DepartmentList.class, "listD");

		//Generates XML file and saves it to a file
		
		
		// Creates the file. Uses OutputStream for working byte by byte
		OutputStream ostream = Files.newOutputStream(output);

	    xstream.toXML(listDep, ostream);		
		System.out.println("XML file created....");
	
     }catch (Exception e) 
	   {e.printStackTrace();}	    
  } // end main
}
