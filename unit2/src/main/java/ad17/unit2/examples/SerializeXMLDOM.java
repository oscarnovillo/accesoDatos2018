package ad17.unit2.examples;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

// Java object serialization to XML using API DOM

public class SerializeXMLDOM {

	public static void main(String[] args) {
		String nameFile = "keyxml";
		
		ArrayList<String> key = new ArrayList<String>();
		ArrayList<String> value = new ArrayList<String>();

		key.add("option1");
		value.add("22");

		key.add("option2");
		value.add("23");

		key.add("option3");
		value.add("24");

		key.add("option4");
		value.add("25");

		try {
			generate(nameFile, key, value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void generate(String name, ArrayList<String> key,
			ArrayList<String> value) throws Exception {
		
		int NrKeys;
		String itemKey;
		String itemValue;
		
		if (key.isEmpty() || value.isEmpty() || key.size() != value.size()) {
			System.out.println("ERROR empty ArrayList");
			return;
		} else {

			// Objects for creating an XML document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, name, null);
			document.setXmlVersion("1.0");

			// Main Node
			Element root = document.getDocumentElement();

			// Creates item for key and value. If it were an object, the properties would be the nodes
			for (int i = 0; i < key.size(); i++) {
				// Item Node
				Element itemNode = document.createElement("ITEM");
				// Key Node
				Element keyNode = document.createElement("KEY");
				Text nodeKeyValue = document.createTextNode(key.get(i));
				keyNode.appendChild(nodeKeyValue);
				// Value Node
				Element valueNode = document.createElement("VALUE");
				Text nodeValueValue = document.createTextNode(value.get(i));
				valueNode.appendChild(nodeValueValue);
				// append keyNode and valueNode to itemNode
				itemNode.appendChild(keyNode);
				itemNode.appendChild(valueNode);
				// append itemNode to root
				root.appendChild(itemNode); 
			}
			// Generates the DOM document and saves it into an XML file
			Source source = new DOMSource(document);
			
			Result result = new StreamResult(Files.newOutputStream(Paths.get(name+".xml"))); // name of the file
																				
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.transform(source, result);

			// Generates the DOM from the XMl file
			Document document2 = builder.parse(Files.newInputStream(Paths
					.get(name + ".xml")));
			
			// Shows the number of keys in the document. 
			NrKeys= document2.getElementsByTagName("KEY").getLength();
			System.out.println("number of KEYS: " + NrKeys);
			
			// Shows keys and values
			for (int i=0; i<NrKeys; i++) {
				itemKey = document2.getElementsByTagName("KEY").item(i).getFirstChild().getNodeValue();
				itemValue = document2.getElementsByTagName("VALUE").item(i).getFirstChild().getNodeValue();
				System.out.println(itemKey + " - " + itemValue);

			}
		}
	}

}
