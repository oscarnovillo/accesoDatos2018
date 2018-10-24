/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Alumno;

/**
 * FXML Controller class
 *
 * @author Esther
 */
public class FXMLAlumnosController implements Initializable {

    private FXMLPrincipalController controller;

    @FXML
    private ListView<Alumno> fxList;

    @FXML
    private TextField fxNombre;

    @FXML
    private DatePicker fxFechaNacimiento;

    @FXML
    private Label fxId;

    @FXML
    private RadioButton fxMayorEdad;

    @FXML
    private RadioButton fxMayorEdadNo;

    private Alumno alum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleMouseClick(MouseEvent event) {
        alum = fxList.getSelectionModel().getSelectedItem();
        if (event.getClickCount() >= 1) {
            fxId.setText(Integer.toString(alum.getId()));
            fxNombre.setText(alum.getNombre());
            fxFechaNacimiento.setValue(LocalDate.parse(alum.getFecha_nacimiento() + ""));
            if (alum.getMayor_edad() == false) {
                fxMayorEdadNo.setSelected(true);
                fxMayorEdad.setSelected(false);
            } else {
                fxMayorEdadNo.setSelected(false);
                fxMayorEdad.setSelected(true);
            }
        }
    }

    public void nuevo(ActionEvent event) throws IOException {
        String nombre;
        Date fecha;
        int lineas;

        nombre = fxNombre.getText();

        if (fxFechaNacimiento.getValue() == null || nombre == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            fecha = java.sql.Date.valueOf(fxFechaNacimiento.getValue());
            if (fxMayorEdad.isSelected()) {
                alum = new Alumno(nombre, fecha, Boolean.TRUE);
                alum = controller.getAlumnosServicios().insertAlumno(alum);

            } else {
                alum = new Alumno(nombre, fecha, Boolean.FALSE);
                alum = controller.getAlumnosServicios().insertAlumno(alum);
            }
            if (alum != null) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Alta OK", ButtonType.CLOSE);
                a.showAndWait();
                fxList.getItems().add(alum);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "No se ha podido crear", ButtonType.CLOSE);
                a.showAndWait();
            }
        }
    }

    public void update(ActionEvent event) throws IOException {
        alum = fxList.getSelectionModel().getSelectedItem();
        String nombre;
        int id;
        Date fecha;
        int lineas;
        if (alum == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            nombre = fxNombre.getText();
            alum.setNombre(nombre);
            //pasamos de entero a string
            id = Integer.parseInt(fxId.getText());
            alum.setId(id);

            fecha = java.sql.Date.valueOf(fxFechaNacimiento.getValue());
            alum.setFecha_nacimiento(fecha);

            if (fxMayorEdad.isSelected()) {
                alum.setMayor_edad(Boolean.TRUE);
            } else {
                alum.setMayor_edad(Boolean.FALSE);
            }
            lineas = controller.getAlumnosServicios().updateAlumno(alum);
            if (lineas != -1) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Update OK", ButtonType.CLOSE);
                a.showAndWait();
                fxList.refresh();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "No se ha podido hacer el update", ButtonType.CLOSE);
                a.showAndWait();
            }
        }
    }

    public void borrar() {
        int id;
        int lineas;

        //pasamos de entero a string
        alum = fxList.getSelectionModel().getSelectedItem();
        if (alum == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            id = Integer.parseInt(fxId.getText());
            lineas = controller.getAlumnosServicios().deleteAlumno(id);

            if (lineas > 0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Borrado OK", ButtonType.CLOSE);
                a.showAndWait();
                fxList.getItems().remove(alum);
            } else if (lineas == -2) {
                Alert al = new Alert(Alert.AlertType.WARNING, "Tabla asociada", ButtonType.CLOSE);
                al.showAndWait();
                al = new Alert(Alert.AlertType.CONFIRMATION, "¿Quieres borrar todos sus registros?", ButtonType.YES, ButtonType.NO, ButtonType.CLOSE);
                al.showAndWait();

                if (al.getResult() == ButtonType.YES) {
                    controller.getAlumnosServicios().deleteAlumnoPK(alum);
                    fxList.getItems().remove(alum);
                }

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "No se ha podido borrar", ButtonType.CLOSE);
                a.showAndWait();
            }
        }

    }

    public void cargarDatosLista() {
        fxList.getItems().clear();
        fxList.getItems().addAll(controller.getAlumnosServicios().getAllAlumnos());

    }

    public void setController(FXMLPrincipalController controller) {
        this.controller = controller;
    }
}
