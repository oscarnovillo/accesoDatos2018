/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oscar
 */
public class MainChorraPruebaBD {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager
            .getConnection("jdbc:mysql://db4free.net:3306/daw2_pruebas", "oscarnovillo", "1235b1a9");
     int idActor =1;
    String selectSql = "SELECT * FROM actor where fk_actor = ?";

    PreparedStatement stmt = con.prepareStatement(selectSql);
    stmt.setInt(1, idActor);
    ResultSet resultSet = stmt.executeQuery();
    
    while (resultSet.next())
    {
      System.out.println("fila nueva");
      System.out.print(resultSet.getInt(1)+" ");
      System.out.print(resultSet.getInt(2));
      System.out.println();
    }
    System.out.println("ok");
    
    
    resultSet.close();
    stmt.close();
    con.close();
  }

}
