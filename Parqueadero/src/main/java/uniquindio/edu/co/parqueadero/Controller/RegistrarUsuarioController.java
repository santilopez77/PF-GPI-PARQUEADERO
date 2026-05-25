package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class RegistrarUsuarioController {

    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    @FXML
    public void initialize() {
        // Lógica de inicialización
    }

    // @FXML
    // void onGuardarUsuarioClick() {
    //     // Lógica para guardar el usuario
    // }
}
