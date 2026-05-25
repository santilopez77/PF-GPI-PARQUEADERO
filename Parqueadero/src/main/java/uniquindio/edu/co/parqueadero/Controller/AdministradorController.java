package uniquindio.edu.co.parqueadero.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class AdministradorController {

    @FXML
    private TextField txtNombreOperario;

    @FXML
    private TextField txtIdOperario;

    @FXML
    private TextField txtCodigoEspacio;

    @FXML
    private TextField txtTarifaCarro;

    @FXML
    private TextField txtTarifaMoto;

    @FXML
    private TextField txtTarifaBici;

    @FXML
    private TextArea txtAreaAdmin;

    public void crearOperario(ActionEvent event){

        String nombre = txtNombreOperario.getText();
        String id = txtIdOperario.getText();

        txtAreaAdmin.setText("Operario creado: " + nombre + " ID: " + id);
    }

    public void crearEspacio(ActionEvent event){

        String codigo = txtCodigoEspacio.getText();

        txtAreaAdmin.setText("Espacio creado con código: " + codigo);
    }

    public void guardarTarifaCarro(ActionEvent event){

        txtAreaAdmin.setText("Tarifa carro: " + txtTarifaCarro.getText());
    }

    public void guardarTarifaMoto(ActionEvent event){

        txtAreaAdmin.setText("Tarifa moto: " + txtTarifaMoto.getText());
    }

    public void guardarTarifaBici(ActionEvent event){

        txtAreaAdmin.setText("Tarifa bicicleta: " + txtTarifaBici.getText());
    }

    public void setParqueadero(Parqueadero parqueadero) {
    }
}