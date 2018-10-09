package ad17.unit2.examples;


import java.io.File;
import java.util.Iterator;

import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class XStreamPersistenceFromXML {

	public static void main(String[] args) {
		
		//Attention: If the directory does not exist, NullPointerException will be launch
		//XStream does not work with java.nio.file.Path
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("./xml"));
		// creates the list:
		XmlArrayList pList = new XmlArrayList(strategy);
		
		for(Iterator it = pList.iterator(); it.hasNext(); ) {
			Person person = (Person) it.next();
			//Deletes Sponge Bob
			if(person.getName().equals("Bob") && person.getLastName().equals("Sponge") ) {
				System.out.println("Deleting Sponge Bob...");
				it.remove();
			} else {
				System.out.println("Saving " + person.toString());
			}
		}
		 

	}

}


