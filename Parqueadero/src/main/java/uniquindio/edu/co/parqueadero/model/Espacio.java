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
        this.codigo = codigo;
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public void setVehiculoAsignado(String vehiculoAsignado) {
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

