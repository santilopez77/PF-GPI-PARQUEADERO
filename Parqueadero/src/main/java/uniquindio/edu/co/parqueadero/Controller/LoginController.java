package uniquindio.edu.co.parqueadero.Controller;

import javafx.event.ActionEvent;
import uniquindio.edu.co.parqueadero.model.Parqueadero;

public class LoginController {

    public void abrirAdministrador(ActionEvent event){
        System.out.println("Ingreso administrador");
    }

    public void abrirOperario(ActionEvent event){
        System.out.println("Ingreso operario");
    }

    public void abrirInvitado(ActionEvent event){
        System.out.println("Ingreso invitado");
    }

    public void setParqueadero(Parqueadero parqueaderoInstance) {
    }
}