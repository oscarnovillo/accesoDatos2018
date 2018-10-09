/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PropertyFiles.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
///import org.yaml.snakeyaml.Yaml;
/**
 *
 * @author Lucia
 */
public class ConfigurationYaml {

    private static ConfigurationYaml config;

    private ConfigurationYaml() {

    }



    public static ConfigurationYaml getInstance() {
        if (config == null) {
//            try {
//                Yaml yaml = new Yaml();
//                InputStream in = Files.newInputStream(Paths.get("testFiles/config.yml"));
//                // Parse the YAML document in a stream and produce the corresponding Java object.
//                config = (ConfigurationYaml) yaml.loadAs(in, ConfigurationYaml.class);
//
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(ConfigurationYaml.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(ConfigurationYaml.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
            
        }
        return config;
    }
    
    // The name of the attributes have to be the same as the key's name in the yml file
    private String uno;
    private String dos;
    private String tres;

    
    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public String getTres() {
        return tres;
    }

    public void setTres(String tres) {
        this.tres = tres;
    }

}

