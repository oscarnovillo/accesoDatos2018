/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PropertyFiles.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucia
 */
public class BasicPropertyFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path p1 = Paths.get("testFiles/config.properties");
        Properties p = new Properties();
        InputStream propertiesStream=null;
        OutputStream ostream=null;
        
        try {

            propertiesStream = Files.newInputStream(p1);
            // If the config file is stored in the project jar, use the ClassLoader.getSystemResourceAsStream
            //  propertiesStream = ClassLoader.getSystemResourceAsStream("files/properties/config.properties");
            p.load(propertiesStream);
        } catch (IOException ex) {
            Logger.getLogger(BasicPropertyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Read a property
        System.out.println("one="+p.getProperty("one"));
        
        // Default value if property not found
        System.out.println("four="+p.getProperty("four", "default value"));

        //Read all properties
        Enumeration<Object> keys = p.keys();

        while (keys.hasMoreElements()){
            Object key = keys.nextElement();
            System.out.println(key + " = "+ p.get(key));
        }
    
        //Adding a property
        p.setProperty("four", "4");
        try {
            ostream = Files.newOutputStream(p1);
            //p.store(ostream,"fourth element added");
            p.store(ostream,"fourth element added");
        } catch (IOException ex) {
            Logger.getLogger(BasicPropertyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Modifying a property
        p.setProperty("one", "5");
        try {
            ostream = Files.newOutputStream(p1);
            p.store(ostream,"fourth element added");
        } catch (IOException ex) {
            Logger.getLogger(BasicPropertyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
