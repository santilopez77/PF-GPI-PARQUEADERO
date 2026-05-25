package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.*;

public class OperarioController {

    private Parqueadero parqueadero;


    @FXML
    private TextField txtPlacaIngreso;

    @FXML
    private TextField txtConductorIngreso;

    @FXML
    private TextField txtIdIngreso;

    @FXML
    private ComboBox<String> cbTipoVehiculo;

    @FXML
    private TextField txtHoraIngreso;

    @FXML
    private TextField txtEspacioIngreso;


    @FXML
    private TextField txtPlacaSalida;

    @FXML
    private TextField txtHoraSalida;


    @FXML
    private TextField txtHorasReporte;


    @FXML
    private TextArea txtResultado;

    @FXML
    public void initialize() {

        parqueadero = new Parqueadero("Parqueadero UQ", "12345", 20);

        cbTipoVehiculo.getItems().addAll("Carro", "Moto", "Bicicleta");
    }

    /**
     * Metodo para registrar el ingreso de los vehiculos
     */
    @FXML
    private void registrarIngresoVehiculo() {

        String placa = txtPlacaIngreso.getText();
        String conductor = txtConductorIngreso.getText();

        int identificacion = Integer.parseInt(txtIdIngreso.getText());

        double horaIngreso = Double.parseDouble(txtHoraIngreso.getText());

        String espacio = txtEspacioIngreso.getText();

        String tipo = cbTipoVehiculo.getValue();

        String respuesta = "";

        if (tipo.equals("Carro")) {

            respuesta = parqueadero.registrarIngresoCarro(2, placa, conductor, identificacion, horaIngreso, 0, 4, 2000, espacio);
        }

        if (tipo.equals("Moto")) {

            respuesta = parqueadero.registrarIngresoMoto(2, placa, conductor, identificacion, horaIngreso, 0, 150, 1500, espacio);
        }

        if (tipo.equals("Bicicleta")) {

            respuesta = parqueadero.registrarIngresoBicicleta(2, placa, conductor, identificacion, horaIngreso, 0, "GW", 1000, espacio);
        }

        txtResultado.setText(respuesta);
    }

    /**
     * Metodo para registrar la salida de los vehiculos
     */

    @FXML
    private void registrarSalidaVehiculo() {

        String placa = txtPlacaSalida.getText();

        double horaSalida = Double.parseDouble(txtHoraSalida.getText());

        String respuesta = parqueadero.registrarSalidaVehiculo(2, placa, horaSalida);

        txtResultado.setText(respuesta);
    }

    /**
     * Metodo para consultar los vehiculos
     */
    @FXML
    private void consultarVehiculos() {

        String respuesta = parqueadero.consultarTotalVehiculosDentro(2);

        txtResultado.setText(respuesta);
    }

    /**
     * Metodo para consultar los espacios
     */
    @FXML
    private void consultarEspacios() {

        String respuesta = parqueadero.consultarEspaciosDisponibles(2);

        txtResultado.setText(respuesta);
    }

    @FXML
    private void generarReporte() {

        double horas = Double.parseDouble(txtHorasReporte.getText());

        Reporte reporte = parqueadero.generarReporte(horas);

        txtResultado.setText("Total vehiculos: " + reporte.totalVehiculosIngresados()

                + "Ingresos: " + reporte.ingresosGenerados()

                + "Promedio permanencia: " + reporte.promedioPermanencia()

                + "Vehiculos mayor tiempo: " + reporte.vehiculosMayorTiempo());
    }

    /**
     * Metodo para mostrar el registro del ingresso de los usuarios
     */

    @FXML
    private void mostrarRegistros() {

        String texto = "";

        for (Registro registro : parqueadero.getListRegistro()) {

            texto += "Ingreso: " + registro.getHoraIngreso() + " Salida: " + registro.getHoraSalida() + " Valor: " + registro.getValorRegistro();
        }

        txtResultado.setText(texto);
    }

    public void setParqueadero(Parqueadero parqueadero) {
    }
}