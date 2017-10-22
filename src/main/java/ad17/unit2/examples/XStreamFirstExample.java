package ad17.unit2.examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamFirstExample {

	public static void main(String[] args) {
		
		//XStream: requires an XML parser: 3 possible ways for instantiating an XML object
		
		//1:
		//Using classpath XPP3, a very powerful parser XML. Needs XPP3 library (default constructor):
		//XStream xstream = new XStream();
		
		//2:
		//Using parser JAXP DOM, importing package com.thoughtworks.xstream.io.xml.DomDriver
		XStream xstream1 = new XStream(new DomDriver());
		
		// XStream security framework, for defining which types are allowed to be unmarshalled with XStream 
		// to be removed after 1.5
		XStream.setupDefaultSecurity(xstream1); 
		xstream1.allowTypesByWildcard(new String[] {"ad17.unit2.examples.*"});
		
		//3:
		//Using parser StAX, importing package com.thoughtworks.xstream.io.xml.StaxDriver
		//XStream xstream2 = new XStream(new StaxDriver());
		
		//Creating Person object
		Person person=new Person("Pepe", "Gomez");

		
		//Transforms person object to XML, using method toXML
		String xml=xstream1.toXML(person);
		
		System.out.println(xml);		
		
		//Rebuilds an object from the XML generated, using method fromXML
		Person person2=(Person)xstream1.fromXML(xml);
		
		System.out.println(person2.toString());
		

	}
	
	
}


