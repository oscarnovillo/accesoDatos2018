/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author oscar
 */
public class Modulo {

  public static void main(String[] args) {
    int j = 10;
    j += 63;
    j = j % 31;
System.out.println(j);
    j += -63;
    
    j = j % 31;
    System.out.println(j);
  }
}
