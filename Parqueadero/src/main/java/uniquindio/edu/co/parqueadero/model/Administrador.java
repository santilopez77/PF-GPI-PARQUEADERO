package uniquindio.edu.co.parqueadero.model;

public class Administrador extends Persona {

    // Atributos
    private NivelCargo nivelCargo;
    private String username;
    private String password;

    public Administrador(String nombre, int id, String telefono, String email, NivelCargo nivelCargo, String usernameA, String passwordA) {

        super(nombre, id, telefono, email);

        this.nivelCargo = nivelCargo;
        this.username = usernameA;
        this.password = passwordA;
    }

    public NivelCargo getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(NivelCargo nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public String getUsernameA() {
        return username;
    }

    public void setUsernameA(String username) {
        this.username = username;
    }

    public String getPasswordA() {
        return password;
    }

    public void setPasswordA(String password) {
        this.password = password;
    }
}