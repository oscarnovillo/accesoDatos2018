/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Alumno;
import model.Asignatura;
import model.Nota;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLModificarNotasController implements Initializable {

    private FXMLPrincipalController controller;

    @FXML
    private ListView<Alumno> fxList;

    @FXML
    private ComboBox<Asignatura> fxComboAsig;

    @FXML
    private TextField fxNota;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void cargar() {
        int id;
        if (fxComboAsig.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            id = fxComboAsig.getSelectionModel().getSelectedItem().getId();
            fxList.getItems().clear();
            fxList.getItems().addAll(controller.getAlumnosServicios().getAllAlumnosNotas(id));
        }
    }

    @FXML
    public void handleMouseClick(MouseEvent event) {
        int asig;
        int al;
        Nota nota;

        if (event.getClickCount() >= 1) {
            asig = fxComboAsig.getSelectionModel().getSelectedItem().getId();
            al = fxList.getSelectionModel().getSelectedItem().getId();
            nota = controller.getNotasServicio().getNotaById(al, asig);

            fxNota.setText(String.valueOf(nota.getNota()));

        }
    }

    public void update(ActionEvent event) throws IOException {
        Nota nota;
        int al;
        int asig;
        int not;
        int lineas;
        if (fxComboAsig.getSelectionModel().getSelectedItem() == null || fxList.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            try {
                al = fxList.getSelectionModel().getSelectedItem().getId();
                asig = fxComboAsig.getSelectionModel().getSelectedItem().getId();

                //pasamos de entero a string
                not = Integer.parseInt(fxNota.getText());
                nota = new Nota(not, al, asig);

                lineas = controller.getNotasServicio().updateNota(nota);
                if (lineas != -1) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Update OK", ButtonType.CLOSE);
                    a.showAndWait();
                    fxList.refresh();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "No se ha podido hacer el update", ButtonType.CLOSE);
                    a.showAndWait();
                }
            } catch (NumberFormatException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Introduce número en la nota", ButtonType.CLOSE);
                a.showAndWait();
            }
        }
    }

    public void cargarDatosListaAsig() {
        fxComboAsig.getItems().clear();
        fxComboAsig.getItems().addAll(controller.getAsignaturasServicios().getAllAsignaturaNotas());
    }

    public void setController(FXMLPrincipalController controller) {
        this.controller = controller;
    }

}
