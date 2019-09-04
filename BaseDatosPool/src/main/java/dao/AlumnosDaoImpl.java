/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import model.Alumno;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author oscar
 */
public class AlumnosDaoImpl implements AlumnosDao{

    //Select DBUtils
    public List<Alumno> getAllAlumnosDBUtils() {
        List<Alumno> lista = null;

        Connection con = null;
        try {
            con = DBConnectionPool.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> handler
                    = new BeanListHandler<>(Alumno.class);
            lista = qr.query(con, "select * FROM alumnos", 
                    handler);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    //Select DBUtils
    public List<Alumno> getAllAlumnosNotasDBUtils(int id) {
        List<Alumno> lista = null;

        Connection con = null;
        try {
            con = DBConnectionPool.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> handler
                    = new BeanListHandler<>(Alumno.class);
            lista = qr.query(con, "SELECT * FROM alumnos a join notas n on n.ID_ALUMNOS=a.id where n.ID_ASIGNATURAS=?", handler, id);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    // insert DBUTILS
    public Alumno addUserDBUtils(Alumno alumno) {

        Connection con = null;

        try {
            con = DBConnectionPool.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();

            Number id = qr.insert(con,
                    "INSERT INTO alumnos (NOMBRE, FECHA_NACIMIENTO, MAYOR_EDAD) VALUES(?,?,?)",
                    new ScalarHandler<>(),
                    alumno.getNombre(), 
                    alumno.getFecha_nacimiento(), 
                    alumno.getMayor_edad());

            alumno.setId((int) id.longValue());
            con.commit();

        } catch (Exception ex) {
            try {
                Logger.getLogger(AlumnosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(AlumnosDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return alumno;

    }

    //update DBUTILS
    public int updateUserDBUtils(Alumno alumno) {

        Connection con = null;
        int filas = -1;
        try {
            con = DBConnectionPool.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    "UPDATE alumnos SET NOMBRE = ?, FECHA_NACIMIENTO = ?, MAYOR_EDAD = ? WHERE ID = ?",
                    alumno.getNombre(), alumno.getFecha_nacimiento(), alumno.getMayor_edad(), alumno.getId());

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return filas;

    }

    //delete DBUTILS
    public int deleteDBUtils(int id) {
        int filas = -1;
        Connection con = null;

        try {
            con = DBConnectionPool.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    "DELETE FROM alumnos WHERE ID = ?", id);

        } catch (SQLException e) {
            if (e.getMessage().contains("violación")) {
                filas = -2;
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumnosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return filas;

    }

    //delete transaccion DBUTILS
    public int deleteUserTransaccionDBUtils(Alumno alumno) {
        int filas = -1;
        Connection con = null;

        try {
            con = DBConnectionPool.getInstance().getConnection();

            con.setAutoCommit(false);

            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    "DELETE FROM notas WHERE ID_ALUMNOS = ?", alumno.getId());

            filas += qr.update(con,
                    "DELETE FROM alumnos WHERE ID = ?", alumno.getId());

            con.commit();

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return filas;

    }

}
