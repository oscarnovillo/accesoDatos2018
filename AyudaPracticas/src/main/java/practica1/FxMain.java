/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import fx.controllers.PantallaInicioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author dam2
 */
public class FxMain extends Application {

    

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource("/fxml/pantallaInicio.fxml"));
        BorderPane root = loaderMenu.load();
        PantallaInicioController inicio = loaderMenu.getController();
        inicio.setMyStage(primaryStage);
        Scene scene = new Scene(root);
        primaryStage.setTitle("IES Quevedo");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
