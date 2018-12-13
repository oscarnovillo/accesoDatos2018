/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import constantes.Constantes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import servicios.AlumnosServicios;
import servicios.AsignaturasServicios;
import servicios.NotasServicios;

/**
 * FXML Controller class
 *
 * @author Esther
 */
public class FXMLPrincipalController implements Initializable {

  @FXML
  private BorderPane fxRoot;
  @FXML
  private MenuBar fxMenu;

  private AnchorPane principal;
  private AnchorPane alumnos;
  private AnchorPane asignaturas;
  private AnchorPane notas;
  private AnchorPane modificarNotas;

  private FXMLAlumnosController controllerAlum;
  private FXMLAsignaturasController controllerAsig;
  private FXMLNotasController controllerNotas;
  private FXMLModificarNotasController controllerModNotas;

  private AlumnosServicios alumnosServicios;
  private AsignaturasServicios asignaturasServicios;
  private NotasServicios notasServicio;

  /**
   * Initializes the controller class.
   */
  @FXML
  public void handleScene1(ActionEvent event) throws IOException {
    fxRoot.setCenter(principal);

  }

  @FXML
  public void handleSceneAlumnos() {
    fxRoot.setCenter(alumnos);
  }

  @FXML
  public void handleSceneAsignaturas() {
    fxRoot.setCenter(asignaturas);
  }

  @FXML
  public void handleSceneNotas() {
    fxRoot.setCenter(notas);
    controllerNotas.cargarDatosListaAl();
    controllerNotas.cargarDatosListaAsig();
  }

  @FXML
  public void handleSceneModNotas() {
    fxRoot.setCenter(modificarNotas);
    controllerModNotas.cargarDatosListaAsig();
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    alumnosServicios = new AlumnosServicios();
    asignaturasServicios = new AsignaturasServicios();
    notasServicio = new NotasServicios();

    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(Constantes.PANTALLA_ALUMNOS));
      alumnos = loader.load();
      controllerAlum = loader.getController();
      controllerAlum.setController(this);

      loader = new FXMLLoader(getClass().getResource(Constantes.PANTALLA_ASIGNATURAS));
      asignaturas = loader.load();
      controllerAsig = loader.getController();
      controllerAsig.setController(this);

      loader = new FXMLLoader(getClass().getResource(Constantes.PANTALLA_NOTAS));
      notas = loader.load();
      controllerNotas = loader.getController();
      controllerNotas.setController(this);

      loader = new FXMLLoader(getClass().getResource(Constantes.PANTALLA_MODIFICAR_NOTAS));
      modificarNotas = loader.load();
      controllerModNotas = loader.getController();
      controllerModNotas.setController(this);

      fxRoot.setCenter(alumnos);
      fxMenu.setVisible(true);

      controllerAsig.cargarDatosLista();
      controllerAlum.cargarDatosLista();
      controllerNotas.cargarDatosListaAl();
      controllerNotas.cargarDatosListaAsig();
      controllerModNotas.cargarDatosListaAsig();

    } catch (IOException ex) {

      Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public AlumnosServicios getAlumnosServicios() {
    if (alumnosServicios == null) {
      alumnosServicios = new AlumnosServicios();
    }
    return alumnosServicios;
  }

  public void setAlumnosServicios(AlumnosServicios alumnosServicios) {
    this.alumnosServicios = alumnosServicios;
  }

  public AsignaturasServicios getAsignaturasServicios() {
    return asignaturasServicios;
  }

  public void setAsignaturasServicios(AsignaturasServicios asignaturasServicios) {
    this.asignaturasServicios = asignaturasServicios;
  }

  public NotasServicios getNotasServicio() {
    return notasServicio;
  }

  public void setNotasServicio(NotasServicios notasServicio) {
    this.notasServicio = notasServicio;
  }

}
