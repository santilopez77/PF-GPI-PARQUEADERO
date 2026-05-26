package uniquindio.edu.co.parqueadero.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uniquindio.edu.co.parqueadero.HelloApplication;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;

    private Parqueadero parqueadero = HelloApplication.getParqueadero();

    @FXML
    private void abrirInvitado() {

        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Ingresa usuario y contraseña.");
            return;
        }

        String respuestaAdmin = parqueadero.iniciarSesionAdministrador(usuario, password);
        String respuestaOperario = parqueadero.iniciarSesionOperario(usuario, password);

        if (respuestaAdmin.equals("Inicio de sesión exitoso como administrador")) {
            abrirVista("/uniquindio/edu/co/parqueadero/administrador-view.fxml", "Administrador");

        } else if (respuestaOperario.equals("Inicio de sesión exitoso como operario")) {
            abrirVista("/uniquindio/edu/co/parqueadero/main-view.fxml", "Operario - Panel");

        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Acceso denegado", "Usuario o contraseña incorrectos.");
        }
    }

    private void abrirVista(String rutaFxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFxml));
            Parent root = loader.load();
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(titulo);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir la vista: " + e.getMessage());
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}