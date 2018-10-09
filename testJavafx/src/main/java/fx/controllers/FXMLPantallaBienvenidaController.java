package fx.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLPantallaBienvenidaController implements Initializable {

    @FXML
    private Label fxWelcome;

    @FXML
    private ListView fxListView;

    @FXML
    private DatePicker fxFecha;

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {

        this.login = login;
        fxWelcome.setText("welcome " + login);

    }

    public void clickBoton() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha = fxFecha.getValue().format(formatter);

        List<String> lineas = new LinkedList<>();

        lineas.add("una linea-fecha-" + fecha);
        lineas.add("otra linea-fecha-" + fecha);

        fxListView.getItems().clear();
        fxListView.getItems().addAll(lineas);

    }

    public void clickSelectedListView() {
        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        String fila = 
                (String)fxListView.getSelectionModel().getSelectedItem();
        alert.setContentText(fila);

        alert.showAndWait();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxWelcome.setText("welcome " + login);
    }

}
