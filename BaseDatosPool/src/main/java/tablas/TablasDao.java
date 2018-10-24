/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import config.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw
 */
public class TablasDao {

    public int crearModeloJDBC() {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DriverManager.getConnection(
                    Configuration.getInstance().getUrlDB(),
                    Configuration.getInstance().getUserDB(),
                    Configuration.getInstance().getPassDB());

            stmt = con.prepareStatement("CREATE TABLE alumnos (\n"
                    + "  ID INTEGER IDENTITY NOT NULL ,\n"
                    + "  NOMBRE varchar(250)  DEFAULT NULL,\n"
                    + "  FECHA_NACIMIENTO date DEFAULT NULL,\n"
                    + "  MAYOR_EDAD BOOLEAN DEFAULT NULL,\n"
                    + "  PRIMARY KEY (ID)\n"
                    + ");");
            filas = stmt.executeUpdate();
            stmt = con.prepareStatement(
                    "CREATE TABLE asignaturas (\n"
                    + "  ID INTEGER IDENTITY NOT NULL,\n"
                    + "  NOMBRE varchar(250) NOT NULL,\n"
                    + "  CURSO varchar(250) NOT NULL,\n"
                    + "  CICLO varchar(250) NOT NULL,\n"
                    + "  PRIMARY KEY (ID)\n"
                    + ");");

            filas = stmt.executeUpdate();
            stmt = con.prepareStatement("CREATE TABLE notas (\n"
                    + "  ID_ALUMNOS INTEGER NOT NULL,\n"
                    + "  ID_ASIGNATURAS INTEGER NOT NULL,\n"
                    + "  notas INTEGER DEFAULT 0 NOT NULL ,\n"
                    + "  PRIMARY KEY (ID_ALUMNOS,ID_ASIGNATURAS),\n"
                    + "  CONSTRAINT NOTAS_ALUMNOS FOREIGN KEY (ID_ALUMNOS) REFERENCES alumnos (ID),\n"
                    + "  CONSTRAINT NOTAS_ASIGNATURAS FOREIGN KEY (ID_ASIGNATURAS) REFERENCES asignaturas (ID)\n"
                    + ")");
            filas = stmt.executeUpdate();

            stmt = con.prepareStatement("INSERT INTO alumnos VALUES (403,'manolamhhhh','0032-08-10',0),(412,'Andres Iniesta Iniaquella','1990-11-30',1),(426,'Manolito pue','2017-11-16',1),(431,'papapapajas eso es!!!','2017-11-16',1),(460,'alumno con nota3','2017-01-01',0),(523,'Paco Jones','2017-11-16',1),(525,'holacaracoola','2017-11-30',1),(526,'holacaraculo','2017-11-30',1),(527,'holacaracoola','2017-11-30',1),(530,'admin','2009-11-08',1),(532,'morta','2017-11-30',1),(535,'hola','2019-02-02',0),(723,'test4','2019-02-02',0),(724,'dfgdfg','2018-09-08',1);");

            filas = stmt.executeUpdate();

            stmt = con.prepareStatement("INSERT INTO asignaturas VALUES (83,'damn','damn','damn'),(86,'cabrones','meteos con','EDU'),(94,'yiiha','ahusdau','asdako'),(99,'aaaaa','vvvvv','aaaaa'),(100,'sadasda','asdasdasd','dasdasda'),(111,'hola ','erasto','ketal'),(114,'mu','quien quiera','que seas'),(124,'mu2','que seas','quien quiera'),(129,'peter','peter','peter'),(135,'aa','aa','aa'),(138,'prueba2','2','122'),(142,'pruebba','ba','ba'),(155,'Barsa','Es','Enorme'),(166,'Asignatura','Asignatura','Asignatura'),(175,'asignatura con nota','no tocar','no tocar'),(199,'juan1ssss','juan2','juan1'),(207,'san','tin','valen'),(208,'ingles','tercero','b'),(212,'miau miau','miau miau','miau guau');");

            filas = stmt.executeUpdate();
            stmt = con.prepareStatement("INSERT INTO notas VALUES (403,83,8),(403,155,0),(412,155,5),(426,166,7),(460,175,10),(530,99,5),(530,100,2),(530,111,3),(530,135,5),(723,208,6);");

            filas = stmt.executeUpdate();

            stmt = con.prepareStatement("INSERT INTO notas VALUES (403,86,DEFAULT)");

            filas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(TablasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TablasDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return filas;

    }
}
