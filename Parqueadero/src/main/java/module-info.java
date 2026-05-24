module uniquindio.edu.co.parqueadero {
    requires javafx.controls;
    requires javafx.fxml;


    opens uniquindio.edu.co.parqueadero to javafx.fxml;
    opens uniquindio.edu.co.parqueadero.Controller to javafx.fxml;
    exports uniquindio.edu.co.parqueadero;
    exports uniquindio.edu.co.parqueadero.Controller;
}