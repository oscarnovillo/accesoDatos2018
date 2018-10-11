package ad17.unit2.examples;

//Java object serialization to XML using JAXB

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SerializeXMLJAXB {
	private static final String STATE_DAT_FILE = "state.xml";

	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(State.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		State state = fillState();
		
		// Shows the generated XML document on screen
		marshaller.marshal(state, System.out);
		
		// Saves the XML document into a file
		marshaller.marshal(state, Files.newOutputStream(Paths.get(STATE_DAT_FILE)));
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		// Reads the XMl document form the file
		State stateAux = (State) unmarshaller.unmarshal(Files.newInputStream(Paths.get(STATE_DAT_FILE)));
		
		System.out.println("********* Result of reading XML document from the file***************");
		
		// Show the resulting Java object on screen
		marshaller.marshal(stateAux, System.out);
	}

	private static State fillState() {
		String[] nameTown = { "Madrid", "Coslada" };
		int[] pcodeTown = { 28028, 28820 };
		Town[] towns = new Town[2];
		for (int i = 0; i < 2; i++) {
			towns[i] = new Town();
			towns[i].setPcode(pcodeTown[i]);
			towns[i].setName(nameTown[i]);
		}
		State state = new State();
		state.setName("Madrid");
		state.setTown(towns);
		return state;
	}

}
