package ad17.unit2.examples;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Class for converting an object attribute to an XML attribute
 */

public class XstreamAttributeConverter {

	public static void main(String[] args) {

		//Using parser JAXP DOM, importing package com.thoughtworks.xstream.io.xml.DomDriver
		XStream xstream1 = new XStream(new DomDriver());
		
		// XStream security framework, for defining which types are allowed to be unmarshalled with XStream 
		// to be removed after 1.5
		XStream.setupDefaultSecurity(xstream1); 
		xstream1.allowTypesByWildcard(new String[] {"ad17.unit2.examples.*"});
		

		//Creating Person object
		Person person=new Person("Pepe", "Gomez");
		
		//Sets the class alias
		xstream1.alias("person", Person.class);	
		
		// Sets xml attributes
		xstream1.useAttributeFor(Person.class, "name");
		
		// Defines the needed converter for Address object to be an attribute
		xstream1.useAttributeFor(Person.class, "address");
		
		//It is also possible to define alias for xml attributes
		xstream1.aliasAttribute("street", "address");
		
		// Registers the converters
		xstream1.registerConverter(new AddressConverter());
		xstream1.registerConverter(new BooleanConverter("yes", "no", false));
		xstream1.registerConverter(new DateConverter("dd-MM-yyyy HH:mm:ss",new String[] {"dd-MM-yyyy HH:mm:ss .S a", "dd-MM-yyyy HH:mm:ssz", "dd-MM-yyyy HH:mm:ss z", "dd-MM-yyyy HH:mm:ssa" }));
		
		// Converts person object to XML
		String xml = xstream1.toXML(person);

		System.out.println(xml);

		// Rebuilds person object
		Person person1 = (Person) xstream1.fromXML(xml);

		System.out.println(person1.toString());

	}
}
