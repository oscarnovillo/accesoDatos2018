package ad17.unit2.activities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class WithDOM {

  public static void main(String[] args) {
    int numStudents = 3;
    //Init course and students
    Course course = new Course(numStudents);
    Student s1 = new Student("John", "Gutag", 1985, "Street1", 23);
    Student s2 = new Student("Jack", "Johnson", 1989, "Street2", 12);
    Student s3 = new Student("John", "Jackson", 1981, "Street3", 46);
    //Add students to course
    course.add(s1);
    course.add(s2);
    course.add(s3);
    //Write to XML file
    generateXML("course", course);
    //Read from XML file
    readXML("course");

  }

  public static void generateXML(String fileName, Course course) {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = null;
    DOMImplementation implementation;
    Document document;
    try {
      db = dbf.newDocumentBuilder();

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    if (db != null) {
      implementation = db.getDOMImplementation();
      document = implementation.createDocument(null, fileName, null);
      document.setXmlVersion("1.0");

      //Main Node
      //Element root = document.createElement("COURSE");
      Element root = document.getDocumentElement();
      for (Student s : course.getStudents()) {
        Element studentNode = document.createElement("STUDENT");
        //FirstName
        Element firstNameNode = document.createElement("FIRST_NAME");
        Text firstNameNodeText = document.createTextNode(s.getFirstName());
        firstNameNode.appendChild(firstNameNodeText);
        studentNode.appendChild(firstNameNode);
        //LastName
        Element lastNameNode = document.createElement("LAST_NAME");
        Text lastNameNodeText = document.createTextNode(s.getLastName());
        lastNameNode.appendChild(lastNameNodeText);
        studentNode.appendChild(lastNameNode);
        //YearOfBirth
        Element yearOfBirthNode = document.createElement("YEAR_OF_BIRTH");
        Text yearOfBirthNodeText = document.createTextNode(String.valueOf(s.getYearOfBirth()));
        yearOfBirthNode.appendChild(yearOfBirthNodeText);
        studentNode.appendChild(yearOfBirthNode);
        //Address
        Element addressNode = document.createElement("ADDRESS");
        Text addressNodeText = document.createTextNode(s.getAddress());
        addressNode.appendChild(addressNodeText);
        studentNode.appendChild(addressNode);
        //Add to main
        root.appendChild(studentNode);
      }

      //Generate DOM and save into XML
      Source source = new DOMSource(document);
      try {
        Path path = Paths.get(fileName + ".xml");
        if (Files.notExists(path)) {
          Files.createFile(path);
        }
        Result result = new StreamResult(Files.newOutputStream(path));
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (TransformerConfigurationException e) {
        e.printStackTrace();
      } catch (TransformerFactoryConfigurationError e) {
        e.printStackTrace();
      } catch (TransformerException e) {
        e.printStackTrace();
      }
    }
  }

  public static void readXML(String fileName) {
    //Generate DOM from XML file
    Path path = Paths.get(fileName + ".xml");
    if (Files.exists(path)) {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db;
      Document document = null;
      try {
        db = dbf.newDocumentBuilder();
        document = db.parse(Files.newInputStream(path));
      } catch (ParserConfigurationException e) {
        e.printStackTrace();
      } catch (SAXException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      //Get values and print them
      if (document != null) {
        int numStudents = document.getElementsByTagName("STUDENT").getLength();
        String studentFirstName, studentLastName, studentYearOfBirth, studentAddress;
        for (int x = 0; x < numStudents; x++) {
          studentFirstName = document.getElementsByTagName("FIRST_NAME").item(x).getFirstChild().getNodeValue();
          studentLastName = document.getElementsByTagName("LAST_NAME").item(x).getFirstChild().getNodeValue();
          studentYearOfBirth = document.getElementsByTagName("YEAR_OF_BIRTH").item(x).getFirstChild().getNodeValue();
          studentAddress = document.getElementsByTagName("ADDRESS").item(x).getFirstChild().getNodeValue();
          System.out.println(" - FirstName: " + studentFirstName + "; LastName: " + studentLastName
                  + "; YearOfBirth: " + studentYearOfBirth + "; Address: " + studentAddress);
        }
      }

    }

  }

}
