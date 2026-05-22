package uniquindio.edu.co.parqueadero.model;
import java.util.List;

public class Persona {
    private String nombre;
    private int id;
    private String telefono;
    private String email;



    // Relaciones
    private Parqueadero theParqueadero;
    private TipoUsuario tipoUsuario;
    private List<Vehiculo> listVehiculo;

    public Persona(String nombre, int id, String telefono, String email) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.email = email;
        assert email.contains("@");
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}