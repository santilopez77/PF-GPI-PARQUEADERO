package uniquindio.edu.co.parqueadero.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.HelloApplication;
import uniquindio.edu.co.parqueadero.model.Parqueadero;
import uniquindio.edu.co.parqueadero.model.Reporte;

import java.net.URL;
import java.util.ResourceBundle;

public class OperarioController implements Initializable {

    private static int ID_OPERARIO = -1;

    // INGRESO
    @FXML private TextField txtPlacaIngreso;
    @FXML private TextField txtHoraIngreso;
    @FXML private TextField txtEspacioIngreso;
    @FXML private TextField txtConductorIngreso;
    @FXML private TextField txtIdIngreso;
    @FXML private ComboBox<String> cbTipoVehiculo;

    // SALIDA
    @FXML private TextField txtPlacaSalida;
    @FXML private TextField txtHoraSalida;

    // REPORTE
    @FXML private TextField txtHorasReporte;

    // RESULTADO
    @FXML private TextArea txtResultado;

    private Parqueadero parqueadero = HelloApplication.getParqueadero();

    public static void setIdOperario(int id) {
        ID_OPERARIO = id;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbTipoVehiculo.setItems(FXCollections.observableArrayList("CARRO", "MOTO", "BICICLETA"));
    }

    // --- INGRESO ---

    @FXML
    private void registrarIngresoVehiculo() {
        String placa     = txtPlacaIngreso.getText().trim();
        String horaTexto = txtHoraIngreso.getText().trim();
        String espacio   = txtEspacioIngreso.getText().trim();
        String conductor = txtConductorIngreso.getText().trim();
        String idTexto   = txtIdIngreso.getText().trim();
        String tipo      = cbTipoVehiculo.getValue();

        if (placa.isEmpty() || horaTexto.isEmpty() || espacio.isEmpty()
                || conductor.isEmpty() || idTexto.isEmpty() || tipo == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Completa todos los campos de ingreso.");
            return;
        }

        try {
            double horaIngreso  = Double.parseDouble(horaTexto);
            int idConductor     = Integer.parseInt(idTexto);
            String respuesta;

            switch (tipo) {
                case "CARRO" ->
                        respuesta = parqueadero.registrarIngresoCarro(
                                ID_OPERARIO, placa, conductor, idConductor, horaIngreso, 0, 4, 2000, espacio);
                case "MOTO" ->
                        respuesta = parqueadero.registrarIngresoMoto(
                                ID_OPERARIO, placa, conductor, idConductor, horaIngreso, 0, 150, 1500, espacio);
                case "BICICLETA" ->
                        respuesta = parqueadero.registrarIngresoBicicleta(
                                ID_OPERARIO, placa, conductor, idConductor, horaIngreso, 0, "N/A", 500, espacio);
                default -> respuesta = "Tipo de vehículo no reconocido.";
            }

            txtResultado.appendText(respuesta + "\n");
            limpiarCamposIngreso();

        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Hora e ID deben ser números.");
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Datos inválidos", e.getMessage());
        }
    }

    // --- SALIDA ---

    @FXML
    private void registrarSalidaVehiculo() {
        String placa    = txtPlacaSalida.getText().trim();
        String horaTexto = txtHoraSalida.getText().trim();

        if (placa.isEmpty() || horaTexto.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Ingresa la placa y la hora de salida.");
            return;
        }

        try {
            double horaSalida = Double.parseDouble(horaTexto);
            String respuesta = parqueadero.registrarSalidaVehiculo(ID_OPERARIO, placa, horaSalida);
            txtResultado.appendText(respuesta + "\n");
            limpiarCamposSalida();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "La hora debe ser un número.");
        }
    }

    // --- CONSULTAS ---

    @FXML
    private void consultarVehiculos() {
        String respuesta = parqueadero.consultarTotalVehiculosDentro(ID_OPERARIO);
        txtResultado.setText(respuesta + "\n");
    }

    @FXML
    private void consultarEspacios() {
        String respuesta = parqueadero.consultarEspaciosDisponibles(ID_OPERARIO);
        txtResultado.setText(respuesta + "\n");
    }

    // --- REPORTES ---

    @FXML
    private void generarReporte() {
        String horasTexto = txtHorasReporte.getText().trim();

        if (horasTexto.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campo vacío", "Ingresa el límite de horas.");
            return;
        }

        try {
            double horas = Double.parseDouble(horasTexto);
            Reporte reporte = parqueadero.generarReporte(horas);
            txtResultado.setText(reporte.toString() + "\n");
            txtHorasReporte.clear();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Las horas deben ser un número.");
        }
    }

    @FXML
    private void mostrarRegistros() {
        txtResultado.setText("=== REGISTROS ===\n");
        parqueadero.getListRegistro().forEach(r -> txtResultado.appendText(r.toString() + "\n"));
    }

    // --- UTILIDADES ---

    private void limpiarCamposIngreso() {
        txtPlacaIngreso.clear();
        txtHoraIngreso.clear();
        txtEspacioIngreso.clear();
        txtConductorIngreso.clear();
        txtIdIngreso.clear();
        cbTipoVehiculo.setValue(null);
    }

    private void limpiarCamposSalida() {
        txtPlacaSalida.clear();
        txtHoraSalida.clear();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}