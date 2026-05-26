package uniquindio.edu.co.parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.edu.co.parqueadero.model.*;

public class HelloApplication extends Application {

    // Instancia global del parqueadero accesible desde todos los controllers
    private static Parqueadero parqueadero;

    @Override
    public void start(Stage stage) throws Exception {

        // Inicializar parqueadero
        parqueadero = new Parqueadero("Parqueadero UniQuindío", "900123456-1", 50);

        // Crear administrador por defecto para poder iniciar sesión
        Administrador adminDefault = new Administrador(
                "Admin Principal",
                1,
                "3001234567",
                "admin@parqueadero.com",
                NivelCargo.ALTO,
                "admin",
                "Admin123"
        );
        parqueadero.getListEmpleado().add(adminDefault);

        // Cargar vista inicial
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/uniquindio/edu/co/parqueadero/hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Parqueadero");
        stage.setScene(scene);
        stage.show();
    }

    public static Parqueadero getParqueadero() {
        return parqueadero;
    }

    public static void main(String[] args) {
        launch(args);
    }
}