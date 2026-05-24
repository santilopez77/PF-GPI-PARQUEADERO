package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class OperarioController {
    @FXML private TextField txtNombre, txtId, txtTelefono, txtEmail, txtHoras;
    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero p) { this.parqueadero = p; }

    @FXML
    void onCrearOperario() {
        try {
            String res = parqueadero.crearOperario(
                txtNombre.getText(), 
                Integer.parseInt(txtId.getText()), 
                txtTelefono.getText(), 
                txtEmail.getText(), 
                Integer.parseInt(txtHoras.getText())
            );
            new Alert(Alert.AlertType.INFORMATION, res).showAndWait();
        } catch (Exception | AssertionError e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }
}