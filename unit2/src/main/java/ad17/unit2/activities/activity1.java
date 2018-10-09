package ad17.unit2.activities;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import ad17.unit2.examples.AddressConverter;
import ad17.unit2.examples.Person;

public class activity1 {

	public static void main(String[] args) {
		Blog teamBlog = new Blog(new Author("Guilherme", "Silveira"));
        teamBlog.add(new Entry("first","My first blog entry."));
        teamBlog.add(new Entry("tutorial",
                "Today we have developed a nice alias tutorial. Tell your friends! NOW!"));

      //Using parser JAXP DOM, importing package com.thoughtworks.xstream.io.xml.DomDriver
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("blog", Blog.class);
        xstream.alias("entry", Entry.class);
        xstream.aliasField("author", Blog.class, "writer");
        //xstream.addImplicitCollection(Blog.class, "entries");
        
        System.out.println(xstream.toXML(teamBlog));

	}

}
