package ad17.unit2.examples;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class CustomConverter {
	 public static void main(String[] args) {
         Person person = new Person();
         person.setName("Guilherme");
         person.setLastName("Garcia");

         XStream xStream = new XStream(new DomDriver());
         
         //Registers the custom converter
         xStream.registerConverter(new PersonConverter());
         xStream.alias("person", Person.class);
         System.out.println(xStream.toXML(person));
 }

}


