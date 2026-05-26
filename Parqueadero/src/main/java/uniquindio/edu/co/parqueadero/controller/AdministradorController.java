package uniquindio.edu.co.parqueadero.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import uniquindio.edu.co.parqueadero.HelloApplication;
import uniquindio.edu.co.parqueadero.model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministradorController implements Initializable {

    private static final int ID_ADMIN = 1;

    // ESPACIOS
    @FXML private TextField txtCodigoEspacio;
    @FXML private ComboBox<String> cbTipoEspacio;
    @FXML private ComboBox<String> cbEstadoEspacio;

    // TARIFAS
    @FXML private TextField txtTarifaCarro;
    @FXML private TextField txtTarifaMoto;
    @FXML private TextField txtTarifaBici;

    // USUARIOS
    @FXML private TextField txtNombreUsuario;
    @FXML private TextField txtIdUsuario;
    @FXML private TextField txtTelefonoUsuario;
    @FXML private TextField txtEmailUsuario;
    @FXML private ComboBox<String> cbTipoUsuario;

    // OPERARIO
    @FXML private TextField txtNombreOperario;
    @FXML private TextField txtIdOperario;
    @FXML private TextField txtTelefonoOperario;
    @FXML private TextField txtEmailOperario;
    @FXML private TextField txtHorasOperario;
    @FXML private TextField txtUsernameOperario;
    @FXML private PasswordField txtPasswordOperario;

    private Parqueadero parqueadero = HelloApplication.getParqueadero();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbTipoEspacio.setItems(FXCollections.observableArrayList("CARRO", "MOTO", "BICICLETA"));
        cbEstadoEspacio.setItems(FXCollections.observableArrayList("DISPONIBLE", "OCUPADO", "MANTENIMIENTO"));
        cbTipoUsuario.setItems(FXCollections.observableArrayList("ESTUDIANTE", "DOCENTE", "VISITANTE","ADMINISTRATIVO"));
    }

    // --- ESPACIOS ---

    @FXML
    private void modificarEstadoEspacio() {
        String codigoTexto = txtCodigoEspacio.getText().trim();
        String estadoTexto = cbEstadoEspacio.getValue();

        if (codigoTexto.isEmpty() || estadoTexto == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Ingresa el código y selecciona el estado.");
            return;
        }

        try {
            int codigo = Integer.parseInt(codigoTexto);
            EstadoEspacio estado = EstadoEspacio.valueOf(estadoTexto);
            String respuesta = parqueadero.modificarEstadoEspacio(ID_ADMIN, codigo, estado);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", respuesta);
            limpiarCamposEspacio();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "El código debe ser un número entero.");
        }
    }

    @FXML
    private void deshabilitarEspacio() {
        String codigoTexto = txtCodigoEspacio.getText().trim();

        if (codigoTexto.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campo vacío", "Ingresa el código del espacio.");
            return;
        }

        try {
            int codigo = Integer.parseInt(codigoTexto);
            String respuesta = parqueadero.deshabilitarEspacio(ID_ADMIN, codigo);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", respuesta);
            limpiarCamposEspacio();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "El código debe ser un número entero.");
        }
    }

    @FXML
    private void habilitarEspacio() {
        String codigoTexto = txtCodigoEspacio.getText().trim();

        if (codigoTexto.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campo vacío", "Ingresa el código del espacio.");
            return;
        }

        try {
            int codigo = Integer.parseInt(codigoTexto);
            String respuesta = parqueadero.habilitarEspacio(ID_ADMIN, codigo);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", respuesta);
            limpiarCamposEspacio();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "El código debe ser un número entero.");
        }
    }

    @FXML
    private void crearEspacio() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/uniquindio/edu/co/parqueadero/crear-espacio-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Crear Espacio");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir la ventana: " + e.getMessage());
        }
    }

    // --- TARIFAS ---

    @FXML
    private void asignarTarifaCarro() {
        String respuesta = parqueadero.asignarValorHoraCarro(ID_ADMIN);
        mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", "la tarifa ha sido asignada "+respuesta);
        txtTarifaCarro.clear();
    }

    @FXML
    private void asignarTarifaMoto() {
        String respuesta = parqueadero.asignarValorHoraMoto(ID_ADMIN);
        mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", "la tarifa ha sido asignada "+respuesta);
        txtTarifaMoto.clear();
    }

    @FXML
    private void asignarTarifaBici() {
        String respuesta = parqueadero.asignarValorHoraBici(ID_ADMIN);
        mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado","la tarifa ha sido asignada "+respuesta);
        txtTarifaBici.clear();
    }

    // --- USUARIOS ---

    @FXML
    private void registrarUsuario() {
        String nombre   = txtNombreUsuario.getText().trim();
        String idTexto  = txtIdUsuario.getText().trim();
        String telefono = txtTelefonoUsuario.getText().trim();
        String email    = txtEmailUsuario.getText().trim();
        String tipoTexto = cbTipoUsuario.getValue();

        if (nombre.isEmpty() || idTexto.isEmpty() || telefono.isEmpty() || email.isEmpty() || tipoTexto == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Completa todos los campos del usuario.");
            return;
        }

        try {
            int id = Integer.parseInt(idTexto);
            TipoUsuario tipo = TipoUsuario.valueOf(tipoTexto);
            String respuesta = parqueadero.registrarUsuario(ID_ADMIN, nombre, id, telefono, email, tipo);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", respuesta);
            limpiarCamposUsuario();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "El ID debe ser un número entero.");
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Datos inválidos", e.getMessage());
        }
    }

    // --- OPERARIO ---

    @FXML
    private void crearOperario() {
        String nombre    = txtNombreOperario.getText().trim();
        String idTexto   = txtIdOperario.getText().trim();
        String telefono  = txtTelefonoOperario.getText().trim();
        String email     = txtEmailOperario.getText().trim();
        String horasTexto = txtHorasOperario.getText().trim();
        String username  = txtUsernameOperario.getText().trim();
        String password  = txtPasswordOperario.getText().trim();

        if (nombre.isEmpty() || idTexto.isEmpty() || telefono.isEmpty() || email.isEmpty()
                || horasTexto.isEmpty() || username.isEmpty() || password.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Completa todos los campos del operario.");
            return;
        }

        try {
            int id    = Integer.parseInt(idTexto);
            int horas = Integer.parseInt(horasTexto);
            String respuesta = parqueadero.crearOperario(ID_ADMIN, nombre, id, telefono, email, horas, username, password);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", respuesta);
            limpiarCamposOperario();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "ID y horas deben ser números enteros.");
        } catch (IllegalArgumentException e) {
            // Aquí se capturan las excepciones de Persona/Operario (contraseña sin mayúscula, teléfono, etc.)
            mostrarAlerta(Alert.AlertType.ERROR, "Datos inválidos", e.getMessage());
        }
    }

    // --- UTILIDADES ---

    private void limpiarCamposEspacio() {
        txtCodigoEspacio.clear();
        cbTipoEspacio.setValue(null);
        cbEstadoEspacio.setValue(null);
    }

    private void limpiarCamposUsuario() {
        txtNombreUsuario.clear();
        txtIdUsuario.clear();
        txtTelefonoUsuario.clear();
        txtEmailUsuario.clear();
        cbTipoUsuario.setValue(null);
    }

    private void limpiarCamposOperario() {
        txtNombreOperario.clear();
        txtIdOperario.clear();
        txtTelefonoOperario.clear();
        txtEmailOperario.clear();
        txtHorasOperario.clear();
        txtUsernameOperario.clear();
        txtPasswordOperario.clear();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}