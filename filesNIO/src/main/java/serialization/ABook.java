package serialization;

import java.io.Serializable;

public class ABook implements Serializable {
	
	/*The serialization runtime associates with each serializable class a version number,
	 called a serialVersionUID, which is used during deserialization to verify that the sender
	 and receiver of a serialized object have loaded classes for that object that are compatible
	 with respect to serialization. If the receiver has loaded a class for the object that has a 
	 different serialVersionUID than that of the corresponding sender's class, then deserialization 
	 will result in an  InvalidClassException
	 */
	
	private static final long serialVersionUID = 6529685098267757690L;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String fullName;
	private String address;
	private transient String city;

	public ABook(String fullName, String address, String city) {
		this.fullName = fullName;
		this.address = address;
		this.city = city;
	}
}