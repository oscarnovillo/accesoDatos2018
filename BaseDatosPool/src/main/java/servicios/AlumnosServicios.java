/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnosDao;
import dao.AlumnosDaoImpl;
import dao.AlumnosDaoImplJDBC;
import dao.FactoriaDao;
import java.util.List;
import model.Alumno;

/**
 *
 * @author oscar
 */
public class AlumnosServicios {

  private FactoriaDao factory;
  
  public AlumnosServicios() {
    factory = new FactoriaDao();
  }

    public List<Alumno> getAllAlumnos() {
        AlumnosDao dao = factory.getAlumnosDAO
        (FactoriaDao.DAO_JDBC);
        return dao.getAllAlumnosDBUtils();
    }

    public List<Alumno> getAllAlumnosNotas(int id) {
      
        AlumnosDao dao = new AlumnosDaoImplJDBC();

        return dao.getAllAlumnosNotasDBUtils(id);
    }

    public Alumno insertAlumno(Alumno alumnoNuevo) {
        AlumnosDao dao = new AlumnosDaoImpl();

        return dao.addUserDBUtils(alumnoNuevo);
    }

    public int updateAlumno(Alumno alumnoNuevo) {
        AlumnosDao dao = new AlumnosDaoImpl();

        return dao.updateUserDBUtils(alumnoNuevo);
    }

    public int deleteAlumno(int id) {
        AlumnosDao dao = new AlumnosDaoImpl();

        return dao.deleteDBUtils(id);
    }

    public int deleteAlumnoPK(Alumno a) {
        AlumnosDao dao = new AlumnosDaoImpl();

        return dao.deleteUserTransaccionDBUtils(a);
    }

}
