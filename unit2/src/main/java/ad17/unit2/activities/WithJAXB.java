package ad17.unit2.activities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class WithJAXB {

  public static void main(String[] args) {
    String fileName = "courseJAXB.xml";
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

    generarXML(fileName, course);
    leerXML(fileName, course);
  }

  public static void generarXML(String fileName, Course course) {
    JAXBContext context;
    Marshaller marshaller;
    Path path = Paths.get(fileName);
    try {
      if (Files.notExists(path)) {
        Files.createFile(path);
      }
      context = JAXBContext.newInstance(Course.class);
      marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(course, System.out);
      marshaller.marshal(course, Files.newOutputStream(path));
    } catch (JAXBException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void leerXML(String fileName, Course course) {
    JAXBContext context;
    Unmarshaller unmarshaller;
    try {
      context = JAXBContext.newInstance(Course.class);
      unmarshaller = context.createUnmarshaller();
      Course courseAux = (Course) unmarshaller.unmarshal(Files.newInputStream(Paths.get(fileName)));
      String s = new String();
      Marshaller marshaller = context.createMarshaller();
      marshaller.marshal(course, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
