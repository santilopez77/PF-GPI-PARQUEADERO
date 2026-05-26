package uniquindio.edu.co.parqueadero.model;

public class Espacio {

    // Atributos
    private int codigo;
    private String vehiculoAsignado;

    // Relaciones
    private Parqueadero theParqueadero;
    private TipoEspacio tipoEspacio;
    private EstadoEspacio estadoEspacio;
    private Vehiculo theVehiculo;

    public Espacio(int codigo, String vehiculoAsignado) {

        if (codigo <= 0) {

            throw new IllegalArgumentException("El codigo debe ser positivo");
        }

        if (vehiculoAsignado == null || vehiculoAsignado.trim().isEmpty()) {

            throw new IllegalArgumentException("El vehiculo asignado no puede estar vacio");
        }

        this.codigo = codigo;
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {

        if (codigo <= 0) {

            throw new IllegalArgumentException("El codigo debe ser positivo");
        }

        this.codigo = codigo;
    }

    public String getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public void setVehiculoAsignado(String vehiculoAsignado) {

        if (vehiculoAsignado == null || vehiculoAsignado.trim().isEmpty()) {

            throw new IllegalArgumentException("El vehiculo asignado no puede estar vacio");
        }

        this.vehiculoAsignado = vehiculoAsignado;
    }

    public TipoEspacio getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(TipoEspacio tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    public EstadoEspacio getEstadoEspacio() {
        return estadoEspacio;
    }

    public void setEstadoEspacio(EstadoEspacio estadoEspacio) {
        this.estadoEspacio = estadoEspacio;
    }

    public Vehiculo getTheVehiculo() {
        return theVehiculo;
    }

    public void setTheVehiculo(Vehiculo theVehiculo) {
        this.theVehiculo = theVehiculo;
    }

    @Override
    public String toString() {
        return "Espacio{codigo=" + codigo + "}";
    }
}