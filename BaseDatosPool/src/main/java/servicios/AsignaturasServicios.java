/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDao;
import java.util.List;
import model.Asignatura;

/**
 *
 * @author oscar
 */
public class AsignaturasServicios {

    public List<Asignatura> getAllAsignatura() {
        AsignaturasDao dao = new AsignaturasDao();

        return dao.getAllAsignaturasJDBCTemplate();
    }

    public List<Asignatura> getAllAsignaturaNotas() {
        AsignaturasDao dao = new AsignaturasDao();

        return dao.getAllAsignaturasNotasJDBCTemplate();
    }

    public Asignatura insertAsignatura(Asignatura aignaturaNueva) {
        AsignaturasDao dao = new AsignaturasDao();

        return dao.addAsignaturaJDBCTemplate(aignaturaNueva);
    }

    public int updateAsignatura(Asignatura aignaturaNueva) {
        AsignaturasDao dao = new AsignaturasDao();

        return dao.updateJDBCTemplate(aignaturaNueva);
    }

    public int deleteAsignatura(int id) {
        AsignaturasDao dao = new AsignaturasDao();

        return dao.deleteJDBCTemplate(id);
    }

    public int deleteAsignaturaPK(Asignatura a) {
        AsignaturasDao dao = new AsignaturasDao();

        return dao.deleteTransaccJDBCTemplate(a);
    }
}
