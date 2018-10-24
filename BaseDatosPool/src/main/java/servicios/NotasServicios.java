/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.NotasDao;
import java.util.List;
import model.Alumno;
import model.Asignatura;
import model.Nota;

/**
 *
 * @author oscar
 */
public class NotasServicios {

    public List<Nota> getAllNotas() {
        NotasDao dao = new NotasDao();

        return dao.getAllNotasJDBC();
    }

    public Nota getNotaById(int idAl, int idAsig) {
        NotasDao dao = new NotasDao();
        return dao.getNotaJDBC(idAl, idAsig);
    }

    public int insertNota(Nota notaNueva) {
        NotasDao dao = new NotasDao();
        return dao.insertNotaJDBC(notaNueva);
    }

    public int updateNota(Nota nota) {
        NotasDao dao = new NotasDao();

        return dao.updateNotaJDBC(nota);
    }

    public int deleteNota(Asignatura asig, Alumno al) {
        NotasDao dao = new NotasDao();

        return dao.deleteNotasJDBC(al, asig);
    }
}
