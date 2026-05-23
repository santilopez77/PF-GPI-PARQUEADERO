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