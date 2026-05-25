package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class CarroController {

    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
        // Aquí podrías inicializar elementos de la UI con datos del parqueadero
    }

    @FXML
    public void initialize() {
        // Lógica de inicialización del controlador
    }

    // Métodos para manejar eventos de la UI, por ejemplo:
    // @FXML
    // void onRegistrarCarroClick() {
    //     // Lógica para registrar un carro
    // }
}
