package uniquindio.edu.co.parqueadero.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private StackPane container;

    @FXML
    private void menuBicicletas() {
        cargarVista("/uniquindio/edu/co/parqueadero/operario-view.fxml");
    }

    @FXML
    private void menuCarros() {
        cargarVista("/uniquindio/edu/co/parqueadero/operario-view.fxml");
    }

    @FXML
    private void menuMotos() {
        cargarVista("/uniquindio/edu/co/parqueadero/operario-view.fxml");
    }

    @FXML
    private void menuOperarios() {
        cargarVista("/uniquindio/edu/co/parqueadero/administrador-view.fxml");
    }

    private void cargarVista(String rutaFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFxml));
            Parent vista = loader.load();
            container.getChildren().setAll(vista);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error al cargar vista: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}