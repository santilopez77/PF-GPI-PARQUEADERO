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
        if(nombre == null || nombre.isBlank()){

            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if(id <= 0){

            throw new IllegalArgumentException("El ID debe ser un número positivo");
        }

        if(telefono == null || telefono.length() != 10 || !esNumerico(telefono)){

            throw new IllegalArgumentException("El teléfono debe tener 10 dígitos numéricos");
        }

        if(email == null || !email.contains("@")){

            throw new IllegalArgumentException("El formato del correo electrónico no es válido");
        }
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.email = email;
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
    private static boolean esNumerico(String num ) {
        for (int i = 0; i < num .length(); i++) {
            if (!Character.isDigit(num  .charAt(i))) {
                return false;
            }
        }
        return true;
    }

}