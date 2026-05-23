package uniquindio.edu.co.parqueadero.model;

import uniquindio.edu.co.parqueadero.model.*;

import java.util.List;

public class Vehiculo implements TarifaEspacio {


    // Atributos
    private String placa;
    private String nombreConductor;
    private int idConductor;
    private double horaIngreso;
    private double horaSalida;
    private String espacioAsignado;

    // Relaciones
    private Parqueadero theParqueadero;
    private EstadoVehiculo estadoVehiculo;
    private Espacio theEspacioAsignado;
    private Usuario theUsuario;


    public Vehiculo(String placa, String nombreConductor, int idConductor, double horaIngreso,double horaSalida, String espacioAsignado) {
        this.placa = placa;
        this.nombreConductor = nombreConductor;
        this.idConductor = idConductor;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.espacioAsignado = espacioAsignado;
    }
    public double calcularTarifa (){
        return 0;
    }


    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public double getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(double horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getHoraSalida() {
        return horaIngreso;
    }

    public void setHoraSalida(double horaSalida) {
        this.horaSalida = horaSalida;
    }
    public String getEspacioAsignado (){ return espacioAsignado;}

    public void setEspacioAsignado (String espacioAsignado){this.espacioAsignado = espacioAsignado;}

    public Parqueadero getTheParqueadero() {
        return theParqueadero;
    }

    public void setTheParqueadero(Parqueadero theParqueadero) {
        this.theParqueadero = theParqueadero;
    }

    public EstadoVehiculo getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public Espacio getTheEspacioAsignado() {
        return theEspacioAsignado;
    }

    public void setTheEspacioAsignado(Espacio theEspacioAsignado) {
        this.theEspacioAsignado = theEspacioAsignado;
    }

    public Usuario getTheUsuario() {
        return theUsuario;
    }

    public void setTheUsuario(Usuario theUsuario) {
        this.theUsuario = theUsuario;
    }



    @Override
    public String toString() {
        return "Vehiculo{placa='" + placa + "'}";
    }
}