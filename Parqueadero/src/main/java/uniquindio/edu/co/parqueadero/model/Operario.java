package uniquindio.edu.co.parqueadero.model;

public class Operario extends Persona {
    private int horasTrabajadas;
    private String usernameO;
    private String passwordO;

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Operario (String nombre, int id, String telefono, String email, int horasTrabajadas, String usernameO, String passwordO )
    {
        super(nombre,id,telefono, email);
        if(horasTrabajadas < 0 || horasTrabajadas > 168 ){
               throw new IllegalArgumentException("Debe ingresar un  dato valido");
        }

        if(usernameO == null || usernameO.isBlank()){
            throw new IllegalArgumentException("Username invalido");
        }

        if(passwordO == null || passwordO.isBlank()){
            throw new IllegalArgumentException("Password invalida");
        }
        boolean tieneMayuscula = false;

        for (int i = 0; i < passwordO.length(); i++) {

            if(Character.isUpperCase(passwordO.charAt(i))) {

                tieneMayuscula = true;
                break;
            }
        }

        if(!tieneMayuscula){
            throw new IllegalArgumentException("La contraseña debe tener mayuscula");
        }
        this.horasTrabajadas = horasTrabajadas;
        this.usernameO = usernameO;
        this.passwordO = passwordO;
    }
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public String getUsernameO() {
        return usernameO;
    }

    public void setUsernameO(String usernameO) {
        this.usernameO = usernameO;
    }

    public String getPasswordO() {
        return passwordO;
    }

    public void setPasswordO(String passwordO) {
        this.passwordO = passwordO;
    }
}