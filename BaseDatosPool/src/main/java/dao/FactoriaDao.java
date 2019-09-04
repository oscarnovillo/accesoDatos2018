/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author oscar
 */
public class FactoriaDao {
  
  public static final int DAO_JDBC = 1;
  public static final int DAO_DBUTILS = 2;
  
  
  public AlumnosDao getAlumnosDAO(int tipoDAO)
  {
    AlumnosDao dao = null;
    if (tipoDAO == DAO_JDBC)
      dao = null; //new AlumnosDaoImplJDBC();
    else if (tipoDAO == DAO_DBUTILS)
      dao = new AlumnosDaoImpl();
    return dao;
  }
  
}
