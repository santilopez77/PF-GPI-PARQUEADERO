package uniquindio.edu.co.parqueadero.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class BicicletaController {

    @FXML
    private TextField txtPlaca, txtNombre, txtId, txtHoraIn, txtMarca, txtValor, txtEspacio;
    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }
}
