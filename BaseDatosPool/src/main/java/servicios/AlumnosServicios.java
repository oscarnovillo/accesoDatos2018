/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnosDao;
import java.util.List;
import model.Alumno;

/**
 *
 * @author oscar
 */
public class AlumnosServicios {

    public List<Alumno> getAllAlumnos() {
        AlumnosDao dao = new AlumnosDao();
        return dao.getAllAlumnosDBUtils();
    }

    public List<Alumno> getAllAlumnosNotas(int id) {
        AlumnosDao dao = new AlumnosDao();

        return dao.getAllAlumnosNotasDBUtils(id);
    }

    public Alumno insertAlumno(Alumno alumnoNuevo) {
        AlumnosDao dao = new AlumnosDao();

        return dao.addUserDBUtils(alumnoNuevo);
    }

    public int updateAlumno(Alumno alumnoNuevo) {
        AlumnosDao dao = new AlumnosDao();

        return dao.updateUserDBUtils(alumnoNuevo);
    }

    public int deleteAlumno(int id) {
        AlumnosDao dao = new AlumnosDao();

        return dao.deleteDBUtils(id);
    }

    public int deleteAlumnoPK(Alumno a) {
        AlumnosDao dao = new AlumnosDao();

        return dao.deleteUserTransaccionDBUtils(a);
    }

}
