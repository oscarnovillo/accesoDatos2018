/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class MainChorraPruebaBD {

  public static void main(String[] args) {

    DBConnection db = new DBConnection();
    ResultSet resultSet = null;
    Connection con = null;
    PreparedStatement stmt = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      con = DriverManager
              .getConnection("jdbc:mysql://db4free.net:3306/daw2_pruebas", "oscarnovillo", "1235b1a9");
      int idActor = 1;
      String selectSql = "SELECT * FROM actor where fk_actor = ?";

      stmt = con.prepareStatement(selectSql);
      stmt.setInt(1, idActor);

      resultSet = stmt.executeQuery();

      while (resultSet.next()) {
        System.out.println("fila nueva");
        System.out.print(resultSet.getInt(1) + " ");
        System.out.print(resultSet.getInt(2));
        System.out.println();
      }
      System.out.println("ok");

    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(MainChorraPruebaBD.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      db.cerrarResultSet(resultSet);
      db.cerrarStatement(stmt);
      db.cerrarConexion(con);
    }

   
    
    try {
      con = DriverManager
              .getConnection("jdbc:mysql://db4free.net:3306/daw2_pruebas", "oscarnovillo", "1235b1a9");
      int idActor = 1;
      String selectSql = 
              "update actor set n_oscars =? "
              + "where fk_actor = ?";

      stmt = con.prepareStatement(selectSql);
      stmt.setInt(2, idActor);
      stmt.setInt(1, 23);

      int numeroFilas = stmt.executeUpdate();

      
      System.out.println(" filas actualizadas "+numeroFilas);

    } catch ( SQLException ex) {
      Logger.getLogger(MainChorraPruebaBD.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      db.cerrarStatement(stmt);
      db.cerrarConexion(con);
    }
    
    try {
      con = DriverManager
              .getConnection("jdbc:mysql://db4free.net:3306/daw2_pruebas", "oscarnovillo", "1235b1a9");
      int idActor = 1;
      String selectSql = 
              "delete from actor "
              + "where fk_actor = ?";

      stmt = con.prepareStatement(selectSql);
   
      stmt.setInt(1, 1);

      int numeroFilas = stmt.executeUpdate();

      
      System.out.println(" filas actualizadas "+numeroFilas);

    }   catch ( SQLIntegrityConstraintViolationException ex) {
      System.out.println("FK CONTRASNTNINT");
    }
    catch ( SQLException ex) {
      Logger.getLogger(MainChorraPruebaBD.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      db.cerrarStatement(stmt);
      db.cerrarConexion(con);
    }
 

  try {
      con = DriverManager
              .getConnection("jdbc:mysql://db4free.net:3306/daw2_pruebas", "oscarnovillo", "1235b1a9");
      int idActor = 1;
      String selectSql = 
              "insert into empleado (nombre,apellidos,edad) "
              + "values (?,?,?)";

      stmt = con.prepareStatement(selectSql);
   
      stmt.setString(1, "juan");
      stmt.setString(2, "guti");
      stmt.setInt(3, 21);

      int numeroFilas = stmt.executeUpdate();

      
      System.out.println(" filas actualizadas "+numeroFilas);

    } 
    catch ( SQLException ex) {
      Logger.getLogger(MainChorraPruebaBD.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      db.cerrarStatement(stmt);
      db.cerrarConexion(con);
    }
  }

}
