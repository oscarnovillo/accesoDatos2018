package ad17.unit2.examples;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 * Three annotations: XmlRootElement, XmlType and XmlElement.
 * 
 * XmlRootElement defines the root element
 * XmlType with 'propOrder' property allows to change the order of the XML nodes
 * XmlElement to define the attributes wanted in the XML document
 */

@XmlRootElement
@XmlType(propOrder = { "pcode", "name" })
class Town {
	private String name;
	private int pcode;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getPcode() {
		return pcode;
	}

	@XmlElement
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
}
