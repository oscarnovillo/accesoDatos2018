/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import model.Alumno;
import model.Asignatura;
import model.Nota;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLNotasController implements Initializable {

    private FXMLPrincipalController controller;

    @FXML
    private ComboBox<Asignatura> fxComboAsig;

    @FXML
    private ComboBox<Alumno> fxComboAl;

    private Nota nota;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void nuevo(ActionEvent event) {
        int idAsig;
        int idAl;
        int lineas;

        if (fxComboAsig.getSelectionModel().getSelectedItem() == null || fxComboAl.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            idAsig = fxComboAsig.getSelectionModel().getSelectedItem().getId();
            idAl = fxComboAl.getSelectionModel().getSelectedItem().getId();
            nota = new Nota(idAl, idAsig);

            lineas = controller.getNotasServicio().insertNota(nota);

            if (lineas > 0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Alta OK", ButtonType.CLOSE);
                a.showAndWait();

            } else if (lineas == -2) {
                Alert al = new Alert(Alert.AlertType.ERROR, "Objeto duplicado", ButtonType.CLOSE);
                al.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "No se ha podido crear", ButtonType.CLOSE);
                a.showAndWait();
            }
        }
    }

    public void borrar() {
        int lineas;
        Alumno al = new Alumno();
        Asignatura asig = new Asignatura();

        if (fxComboAsig.getSelectionModel().getSelectedItem() == null || fxComboAl.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            Alert alq = new Alert(Alert.AlertType.CONFIRMATION, "¿Quieres borrar?", ButtonType.YES, ButtonType.NO, ButtonType.CLOSE);
            alq.showAndWait();

            if (alq.getResult() == ButtonType.YES) {

                al = fxComboAl.getSelectionModel().getSelectedItem();
                asig = fxComboAsig.getSelectionModel().getSelectedItem();
                lineas = controller.getNotasServicio().deleteNota(asig, al);

                if (lineas != -1) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Borrado OK", ButtonType.CLOSE);
                    a.showAndWait();
                    fxComboAl.getItems().remove(al);
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "No se ha podido borrar", ButtonType.CLOSE);
                    a.showAndWait();
                }
            }
        }
    }

    public void cargarDatosListaAl() {
        fxComboAl.getItems().clear();
        fxComboAl.getItems().addAll(controller.getAlumnosServicios().getAllAlumnos());
    }

    public void cargarDatosListaAsig() {
        fxComboAsig.getItems().clear();
        fxComboAsig.getItems().addAll(controller.getAsignaturasServicios().getAllAsignatura());
    }

    public void setController(FXMLPrincipalController controller) {
        this.controller = controller;
    }
}
