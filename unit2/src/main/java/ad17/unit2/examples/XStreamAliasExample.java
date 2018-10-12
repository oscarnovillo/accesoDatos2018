package ad17.unit2.examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.converters.time.LocalDateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamAliasExample {

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
		xstream1.alias("telephone", Telephone.class);
		
		//Defines the attribute alias
		xstream1.aliasField("firstName", Person.class, "name");
		
		//Omit collection root
		 xstream1.addImplicitCollection(Person.class, "telephones");
              

		//Transforms person object to XML, using method toXML
		String xml=xstream1.toXML(person);
		
		System.out.println(xml);		
		
		//Rebuilds an object from the XML generated, using method fromXML
		Person person2=(Person)xstream1.fromXML(xml);
		
		System.out.println(person2.toString());
	}

}


