module uniquindio.edu.co.parqueadero {
    requires javafx.controls;
    requires javafx.fxml;

    // Esto permite que JavaFX cargue tus vistas y controladores
    opens uniquindio.edu.co.parqueadero to javafx.fxml;
    opens uniquindio.edu.co.parqueadero.controller to javafx.fxml;
    
    exports uniquindio.edu.co.parqueadero;
}