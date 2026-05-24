package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class BicicletaController {

    @FXML private TextField txtPlaca, txtNombreConductor, txtIdConductor, txtHoraIngreso, txtHoraSalida, txtMarca, txtValorHora, txtEspacioAsignado;

    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    @FXML
    void onRegistrarClick() {
        try {
            String mensaje = parqueadero.registrarIngresoBicicleta(
                txtPlaca.getText(),
                txtNombreConductor.getText(),
                Integer.parseInt(txtIdConductor.getText()),
                Double.parseDouble(txtHoraIngreso.getText()),
                Double.parseDouble(txtHoraSalida.getText()),
                txtMarca.getText(),
                Double.parseDouble(txtValorHora.getText()),
                txtEspacioAsignado.getText()
            );
            mostrarAlerta("Registro", mensaje, Alert.AlertType.INFORMATION);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Campos numéricos inválidos", Alert.AlertType.ERROR);
        } catch (AssertionError e) {
            mostrarAlerta("Validación", e.getMessage(), Alert.AlertType.WARNING);
        }
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
