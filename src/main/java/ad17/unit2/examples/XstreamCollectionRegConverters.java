package ad17.unit2.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Class for testing XStream Collection Registered converters
**/

public class XstreamCollectionRegConverters {
	public static void main(String[] args) {
		XstreamCollectionRegConverters example = new XstreamCollectionRegConverters();
		example.runExample();
	}

	public void runExample() {
		XStream xStream = new XStream(new DomDriver());
		CollectionsTest classContainingCollection = new CollectionsTest();
		classContainingCollection.initialize();
		String xml = xStream.toXML(classContainingCollection);
		System.out.println(xml);
	}
}

/**
 * Class with different Java collections
 */
class CollectionsTest {

	String[] stringArray = new String[] { "StringA", "StringB", "StringC" };
	char[] charArray = new char[] { 'a', 'b', 'c', 'd', 'e' };
	List<String> listA = new ArrayList<String>();
	Map<String, String> mapA = new HashMap<String, String>();
	Properties properties = new Properties();
	List<String> singletonList;
	Map<String, String> singletonMap;

	TreeMap<String, String> treeMap = new TreeMap<String, String>();
	TreeSet<String> treeSet = new TreeSet<String>();

	enum testEnum {
		testA, testB
	};

	testEnum testeEnumValue = testEnum.testA;
	EnumMap<testEnum, String> testEnumMap = new EnumMap<CollectionsTest.testEnum, String>(
			testEnum.class);
	EnumSet<testEnum> testEnumSet = EnumSet.range(testEnum.testA,
			testEnum.testB);

	public void initialize() {
		listA.add("testA");
		mapA.put("keyA", "ValueA");
		properties.put("propertyA", "valueA");
		treeMap.put("treeA", "valueA");
		treeMap.put("treeB", "valueB");
		treeSet.add("treeB");
		treeSet.add("treeA");
		singletonList = Collections.singletonList("singletonListA");
		singletonMap = Collections.singletonMap("key1", "value1");

		testEnumMap.put(testEnum.testA, "testEnumMapValue1");
		testEnumMap.put(testEnum.testB, "testEnumMapValue2");

	}
}
