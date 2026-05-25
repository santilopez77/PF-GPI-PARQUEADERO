package uniquindio.edu.co.parqueadero.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uniquindio.edu.co.parqueadero.HelloApplication;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

import java.net.URL;
import java.util.ResourceBundle;

public class CrearEspacioController implements Initializable {

    private static final int ID_ADMIN = 1;

    @FXML private TextField txtCodigo;
    @FXML private ComboBox<String> cbTipo;
    @FXML private ComboBox<String> cbEstado;
    @FXML private TextField txtVehiculo;

    private Parqueadero parqueadero = HelloApplication.getParqueadero();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbTipo.setItems(FXCollections.observableArrayList("CARRO", "MOTO", "BICICLETA"));
        cbEstado.setItems(FXCollections.observableArrayList("DISPONIBLE", "OCUPADO", "MANTENIMIENTO"));
    }

    @FXML
    private void crearEspacio() {
        String codigoTexto = txtCodigo.getText().trim();
        String vehiculo    = txtVehiculo.getText().trim();

        if (codigoTexto.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campo vacío", "El código del espacio es obligatorio.");
            return;
        }

        try {
            int codigo = Integer.parseInt(codigoTexto);
            String respuesta = parqueadero.crearEspacio(ID_ADMIN, codigo, vehiculo);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", respuesta);

            if (respuesta.equals("El espacio fue creado exitosamente")) {
                Stage stage = (Stage) txtCodigo.getScene().getWindow();
                stage.close();
            }
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "El código debe ser un número entero.");
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