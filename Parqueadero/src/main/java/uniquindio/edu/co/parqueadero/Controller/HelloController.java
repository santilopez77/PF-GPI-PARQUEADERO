package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import uniquindio.edu.co.parqueadero.HelloApplication; // Para acceder a la instancia del Parqueadero
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onIngresarClick(ActionEvent event) throws IOException { // Cambiado el nombre del método y añadido ActionEvent
        // Obtener la Stage actual
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cargar el login-view.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Obtener el controlador del login y pasarle la instancia del Parqueadero
        LoginController loginController = fxmlLoader.getController();
        loginController.setParqueadero(HelloApplication.getParqueaderoInstance());

        // Configurar y mostrar la nueva escena
        stage.setTitle("Sistema de Parqueadero - Login");
        stage.setScene(scene);
        stage.centerOnScreen(); // Centrar la ventana
        stage.show();
    }

    @FXML
    public void initialize() {
        // Puedes inicializar cosas aquí si es necesario para la pantalla de bienvenida
        // Por ejemplo, welcomeText.setText("Bienvenido!");
    }
}
