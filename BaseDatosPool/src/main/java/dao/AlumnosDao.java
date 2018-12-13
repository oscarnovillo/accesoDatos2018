/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Alumno;

/**
 *
 * @author oscar
 */
public interface AlumnosDao {

  public List<Alumno> getAllAlumnosDBUtils();

  public List<Alumno> getAllAlumnosNotasDBUtils(int id);

  public Alumno addUserDBUtils(Alumno alumno);

  public int updateUserDBUtils(Alumno alumno);

  public int deleteDBUtils(int id);

  public int deleteUserTransaccionDBUtils(Alumno alumno);
}
