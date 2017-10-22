package ad17.unit2.examples.XstreamXMLtoHTML;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateHTMLFile {
 public static void main(String argv[]) throws IOException{ 
  String styleSheet = "src/main/java/ad17/unit2/examples/XstreamXMLtoHTML/department.xsl";
  String DepInfo = "Department.xml";
	Path output = Paths.get("Departments.html");
	// Creates the file. 
	OutputStream ostream = Files.newOutputStream(output);

  Source styles =new StreamSource(styleSheet); //XSL source
  Source depInfo =new StreamSource(DepInfo); //XML source
  Result result = new StreamResult(ostream);         //Result of the transformation
  
  try{     
   Transformer transformer =  
               TransformerFactory.newInstance().newTransformer(styles);   
   transformer.transform(depInfo, result);	//HTML
  }
  catch(Exception e){System.err.println("Error: "+e);}
  
  ostream.close();   	
 }
}
