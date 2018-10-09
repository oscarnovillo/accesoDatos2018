package ad17.unit2.examples;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class AddressConverter implements SingleValueConverter {

    //Indicates how to convert to String a Telephone object
	public String toString(Object obj) {
            return ((Address) obj).getStreet();
    }

    //Indicates how to get a Telephone object from a string
	public Object fromString(String street) {
    	    Address address=new Address();
    	    address.setStreet(street);
            return address;
    }

    //Indicates the types to be converted
    public boolean canConvert(Class type) {
            return type.equals(Address.class);
    }

}




