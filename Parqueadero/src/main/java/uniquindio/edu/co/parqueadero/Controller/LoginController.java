package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uniquindio.edu.co.parqueadero.HelloApplication;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

import java.io.IOException;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    @FXML
    void onLoginClick() throws IOException {
        // Validación simple para el ejemplo
        if ("admin".equals(txtUsuario.getText()) && "1234".equals(txtPassword.getText())) {
            cargarMain();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos");
            alert.showAndWait();
        }
    }

    private void cargarMain() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(loader.load());
        MainController mainController = loader.getController();
        mainController.setParqueadero(parqueadero);

        Stage stage = (Stage) txtUsuario.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}