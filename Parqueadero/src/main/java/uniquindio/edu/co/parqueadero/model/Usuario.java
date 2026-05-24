package uniquindio.edu.co.parqueadero.model;
import java.util.List;
public class Usuario extends Persona {


    // Atributos
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre, int Id, String telefono, String email, TipoUsuario tipoUsuario) {
        super(nombre,Id,telefono, email);
        this.tipoUsuario = tipoUsuario;
    }


    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}