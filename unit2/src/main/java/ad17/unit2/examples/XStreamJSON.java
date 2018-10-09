package ad17.unit2.examples;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class XStreamJSON {

	public static void main(String[] args) {
		Person person = new Person("Pepe", "Gomez");
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());        
        xstream.alias("person", Person.class);

        System.out.println(xstream.toXML(person));	
        
       
	}

}


