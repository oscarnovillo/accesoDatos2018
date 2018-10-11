package ad17.unit2.examples;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class AddressConverter implements SingleValueConverter {

    //Indicates how to convert to String a Telephone object
	public String toString(Object obj) {
            return ((Address) obj).getStreet()+"::"+((Address) obj).getNumber();
    }

    //Indicates how to get a Telephone object from a string
	public Object fromString(String street) {
    	    Address address=new Address();
            String []split = street.split("::");
    	    address.setStreet(split[0]);
    	    address.setNumber(Integer.parseInt(split[1]));
            return address;
    }

    //Indicates the types to be converted
    public boolean canConvert(Class type) {
            return type.equals(Address.class);
    }

}




