package ad17.unit2.examples;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Two annotations: XmlRootElement, XmlElement.
 * 
 * XmlRootElement defines the root element
 * XmlElement to define the attributes wanted in the XML document
 */

@XmlRootElement
class State {
	private String name;
	private Town[] town;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Town[] getTown() {
		return town;
	}

	public void setTown(Town[] town) {
		this.town = town;
	}

}
