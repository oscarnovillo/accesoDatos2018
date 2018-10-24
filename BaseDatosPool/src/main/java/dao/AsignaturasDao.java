/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asignatura;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author oscar
 */
public class AsignaturasDao {

    //select JDBCTemplate
    public List<Asignatura> getAllAsignaturasJDBCTemplate() {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnectionPool.getInstance().getDataSource());
        List<Asignatura> asignatura = jtm.query("Select * from asignaturas",
                new BeanPropertyRowMapper(Asignatura.class));

        return asignatura;
    }

    //Select JDBCTemplate
    public List<Asignatura> getAllAsignaturasNotasJDBCTemplate() {
        JdbcTemplate jtm = new JdbcTemplate(
                DBConnectionPool.getInstance().getDataSource());
        List<Asignatura> asignatura = jtm.query("SELECT * FROM asignaturas where id in(select distinct(ID_ASIGNATURAS) from notas)",
                new BeanPropertyRowMapper(Asignatura.class));
        return asignatura;
    }

    //insert spring jdbc template
    public Asignatura addAsignaturaJDBCTemplate(Asignatura a) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(
                DBConnectionPool.getInstance().getDataSource()).withTableName("asignaturas").usingGeneratedKeyColumns("ID");
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("NOMBRE", a.getNombre());
        parameters.put("CICLO", a.getCiclo());
        parameters.put("CURSO", a.getCurso());
        a.setId((int) jdbcInsert.executeAndReturnKey(parameters).longValue());
        return a;
    }

    // update JDBCTemplate
    public int updateJDBCTemplate(Asignatura a) {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnectionPool.getInstance().getDataSource());
        String updateQuery = "update asignaturas set NOMBRE = ?, CICLO=?, CURSO=? where id = ?";
        int filas = jtm.update(updateQuery, a.getNombre(), a.getCiclo(), a.getCurso(), a.getId());

        return filas;
    }

    //delete JDBCTemplate
    public int deleteJDBCTemplate(int id) {
        int filas = -1;

        try {
            JdbcTemplate jtm = new JdbcTemplate(
                    DBConnectionPool.getInstance().getDataSource());
            String updateQuery = "delete from asignaturas where id = ?";

            filas = jtm.update(updateQuery, id);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("violación")) {
                filas = -2;
            }
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return filas;
    }

    // delete trannsaccion JDBCTemplate
    public int deleteTransaccJDBCTemplate(Asignatura a) {
        int filas = -1;
        TransactionDefinition txDef = new DefaultTransactionDefinition();
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(DBConnectionPool.getInstance().getDataSource());
        TransactionStatus txStatus = transactionManager.getTransaction(txDef);

        try {

            JdbcTemplate jtm = new JdbcTemplate(
                    transactionManager.getDataSource());
            String updateQuery = "delete from notas where ID_ASIGNATURAS = ?";
            filas = jtm.update(updateQuery, a.getId());

            updateQuery = "delete from asignaturas where ID = ?";
            filas = jtm.update(updateQuery, a.getId());

            transactionManager.commit(txStatus);

        } catch (Exception e) {

            transactionManager.rollback(txStatus);

            throw e;

        }

        return filas;
    }

}
