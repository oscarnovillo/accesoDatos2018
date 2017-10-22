package ad17.unit2.examples.XstreamXMLtoHTML;

import java.io.Serializable;

public class Department implements Serializable {
	private String name;
	private String loc;
	private int nrDep;

	public Department(String name, int nrDep, String loc) {
		this.name = name;
		this.nrDep = nrDep;
		this.loc = loc;
	}

	public Department() {
		this.name = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getNrDep() {
		return nrDep;
	}

	public void setNrDep(int nrDep) {
		this.nrDep = nrDep;
	}

}// end Department

