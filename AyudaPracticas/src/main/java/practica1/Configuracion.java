/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import config.ConfigurationProperties;
import config.ConfigurationYaml;

/**
 *
 * @author oscar
 */
public class Configuracion {

  public static void main(String[] args) {

    System.out.println(
            ConfigurationProperties.getInstance()
                    .getProperties().getProperty("file"));
    System.out.println(
            ConfigurationProperties.getInstance()
                    .getProperties().getProperty("nuevo"));
    System.out.println(
            ConfigurationProperties.getInstance()
                    .getProperties().getProperty("nf"));
    
    
    System.out.println(
            ConfigurationYaml.getInstance().getUser());
  }

}
