package uniquindio.edu.co.parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
// No necesitamos importar LoginController aquí directamente si HelloApplication carga hello-view
// import uniquindio.edu.co.parqueadero.Controller.LoginController;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

import java.io.IOException;

public class HelloApplication extends Application {

    // Hacemos el parqueadero estático para poder acceder a él desde los controladores
    // Esto es una solución rápida, en una aplicación más grande se usaría inyección de dependencias
    private static Parqueadero parqueaderoInstance;

    @Override
    public void start(Stage stage) throws IOException {
        parqueaderoInstance = new Parqueadero("Parqueadero UQ", "123456", 100);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")); // Cargar hello-view.fxml
        Scene scene = new Scene(fxmlLoader.load());
        
        // No necesitamos obtener el controlador aquí, ya que HelloController no necesita el Parqueadero directamente al inicio
        // La lógica para pasar el Parqueadero al LoginController se hará en HelloController

        stage.setTitle("Bienvenido al Parqueadero"); // Título para la pantalla de bienvenida
        stage.setScene(scene);
        stage.show();
    }

    public static Parqueadero getParqueaderoInstance() {
        return parqueaderoInstance;
    }
}
