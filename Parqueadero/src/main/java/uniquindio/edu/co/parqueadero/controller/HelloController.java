package uniquindio.edu.co.parqueadero.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private void onIngresarClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/uniquindio/edu/co/parqueadero/login-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) welcomeText.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login - Parqueadero");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}