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
public class ParsearString {

    public static void main(String[] args) {

        String linea = "29384792836498;5;2018-12-12";
     
        String[] partes = linea.split(";");
        System.out.println(partes[2]);
        System.out.println(
    linea.substring(linea.lastIndexOf(";") + 1));

    }
}
