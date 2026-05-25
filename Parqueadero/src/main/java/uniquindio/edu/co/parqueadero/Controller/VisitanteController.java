package uniquindio.edu.co.parqueadero.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class VisitanteController {

    @FXML
    private TextArea txtAreaInvitado;

    public void verEspacios(ActionEvent event){

        txtAreaInvitado.setText("Espacios disponibles: 10");
    }

    public void verTarifas(ActionEvent event){

        txtAreaInvitado.setText("Carro: 2000 | Moto: 1500 | Bicicleta: 1000");
    }
}