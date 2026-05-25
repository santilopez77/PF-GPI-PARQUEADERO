package uniquindio.edu.co.parqueadero.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class OperarioController {

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtConductor;

    @FXML
    private TextField txtHoraIngreso;

    @FXML
    private TextField txtHoraSalida;

    @FXML
    private TextField txtHoras;

    @FXML
    private TextArea txtAreaOperario;

    public void ingresarCarro(ActionEvent event){

        txtAreaOperario.setText("Carro ingresado: " + txtPlaca.getText());
    }

    public void ingresarMoto(ActionEvent event){

        txtAreaOperario.setText("Moto ingresada: " + txtPlaca.getText());
    }

    public void ingresarBicicleta(ActionEvent event){

        txtAreaOperario.setText("Bicicleta ingresada: " + txtPlaca.getText());
    }

    public void registrarSalida(ActionEvent event){

        txtAreaOperario.setText("Salida registrada para: " + txtPlaca.getText());
    }

    public void consultarEspacios(ActionEvent event){

        txtAreaOperario.setText("Consultando espacios disponibles...");
    }

    public void consultarVehiculos(ActionEvent event){

        txtAreaOperario.setText("Consultando vehículos dentro...");
    }

    public void consultarOcupados(ActionEvent event){

        txtAreaOperario.setText("Consultando espacios ocupados...");
    }

    public void generarReporte(ActionEvent event){

        txtAreaOperario.setText("Reporte generado con límite: " + txtHoras.getText());
    }

    public void setParqueadero(Parqueadero parqueadero) {
    }
}