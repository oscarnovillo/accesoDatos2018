/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PantallaInicioController implements Initializable {

    @FXML
    private BorderPane fxRoot;

    @FXML
    private MenuBar fxMenu;

  public void setMyStage(Stage myStage) {
    this.myStage = myStage;
  }

  private Stage myStage;
  

    @FXML
    public void cargarPantallaLogin() {
        fxRoot.setMinWidth(500);
        fxRoot.setMinHeight(500);
    }

    @FXML
    public void cargarPantallaGet() {
        fxRoot.setMinWidth(1000);
        fxRoot.setMinHeight(1000);
        myStage.sizeToScene();

    }

    @FXML
    public void cargarPantallaAdd() {
        fxRoot.setMinWidth(500);
        fxRoot.setMinHeight(500);
        myStage.sizeToScene();
        
    }

    @FXML
    public void cargarPantallaDelete() {
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
        fxMenu.setVisible(true);
       
        cargarPantallaLogin();
    }

}
