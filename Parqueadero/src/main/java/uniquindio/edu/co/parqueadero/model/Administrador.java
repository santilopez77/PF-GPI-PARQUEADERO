package uniquindio.edu.co.parqueadero.model;

public class Administrador extends Persona {

    // Atributos
    private NivelCargo nivelCargo;
    private String usernameA;
    private String passwordA;

    public Administrador(String nombre,
                         int id,
                         String telefono,
                         String email,
                         NivelCargo nivelCargo,
                         String usernameA,
                         String passwordA) {

        super(nombre, id, telefono, email);

        if(nivelCargo == null){
            throw new IllegalArgumentException("Nivel cargo invalido");
        }

        if(usernameA == null || usernameA.isBlank()){
            throw new IllegalArgumentException("Username invalido");
        }

        if(passwordA == null || passwordA.isBlank()){
            throw new IllegalArgumentException("Password invalida");
        }
        boolean tieneMayuscula = false;

        for (int i = 0; i < passwordA.length(); i++) {

            if(Character.isUpperCase(passwordA.charAt(i))) {

                tieneMayuscula = true;
                break;
            }
        }

        if(!tieneMayuscula){
            throw new IllegalArgumentException("La contraseña debe tener mayuscula");
        }

        this.nivelCargo = nivelCargo;
        this.usernameA = usernameA;
        this.passwordA = passwordA;
    }

    public NivelCargo getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(NivelCargo nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public String getUsernameA() {
        return usernameA;
    }

    public void setUsernameA(String username) {
        this.usernameA = usernameA;
    }

    public String getPasswordA() {
        return passwordA;
    }

    public void setPasswordA(String password) {
        this.passwordA = passwordA;
    }
}