package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class CarroController {
    @FXML private TextField txtPlaca, txtNombreConductor, txtIdConductor, txtHoraIngreso, txtHoraSalida, txtNumPuertas, txtValorHora, txtEspacioAsignado;
    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero parqueadero) { this.parqueadero = parqueadero; }

    @FXML
    void onRegistrarCarro() {
        try {
            String res = parqueadero.registrarIngresoCarro(
                txtPlaca.getText(), txtNombreConductor.getText(),
                Integer.parseInt(txtIdConductor.getText()),
                Double.parseDouble(txtHoraIngreso.getText()),
                Double.parseDouble(txtHoraSalida.getText()),
                Integer.parseInt(txtNumPuertas.getText()),
                Double.parseDouble(txtValorHora.getText()),
                txtEspacioAsignado.getText()
            );
            mostrarAlerta("Éxito", res, Alert.AlertType.INFORMATION);
        } catch (Exception | AssertionError e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String t, String c, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setTitle(t);
        a.setContentText(c);
        a.showAndWait();
    }
}