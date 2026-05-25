package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import uniquindio.edu.co.parqueadero.model.*;

public class AdministradorController {

    private Parqueadero parqueadero;

    private int idAdmin = 1;

    @FXML
    private TextField txtCodigoEspacio;

    @FXML
    private ComboBox<String> cbTipoEspacio;

    @FXML
    private ComboBox<EstadoEspacio> cbEstadoEspacio;

    @FXML
    private TextField txtTarifaCarro;

    @FXML
    private TextField txtTarifaMoto;

    @FXML
    private TextField txtTarifaBici;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private TextField txtTelefonoUsuario;

    @FXML
    private TextField txtEmailUsuario;

    @FXML
    private ComboBox<TipoUsuario> cbTipoUsuario;

    @FXML
    private TextField txtNombreOperario;

    @FXML
    private TextField txtIdOperario;

    @FXML
    private TextField txtTelefonoOperario;

    @FXML
    private TextField txtEmailOperario;

    @FXML
    private TextField txtHorasOperario;

    @FXML
    private TextField txtUsernameOperario;

    @FXML
    private PasswordField txtPasswordOperario;

    /**
     * Secciones del combo box que usamos para que se despliegue la ventana de opciones en el administrador
     */
    @FXML
    public void initialize() {

        cbTipoEspacio.getItems().addAll(
                "Carro",
                "Moto",
                "Bicicleta"
        );

        cbEstadoEspacio.getItems().addAll(
                EstadoEspacio.DISPONIBLE,
                EstadoEspacio.OCUPADO,
                EstadoEspacio.MANTENIMIENTO
        );

        cbTipoUsuario.getItems().addAll(
                TipoUsuario.ESTUDIANTE,
                TipoUsuario.DOCENTE,
                TipoUsuario.ADMINISTRATIVO
        );
    }

    /**
     * Metodo para crear espacio
     */

    @FXML
    public void crearEspacio() {

        int codigo = Integer.parseInt(txtCodigoEspacio.getText());

        String tipo = cbTipoEspacio.getValue();

        String mensaje = parqueadero.crearEspacio(
                idAdmin,
                codigo,
                tipo
        );

        mostrarMensaje(mensaje);
    }

    /**
     * Esto y los otros metodos que le siguen abajo es para modificar el estado del espacio
     */

    @FXML
    public void modificarEstadoEspacio() {

        int codigo = Integer.parseInt(txtCodigoEspacio.getText());

        EstadoEspacio estado = cbEstadoEspacio.getValue();

        String mensaje = parqueadero.modificarEstadoEspacio(
                idAdmin,
                codigo,
                estado
        );

        mostrarMensaje(mensaje);
    }


    @FXML
    public void deshabilitarEspacio() {

        int codigo = Integer.parseInt(txtCodigoEspacio.getText());

        String mensaje = parqueadero.deshabilitarEspacio(
                idAdmin,
                codigo
        );

        mostrarMensaje(mensaje);
    }



    @FXML
    public void habilitarEspacio() {

        int codigo = Integer.parseInt(txtCodigoEspacio.getText());

        String mensaje = parqueadero.habilitarEspacio(
                idAdmin,
                codigo
        );

        mostrarMensaje(mensaje);
    }

    /**
     * Estos son los metodos para asignarle la tarifa a los vehiculos
     */

    @FXML
    public void asignarTarifaCarro() {

        String mensaje = parqueadero.asignarValorHoraCarro(idAdmin);

        mostrarMensaje(mensaje);
    }

    @FXML
    public void asignarTarifaMoto() {

        String mensaje = parqueadero.asignarValorHoraMoto(idAdmin);

        mostrarMensaje(mensaje);
    }

    @FXML
    public void asignarTarifaBici() {

        String mensaje = parqueadero.asignarValorHoraBici(idAdmin);

        mostrarMensaje(mensaje);
    }

    /**
     * Este es para la sección registrar usuarios
     */

    @FXML
    public void registrarUsuario() {

        String nombre = txtNombreUsuario.getText();

        int id = Integer.parseInt(txtIdUsuario.getText());

        String telefono = txtTelefonoUsuario.getText();

        String email = txtEmailUsuario.getText();

        TipoUsuario tipo = cbTipoUsuario.getValue();

        String mensaje = parqueadero.registrarUsuario(
                idAdmin,
                nombre,
                id,
                telefono,
                email,
                tipo
        );

        mostrarMensaje(mensaje);
    }

    /**
     * Este para la sección crearOperario
     */
    @FXML
    public void crearOperario() {

        String nombre = txtNombreOperario.getText();

        int id = Integer.parseInt(txtIdOperario.getText());

        String telefono = txtTelefonoOperario.getText();

        String email = txtEmailOperario.getText();

        int horas = Integer.parseInt(txtHorasOperario.getText());

        String username = txtUsernameOperario.getText();

        String password = txtPasswordOperario.getText();

        String mensaje = parqueadero.crearOperario(
                idAdmin,
                nombre,
                id,
                telefono,
                email,
                horas,
                username,
                password
        );

        mostrarMensaje(mensaje);
    }

    public void mostrarMensaje(String mensaje) {

    }

    public void setParqueadero(Parqueadero parqueadero) {
    }
}