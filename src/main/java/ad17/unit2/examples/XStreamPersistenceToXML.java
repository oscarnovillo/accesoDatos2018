package ad17.unit2.examples;


import java.io.File;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class XStreamPersistenceToXML {

	public static void main(String[] args) {
		
		//Attention: If the directory does not exist, NullPointerException will be launch
		//XStream does not work with java.nio.file.Path
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("./xml"));
		// creates the list:
		XmlArrayList pList = new XmlArrayList(strategy);
		
		//Adds Person objects
		pList.add(new Person("Pepe", "Gomez"));
		pList.add(new Person("Ana", "Perez"));
		pList.add(new Person("John", "Smith"));
		pList.add(new Person("Eve", "Johnson"));
		
		// Adding a last Person
		Person mistake = new Person("Bob","Sponge");
		pList.add(mistake);
		
		/*5 files have been created at specified directory:
		 int@1.xml, int@2.xml, int@3.xml, int@4.xml, int@5.xml
		 each of them is the XLM corresponding to a person*/ 
	}

}


