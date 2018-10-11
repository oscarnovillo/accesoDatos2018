package ad17.unit2.activities;

public class Student {

	String firstName;
	String lastName;
	int yearOfBirth;
	Address address;

  public Student() {
  }

public Student(String firstName, String lastName, int yearOfBirth,
			String street, int number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = new Address(street, number);
		this.yearOfBirth = yearOfBirth;

	}

	public Student(Student student) {
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.yearOfBirth = student.getYearOfBirth();
		this.address = new Address(student.address);

	}


	public void setAddress(String street, int number) {
		this.address.setStreet(street);
		this.address.setNumber(number);
	}


	public String getAddress() {
		return address.street + " " + address.number;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public int getYearOfBirth() {
		return yearOfBirth;
	}


	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}


	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String toString() {
		return "Student's name:" + getFirstName() + " " + getLastName()
				+ "\tYear of birth:" + getYearOfBirth()
				+ "\tAddress:" + getAddress();

	}

	/**
	 * Method to check if two students are equal
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student c = (Student) obj;
		if (firstName.equals(c.getFirstName()) && lastName.equals(c.getLastName())
				&& yearOfBirth == c.getYearOfBirth())
			return true;
		else
			return false;
	}

	/**
	 * When overwriting method equals, method hashCode has to be also overwritten */
	
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
		hash = 71 * hash
				+ (this.lastName != null ? this.lastName.hashCode() : 0);
		hash = 71 * hash + (int) this.yearOfBirth;

		return hash;
	}

	/**
	 * Private class Address
	 */
	private class Address {

		String street;
		int number;

		private Address(String street, int number) {
			this.street = street;
			this.number = number;
		}

		private Address(Address address) {
			this.street = address.getStreet();
			this.number = address.getNumber();
		}

		private String getStreet() {
			return street;
		}

		private void setStreet(String street) {
			this.street = street;
		}

		private int getNumber() {
			return number;
		}

		private void setNumber(int number) {
			this.number = number;
		}
	}
}
