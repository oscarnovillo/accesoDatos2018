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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Asignatura;

/**
 * FXML Controller class
 *
 * @author Esther
 */
public class FXMLAsignaturasController implements Initializable {

    private FXMLPrincipalController controller;

    @FXML
    private ListView<Asignatura> fxList;

    @FXML
    private TextField fxNombre;

    @FXML
    private TextField fxCiclo;

    @FXML
    private TextField fxCurso;

    @FXML
    private Label fxId;

    private Asignatura asig;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleMouseClick(MouseEvent event) {
        asig = fxList.getSelectionModel().getSelectedItem();
        if (event.getClickCount() >= 1) {
            fxId.setText(Integer.toString(asig.getId()));
            fxNombre.setText(asig.getNombre());
            fxCiclo.setText(asig.getCiclo());
            fxCurso.setText(asig.getCurso());
        }
    }

    public void nuevo(ActionEvent event) throws IOException {
        String nombre;
        String ciclo;
        String curso;
        int lineas;
        int id;

        nombre = fxNombre.getText();
        ciclo = fxCiclo.getText();
        curso = fxCurso.getText();

        asig = new Asignatura(nombre, curso, ciclo);
        if (fxNombre.getText().isEmpty() || fxCiclo.getText().isEmpty() || fxCurso.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            controller.getAsignaturasServicios().insertAsignatura(asig);

            if (asig != null) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Alta OK", ButtonType.CLOSE);
                a.showAndWait();
                fxList.getItems().add(asig);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "No se ha podido crear", ButtonType.CLOSE);
                a.showAndWait();
            }
        }
    }

    public void update(ActionEvent event) throws IOException {
        asig = fxList.getSelectionModel().getSelectedItem();
        String nombre;
        String ciclo;
        String curso;
        int id;
        int lineas;
        if (asig == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            nombre = fxNombre.getText();
            asig.setNombre(nombre);
            //pasamos de entero a string
            id = Integer.parseInt(fxId.getText());
            asig.setId(id);

            ciclo = fxCiclo.getText();
            asig.setCiclo(ciclo);

            curso = fxCurso.getText();
            asig.setCurso(curso);

            lineas = controller.getAsignaturasServicios().updateAsignatura(asig);
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

        if (fxId.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No hay datos", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            id = Integer.parseInt(fxId.getText());
            lineas = controller.getAsignaturasServicios().deleteAsignatura(id);
            if (lineas > 0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Borrado OK", ButtonType.CLOSE);
                a.showAndWait();
                fxList.getItems().remove(asig);
            } else if (lineas == -2) {
                Alert al = new Alert(Alert.AlertType.WARNING, "Tabla asociada", ButtonType.CLOSE);
                al.showAndWait();
                al = new Alert(Alert.AlertType.CONFIRMATION, "¿Quieres borrar todos sus registros?", ButtonType.YES, ButtonType.NO, ButtonType.CLOSE);
                al.showAndWait();

                if (al.getResult() == ButtonType.YES) {
                    controller.getAsignaturasServicios().deleteAsignaturaPK(asig);
                    fxList.getItems().remove(asig);
                }
            }
        }
    }

    public void cargarDatosLista() {
        fxList.getItems().clear();
        fxList.getItems().addAll(this.controller.getAsignaturasServicios().getAllAsignatura());
    }

    public void setController(FXMLPrincipalController controller) {
        this.controller = controller;
    }
}
