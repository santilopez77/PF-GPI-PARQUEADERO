package uniquindio.edu.co.parqueadero.model;

public class Moto extends Vehiculo{

    private int cilindraje;
    private double valorHora;

    public Moto (String placa, String nombreConductor, int idConductor, double horaIngreso,double horaSalida, int cilindraje, double valorHora,String espacioAsignado){
        super(placa, nombreConductor, idConductor, horaIngreso,valorHora, espacioAsignado);
        this.cilindraje = cilindraje;
        this.valorHora = valorHora;
    }
    @Override
    public double calcularTarifa() {
        double valorTarifa = 0;
        return valorTarifa = valorHora * (getHoraIngreso()-getHoraSalida());
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getValorHora(){return valorHora;}
    public void setValorHora(double valorHora){this.valorHora = valorHora;}
}
