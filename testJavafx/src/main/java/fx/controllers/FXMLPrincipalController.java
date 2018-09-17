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

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private BorderPane fxRoot;

    @FXML
    private MenuBar fxMenu;
    
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    private AnchorPane pantallaWelcome;
    private FXMLPantallaBienvenidaController controllerWelcome;
    private AnchorPane pantallaLogin;
    private FXMLLoginController controllerLogin;

    @FXML
    public void cargarPantallaWelcome() {
        fxMenu.setVisible(true);
        controllerWelcome.setLogin(this.getUsuario());
        fxRoot.setCenter(pantallaWelcome);

    }

    @FXML
    public void cargarPantallaLogin() {
        fxRoot.setCenter(pantallaLogin);

    }
    private void preCargaWelcome() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaBienvenida.fxml"));
            pantallaWelcome = loaderMenu.load();
            controllerWelcome
                    = loaderMenu.getController();

            

        } catch (IOException ex) {

            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void preCargaLogin() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLLogin.fxml"));
            pantallaLogin = loaderMenu.load();
            controllerLogin
                    = loaderMenu.getController();

            controllerLogin.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        preCargaWelcome();
        preCargaLogin();
        fxMenu.setVisible(false);
        cargarPantallaLogin();
    }

}
