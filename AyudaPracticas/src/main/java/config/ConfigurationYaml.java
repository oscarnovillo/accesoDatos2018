/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author oscar
 */
public class ConfigurationYaml {

  private static ConfigurationYaml config;

  private ConfigurationYaml() {

  }

  public static ConfigurationYaml getInstance() {
    if (config == null) {
      try {
        Yaml yaml = new Yaml();
        config = (ConfigurationYaml) yaml.loadAs(
                new FileInputStream("config/configYaml.yml"),
                ConfigurationYaml.class);

      } catch (FileNotFoundException ex) {
        Logger.getLogger(ConfigurationYaml.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
    return config;
  }

  private String user;
  private String pass;

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }
  

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

}
