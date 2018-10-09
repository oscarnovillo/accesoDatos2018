/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author oscar
 */
public class LocalDateToString {
    public static void main(String[] args) {

        String now = "2016-11-09 10:30";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);

        System.out.println("Before : " + now);
        
        String sFormatDateTime = formatDateTime.format(formatter);

        System.out.println("After  sdasd  : " + sFormatDateTime);

        System.out.println("After : " + formatDateTime.format(formatter));

    }
}
