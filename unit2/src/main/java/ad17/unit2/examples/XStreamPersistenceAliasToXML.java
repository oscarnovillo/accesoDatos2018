package ad17.unit2.examples;

import java.io.File;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class XStreamPersistenceAliasToXML {

  public static void main(String[] args) {

    //Using parser JAXP DOM, importing package com.thoughtworks.xstream.io.xml.DomDriver
    XStream xstream1 = new XStream(new DomDriver());

    // XStream security framework, for defining which types are allowed to be unmarshalled with XStream 
    // to be removed after 1.5
    XStream.setupDefaultSecurity(xstream1);
    xstream1.allowTypesByWildcard(new String[]{"ad17.unit2.examples.*"});

    //Sets the class alias
    xstream1.alias("person", Person.class);
    xstream1.alias("telephone", Telephone.class);

    //Defines the attribute alias
    xstream1.aliasField("firstName", Person.class, "name");

    //Omit collection root
    xstream1.addImplicitCollection(Person.class, "telephones");

    FilePersistenceStrategy strategy = new FilePersistenceStrategy(new File("./xml"), xstream1);
    XmlArrayList pList = new XmlArrayList(strategy);

    //Adds Person objects
    pList.add(new Person("Pepe", "Gomez"));
    pList.add(new Person("Ana", "Perez"));
    pList.add(new Person("John", "Smith"));
    pList.add(new Person("Eve", "Johnson"));

  }

}
