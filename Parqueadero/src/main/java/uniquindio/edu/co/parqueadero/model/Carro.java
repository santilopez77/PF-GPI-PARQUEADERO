package uniquindio.edu.co.parqueadero.model;

    public class Carro extends Vehiculo{
        private int numeroPuertas;
        private double valorHora;

        public Carro (String placa, String nombreConductor, int idConductor, double horaIngreso,double horaSalida,
                      int numeroPuertas, double valorHora, String espacioAsignado){
            super(placa, nombreConductor, idConductor, horaIngreso,horaSalida,  espacioAsignado);
            this.numeroPuertas = numeroPuertas;
            this.valorHora = valorHora;
        }
        @Override
        public double calcularTarifa() {
            if (getHoraSalida() < getHoraIngreso()) {
            }
            return valorHora * (getHoraSalida() - getHoraIngreso());
        }


        public int getNumeroPuertas() {
            return numeroPuertas;
        }

        public void setNumeroPuertas(int numeroPuertas) {
            this.numeroPuertas = numeroPuertas;
        }

        public double getValorHora(){ return valorHora;}

        public void setValorHora(double valorHora){this.valorHora = valorHora;}

    }
