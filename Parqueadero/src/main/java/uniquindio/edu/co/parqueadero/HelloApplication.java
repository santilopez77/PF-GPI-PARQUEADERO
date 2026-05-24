package uniquindio.edu.co.parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.edu.co.parqueadero.Controller.LoginController;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parqueadero parqueadero = new Parqueadero("Parqueadero UQ", "123456", 100);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        LoginController loginController = fxmlLoader.getController();
        loginController.setParqueadero(parqueadero);

        stage.setTitle("Sistema de Parqueadero - Login");
        stage.setScene(scene);
        stage.show();
    }
}
