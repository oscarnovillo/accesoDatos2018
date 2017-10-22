package ad17.unit2.examples;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XstreamBasicRegConverters {

	public static void main(String[] args) throws MalformedURLException,
			URISyntaxException {
		XstreamBasicRegConverters converter = new XstreamBasicRegConverters();
		converter.convert();
	}

	/**
	 * Use of registered converters
	 * @throws MalformedURLException
	 * @throws URISyntaxException
	 */
	private void convert() throws MalformedURLException, URISyntaxException {

		BasicTypes basicConverterExample = new BasicTypes();
		basicConverterExample.initialize();

		XStream xStream = new XStream(new DomDriver());
		// XStream security framework, for defining which types are allowed to be unmarshalled with XStream 
		// to be removed after 1.5
		XStream.setupDefaultSecurity(xStream); 
		xStream.allowTypesByWildcard(new String[] {"ad17.unit2.examples.*"});
		
		//Boolean converter only for the flag attribute
		xStream.registerLocalConverter(BasicTypes.class, "flag",
				BooleanConverter.BINARY);

		//Specific date converter for all Date attributes
		DateConverter dateConverter = new DateConverter("dd-MM-yyyy HH:mm:ss",
				new String[] {}, TimeZone.getTimeZone("GMT+2"));
		xStream.registerConverter(dateConverter);

		//All the other converters are applied automatically
		String xml = xStream.toXML(basicConverterExample);

		System.out.println(xml);

		BasicTypes basicConverterFromXML = (BasicTypes) xStream
				.fromXML(xml);
		System.out.println(basicConverterFromXML);

	}

	/**
	 * Test class with attributes of all Java types for testing Xstream registered converters
	 */
	class BasicTypes {
		BigDecimal bigDecimal = new BigDecimal(10000000000.0);
		BigInteger bigInteger = new BigInteger("1000000000");
		boolean flag = true;
		boolean flag2=false;
		byte byteA = 'a';
		char charA = 'a';
		Date date = new Date();
		Date date1 = new Date();
		Double doubleA = new Double(1000000000000.0);
		Float floatA = new Float(10000000000000f);
		int intA = 100;
		Long longA = new Long(100000);
		Object nullA = null;
		Short shortA = new Short((short) 1);
		StringBuffer stringBufferA = new StringBuffer("test");
		StringBuilder stringBuilderA = new StringBuilder().append("test");
		URI UriA = null;
		URL urlA = null;
		UUID uuidA = UUID.fromString("0000000a-000b-000c-000d-00000000000e");

		public void initialize() throws URISyntaxException,
				MalformedURLException {
			UriA = new URI("file://C/work/fileA");
			urlA = new URL("http://www.google.com");
		}

		@Override
		public String toString() {
			return "BasicTypes [bigDecimal=" + bigDecimal + ", bigInteger="
					+ bigInteger + ", flag=" + flag +  ", flag2=" + flag2 +", byteA=" + byteA
					+ ", charA=" + charA + ", date=" + date + ", date1=" + date1+ ", doubleA="
					+ doubleA + ", floatA=" + floatA + ", intA=" + intA
					+ ", longA=" + longA + ", nullA=" + nullA + ", shortA="
					+ shortA + ", stringBufferA=" + stringBufferA
					+ ", stringBuilderA=" + stringBuilderA + ", UriA=" + UriA
					+ ", urlA=" + urlA + ", uuidA=" + uuidA + "]";
		}

	}

}
