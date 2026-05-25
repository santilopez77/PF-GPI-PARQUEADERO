package uniquindio.edu.co.parqueadero.model;

    public class Bicicleta extends Vehiculo{
        private String marca;
        private double valorHora;

        public Bicicleta (String placa, String nombreConductor, int idConductor, double horaIngreso,double horaSalida,
                          String marca,double valorHora,String espacioAsignado){
            super(placa, nombreConductor, idConductor, horaIngreso,horaSalida, espacioAsignado);
            this.marca = marca;
            this.valorHora = valorHora;
        }
        @Override
        public double calcularTarifa() {
            if (getHoraSalida() < getHoraIngreso()) {
            }
            return valorHora * (getHoraSalida() - getHoraIngreso());
        }

        public String getMarca (){return marca;}
        public void setMarca (String marca){this.marca  = marca;}

        public double getValorHora() {return valorHora;}
        public void setValorHora(double valorHora){this.valorHora = valorHora;}
    }

