/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;
import model.Nota;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author daw
 */
public class NotasDao {

    // Select JDBC
    public List<Nota> getAllNotasJDBC() {
        List<Nota> lista = new ArrayList<>();
        Nota nuevo = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();

            stmt = con.createStatement();
            String sql;
            sql = "SELECT * FROM notas";
            rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int nota = rs.getInt("notas");
                int idAsig = rs.getInt("ID_ASIGNATURAS");
                int idAl = rs.getInt("ID_ALUMNOS");

                nuevo = new Nota();
                nuevo.setAl(idAl);
                nuevo.setAsig(idAsig);
                nuevo.setNota(nota);
                lista.add(nuevo);
            }

        } catch (Exception ex) {
            Logger.getLogger(NotasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotasDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            db.cerrarConexion(con);
        }
        return lista;

    }
    //Select DBUtils

    public List<Asignatura> getAllNotasDBUtils() {
        List<Asignatura> lista = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura>> handler
                    = new BeanListHandler<Asignatura>(Asignatura.class);
            lista = qr.query(con, "select * FROM notas", handler);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            db.cerrarConexion(con);
        }
        return lista;
    }

    //select where
    public Nota getNotaJDBC(int idAl, int idAsig) {
        Nota nuevo = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            stmt = con.prepareStatement("SELECT * FROM notas where ID_ASIGNATURAS=? and ID_ALUMNOS=?");

            stmt.setInt(1, idAsig);
            stmt.setInt(2, idAl);

            rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            rs.next();
            //Retrieve by column name
            int nota = rs.getInt("notas");
            idAl = rs.getInt("id_alumnos");
            idAsig = rs.getInt("id_asignaturas");

            nuevo = new Nota();
            nuevo.setAl(idAl);
            nuevo.setAsig(idAsig);
            nuevo.setNota(nota);
        } catch (Exception ex) {
            Logger.getLogger(NotasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con!=null)
                {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(NotasDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nuevo;

    }

    //inser JDBC
    public int insertNotaJDBC(Nota a) {
        int filas = -1;
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = db.getConnection();

            stmt = con.prepareStatement("INSERT INTO notas (ID_ALUMNOS,ID_ASIGNATURAS) VALUES(?,?);");

            stmt.setInt(1, a.getAl());
            stmt.setInt(2, a.getAsig());

            filas = stmt.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            filas = -2;

        } catch (Exception ex) {
            Logger.getLogger(NotasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(NotasDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.cerrarConexion(con);
        }

        return filas;
    }

    // insert DBUTILS
    public Nota addNotasDBUtils(Nota nota, String activacion) {

        Connection con = null;
        DBConnection db = new DBConnection();
        try {
            con = db.getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();

            BigInteger id = qr.insert(con,
                    "INSERT INTO notas (ID_ALUMNOS,ID_ASIGNATURAS) VALUES(?,?);",
                    new ScalarHandler<BigInteger>(),
                    "", "");

            nota.setNota((int) id.longValue());
            con.commit();

        } catch (Exception ex) {
            try {
                Logger.getLogger(AlumnosDao.class.getName()).log(Level.SEVERE, null, ex);
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(AlumnosDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            db.cerrarConexion(con);
        }
        return nota;

    }

    //update JDBC
    public int updateNotaJDBC(Nota nota) {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        DBConnection db = new DBConnection();
        try {
            con = db.getConnection();

            stmt = con.prepareStatement("UPDATE notas " + "set notas=? " + "where ID_ASIGNATURAS=? AND ID_ALUMNOS=?");

            stmt.setInt(1, nota.getNota());
            stmt.setInt(2, nota.getAsig());
            stmt.setInt(3, nota.getAl());

            filas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(NotasDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotasDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.cerrarConexion(con);
        }

        return filas;
    }

    public Nota updateNotasDBUtils(Nota nota, String activacion) {

        Connection con = null;
        DBConnection db = new DBConnection();
        try {
            con = db.getConnection();

            QueryRunner qr = new QueryRunner();

            int filas = qr.update(con,
                    "UPDATE notas " + "set notas=? " + "where ID_ASIGNATURAS=? AND ID_ALUMNOS=?",
                    nota.getAl(), nota.getAsig(), nota.getNota());

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return nota;

    }

    //DELETE JDBC
    public int deleteNotasJDBC(Alumno al, Asignatura asig) {
        int idAsig;
        int idAlum;
        DBConnection db = new DBConnection();
//        Connection con = null;
//        PreparedStatement stmt = null;
        int filas = -1;

        idAsig = asig.getId();
        idAlum = al.getId();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement("DELETE FROM notas where ID_ASIGNATURAS=? & ID_ALUMNOS=?");){
            
            stmt.setInt(1, idAsig);
            stmt.setInt(2, idAlum);

            filas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(NotasDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
        }

        return filas;
    }

}
