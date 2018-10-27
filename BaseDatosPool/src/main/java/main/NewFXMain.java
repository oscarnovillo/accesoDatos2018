/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constantes.Constantes;
import controllers.FXMLPrincipalController;
import tablas.TablasDao;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author daw
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        //TablasDao tablas = new TablasDao();
        //tablas.crearModeloJDBC();
//        Parent root = FXMLLoader.load(getClass().getResource(Constantes.PANTALLA_PRINCIPAL));
        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource(Constantes.PANTALLA_PRINCIPAL));
        BorderPane root = loaderMenu.load();
        FXMLPrincipalController menuController = loaderMenu.getController();

        Scene scene = new Scene(root);
//        scene.getStylesheets().add("css/fxmlScene.css");
        primaryStage.setTitle("IES Enrique Tierno García");
        primaryStage.setScene(scene);
        primaryStage.show();
        //para no poder maximizar pantalla y
        primaryStage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
