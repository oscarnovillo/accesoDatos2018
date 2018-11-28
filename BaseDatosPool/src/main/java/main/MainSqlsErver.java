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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class MainSqlsErver {

  public static void main(String[] args) {

    DBConnection db = new DBConnection();
    ResultSet resultSet = null;
    Connection con = null;
    PreparedStatement stmt = null;
    try {
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      //Class.forName("com.mysql.cj.jdbc.Driver");

      String connectionUrl =
                "jdbc:sqlserver://2DAM_PROFESOR;"
                + "database=Tienda;"
              + "integratedSecurity=true;";
//                + "user=sa;"
//                + "password=root;"
//                + "encrypt=true;"
//                + "trustServerCertificate=false;"
//                
//                + "loginTimeout=30;";

      
     con = DriverManager.getConnection(
                connectionUrl);

      int idActor = 1;
      String selectSql = "SELECT * FROM Table_1";

      stmt = con.prepareStatement(selectSql);

      resultSet = stmt.executeQuery();

      while (resultSet.next()) {
        System.out.println("fila nueva");
        System.out.print(resultSet.getInt(1) + " ");
        System.out.print(resultSet.getString(2));
        System.out.println();
      }
      System.out.println("ok");

    } catch (Exception ex) {
      Logger.getLogger(MainChorraPruebaBD.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      db.cerrarResultSet(resultSet);
      db.cerrarStatement(stmt);
      db.cerrarConexion(con);
    }

  }

}
