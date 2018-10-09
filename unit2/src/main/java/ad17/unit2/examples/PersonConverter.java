package ad17.unit2.examples;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PersonConverter implements Converter{

	//Determines the class to convert
	public boolean canConvert(Class clazz) {
		return clazz.equals(Person.class);
	}

	
	/**
	 * Determines how to convert a person object to XML
	 */
	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Person person = (Person) value;
		writer.addAttribute("lastName", person.getLastName());
		//Opens a node. Don't forget to close it.
		writer.startNode("fullname");
		writer.setValue(person.getName());
		writer.endNode();
	}

	
	/**
	 * Determines how to unmarshal a person object from XML
	 */
	public Object unmarshal(HierarchicalStreamReader reader,UnmarshallingContext context) {
		Person person = new Person();
		//It is possible to move up and down on the tree node
		person.setLastName(reader.getAttribute("lastName"));
		reader.moveDown();
		person.setName(reader.getValue());
		reader.moveUp();
		return person;
	}

}
