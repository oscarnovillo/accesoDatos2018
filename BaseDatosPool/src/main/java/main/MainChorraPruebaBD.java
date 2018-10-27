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

//    Class.forName("com.mysql.cj.jdbc.Driver");
//    Connection con = DriverManager
//            .getConnection("jdbc:mysql://localhost:3310/daw2_pruebas", "root", "root");
//     int idActor =1;
//    String selectSql = "SELECT * FROM actor";
//
//    PreparedStatement stmt = con.prepareStatement(selectSql);
//    stmt.setInt(1, idActor);
//    ResultSet resultSet = stmt.executeQuery();
//    
//    while (resultSet.next())
//    {
//      System.out.println("fila nueva");
//      System.out.print(resultSet.getInt(1)+" ");
//      System.out.print(resultSet.getInt(2));
//      System.out.println();
//    }
//    System.out.println("ok");
//    
    
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection con = DriverManager
            .getConnection("jdbc:sqlserver://localhost:1434;databaseName=dam2_pruebas;user=sa;password=@dminQbdo18");
    PreparedStatement  stmt = con.prepareStatement("SELECT * from alumnos");
   // stmt.setInt(1, idActor);
    ResultSet resultSet = stmt.executeQuery();
    
    while (resultSet.next())
    {
      System.out.println("fila nueva");
      System.out.print(resultSet.getInt(1)+" ");
      System.out.print(resultSet.getString(2));
      System.out.println();
    }
//    resultSet.close();
//    stmt.close();
//    con.close();
  }

}
