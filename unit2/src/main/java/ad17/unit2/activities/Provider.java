package ad17.unit2.activities;

import java.util.ArrayList;
import java.util.List;

public class Provider {
	private int identifier;
	private String name;
	private String street;
	private String town;
	private String country;
	private int pCode;
	private boolean origin;  //National or imported
	private List<Coffee> coffees;

	public Provider() {
		super();
		coffees=new ArrayList<Coffee>();
	}	
	public void addCoffee(Coffee coffee){
		coffees.add(coffee);		
	}
	public boolean getOrigin() {
		return origin;
	}
	public void setOrigin(boolean origin) {
		this.origin = origin;
	}
	public List<Coffee> getCoffees() {
		return coffees;
	}
	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}

	
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPCode() {
		return pCode;
	}
	public void setPCode(int pCode) {
		this.pCode = pCode;
	}
	@Override
	public String toString() {
		return "Provider [name="
				+ name + ", street=" + street + ", town=" + town
				+ ", country=" + country + ", pCode=" + pCode + "]";
	}
	
	

}


