/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class ConfigPropertiesXML {
   private static ConfigPropertiesXML config;

  private Properties properties;

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  private ConfigPropertiesXML() {

  }

  public static ConfigPropertiesXML getInstance() {
    if (config == null) {
      try {
        config = new ConfigPropertiesXML();
        config.properties = new Properties();
        config.properties.loadFromXML(
                new FileInputStream("config/propiedades.xml"));

      } catch (Exception ex) {
        Logger.getLogger(ConfigurationProperties.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
    return config;
  }

}
