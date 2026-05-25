package uniquindio.edu.co.parqueadero.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uniquindio.edu.co.parqueadero.model.Parqueadero;
import uniquindio.edu.co.parqueadero.model.TipoUsuario;

public class UsuarioController {

    @FXML
    private TextField txtIdAdmin;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTipoUsuario;

    @FXML
    private TextArea txtAreaResultado;

    private Parqueadero parqueadero;

    @FXML
    public void initialize() {

        parqueadero = new Parqueadero(
                "Central",
                "12345",
                100
        );
    }

    /**
     * Registrar usuario
     */

    @FXML
    void registrarUsuario(ActionEvent event) {

        String respuesta = parqueadero.registrarUsuario(
                txtNombre.getText(),
                Integer.parseInt(txtId.getText()),
                txtTelefono.getText(),
                txtEmail.getText(),
                TipoUsuario.valueOf(txtTipoUsuario.getText().toUpperCase())
        );

        txtAreaResultado.setText(respuesta);
    }

    public void setParqueadero(Parqueadero parqueadero) {
    }
}