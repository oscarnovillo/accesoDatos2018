package fx.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLPantallaBienvenidaController implements Initializable {

    @FXML
    private Label fxWelcome;    
    
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
     
        this.login = login;
        fxWelcome.setText("welcome "+login);
        
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxWelcome.setText("welcome "+login);
    }    
    
}
