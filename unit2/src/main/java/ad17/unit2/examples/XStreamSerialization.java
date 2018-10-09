package ad17.unit2.examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamSerialization {
	
	private XStream xstream;
	
	public XStreamSerialization(){
		//Using parser JAXP DOM, importing package com.thoughtworks.xstream.io.xml.DomDriver
		xstream = new XStream(new DomDriver());
		
		// XStream security framework, for defining which types are allowed to be unmarshalled with XStream 
		// to be removed after 1.5
		XStream.setupDefaultSecurity(xstream); 
		xstream.allowTypesByWildcard(new String[] {"ad17.unit2.examples.*"});

	}
	
	public void serialize(Path path) {

		try {
			
			OutputStream ostream = Files.newOutputStream(path);
			ObjectOutputStream out = xstream.createObjectOutputStream(ostream);

			// WriteObject method serializes the object and writes it to the file
			out.writeObject(new Person("Joe", "Walnes"));
			out.writeObject(new Person("Someone", "Else"));
			out.writeObject("hello");
			out.writeInt(12345);

			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserialize(Path path) {

		try {
			InputStream istream = Files.newInputStream(path);
			ObjectInputStream in = xstream.createObjectInputStream(istream);

			Person a = (Person)in.readObject();
			Person b = (Person)in.readObject();
			String c = (String)in.readObject();
			int    d = in.readInt();
			in.close();
			
			System.out.println(a.toString());
			System.out.println(b.toString());
			System.out.println(c);
			System.out.println(d);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		XStreamSerialization serializer=new XStreamSerialization();
		Path path = Paths.get("sFile.xml");
		serializer.serialize(path);
		serializer.deserialize(path);
	}

}


