package ad17.unit2.examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
	private String name;
	private String lastName;
	private Address address;
	private List<Telephone> telephones;
	private LocalDate dateOfBirth;
	private boolean over18;
	
    public Person(String fN, String lN)  {
    	Address address=new Address();
    	address.setStreet("Second street");
    	address.setNumber(5);
    	
    	telephones=new ArrayList<Telephone>();
		Telephone tel1=new Telephone();
		tel1.setCode(34);
		tel1.setNumber(666666666);
		
		Telephone tel2=new Telephone();
		tel2.setCode(34);
		tel2.setNumber(1234567898);
		
		this.setName(fN);
		this.setLastName(lN);
		this.setAddress(address);
		this.addTelephone(tel1);
		this.addTelephone(tel2);
		
		LocalDate dob = LocalDate.of(1994, 6, 30);
	
		this.setDateOfBirth(dob);
		this.setOver18();  
	}

    public Person(){
        telephones=new ArrayList<Telephone>();
    }
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void addTelephone(Telephone telephone){
            telephones.add(telephone);
    }
	
	public List<Telephone> getTelephones(){
		return this.telephones;
	}

	public String infoTelephones(){
		String tels="";
        for (int j=0;j<telephones.size();j++){
             tels=tels + (telephones.get(j).toString()+" ");
        }
        return tels;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate date) {
		this.dateOfBirth = date;
	}
	
	public boolean getOver18() {
		LocalDate now = LocalDate.now();
		return now.isAfter(getDateOfBirth().plusYears(18));
		}

	public void setOver18() {
		this.over18 = getOver18();
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", " + address.toString()
				+ ", telephones=" + infoTelephones() + ", date of birth=" + dateOfBirth + ", over18=" + over18 +"]";
	}

}


