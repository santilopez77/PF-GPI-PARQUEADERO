package uniquindio.edu.co.parqueadero.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import uniquindio.edu.co.parqueadero.HelloApplication;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

import java.io.IOException;
import java.util.Collections;

public class MainController {

    @FXML
    private StackPane container;

    private Parqueadero parqueadero;

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    @FXML
    void menuBicicletas() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("bicicleta-view.fxml"));
            container.getChildren().setAll(Collections.singleton(loader.load()));
            BicicletaController bicicletaController = loader.getController();
            if (bicicletaController != null) {
                bicicletaController.setParqueadero(parqueadero);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar el error, por ejemplo, mostrando una alerta
        }
    }

    @FXML
    void menuCarros() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("carro-view.fxml"));
            container.getChildren().setAll(Collections.singleton(loader.load()));
            CarroController carroController = loader.getController();
            if (carroController != null) {
                carroController.setParqueadero(parqueadero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menuMotos() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("moto-view.fxml"));
            container.getChildren().setAll(Collections.singleton(loader.load()));
            MotoController motoController = loader.getController();
            if (motoController != null) {
                motoController.setParqueadero(parqueadero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menuOperarios() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("operario-view.fxml"));
            container.getChildren().setAll(Collections.singleton(loader.load()));
            OperarioController operarioController = loader.getController();
            if (operarioController != null) {
                operarioController.setParqueadero(parqueadero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menuAdministradores() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("administrador-view.fxml"));
            container.getChildren().setAll(Collections.singleton(loader.load()));
            AdministradorController administradorController = loader.getController();
            if (administradorController != null) {
                administradorController.setParqueadero(parqueadero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menuUsuarios() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("usuario-view.fxml"));
            container.getChildren().setAll(Collections.singleton(loader.load()));
            UsuarioController usuarioController = loader.getController();
            if (usuarioController != null) {
                usuarioController.setParqueadero(parqueadero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
