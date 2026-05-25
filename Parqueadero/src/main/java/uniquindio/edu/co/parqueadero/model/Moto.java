package uniquindio.edu.co.parqueadero.model;

public class Moto extends Vehiculo {

    private int cilindraje;
    private double valorHora;

    public Moto(String placa, String nombreConductor, int idConductor, double horaIngreso, double horaSalida, int cilindraje, double valorHora, String espacioAsignado) {
        super(placa, nombreConductor, idConductor, horaIngreso, horaSalida, espacioAsignado); // Corregido: pasar horaSalida correctamente
        this.cilindraje = cilindraje;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularTarifa() {
        if (getHoraSalida() < getHoraIngreso()) {
        }
        return valorHora * (getHoraSalida() - getHoraIngreso());
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
