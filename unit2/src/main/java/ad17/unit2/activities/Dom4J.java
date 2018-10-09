/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad17.unit2.activities;

import java.io.File;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 *
 * @author oscar
 */
public class Dom4J {
    public static void main(String[] args) {

      try {
         File inputFile = new File("input.txt");
         SAXReader reader = new SAXReader();
         Document document = reader.read( inputFile );

         System.out.println("Root element :" + document.getRootElement().getName());

         Element classElement = document.getRootElement();

         List<Node> nodes = document.selectNodes("/class/student" );
         System.out.println("----------------------------");
         
         for (Node node : nodes) {
            System.out.println("\nCurrent Element :"
               + node.getName());
            System.out.println("Student roll no : " 
               + node.valueOf("@rollno") );
            System.out.println("First Name : "
               + node.selectSingleNode("firstname").getText());
            System.out.println("Last Name : "
               + node.selectSingleNode("lastname").getText());
            System.out.println("First Name : "
               + node.selectSingleNode("nickname").getText());
            System.out.println("Marks : "
               + node.selectSingleNode("marks").getText());
         }
      } catch (DocumentException e) {
         e.printStackTrace();
      }
   }
}
