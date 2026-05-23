package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class EspacioController {
    @FXML private TextField txtCodigo, txtVehiculo;
    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero p) { this.parqueadero = p; }

    @FXML
    void onCrearEspacio() {
        try {
            String res = parqueadero.crearEspacio(
                Integer.parseInt(txtCodigo.getText()), 
                txtVehiculo.getText()
            );
            new Alert(Alert.AlertType.INFORMATION, res).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Datos inválidos").showAndWait();
        }
    }

    @FXML
    void onHabilitarEspacio() {
        parqueadero.habilitarEspacio(Integer.parseInt(txtCodigo.getText()));
    }
}