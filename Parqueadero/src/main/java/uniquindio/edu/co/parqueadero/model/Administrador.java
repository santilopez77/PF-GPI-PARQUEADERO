package uniquindio.edu.co.parqueadero.model;


public class Administrador extends Persona{

        private NivelCargo nivelCargo ;

        public Administrador (String nombre, int id,String telefono,String email, NivelCargo nivelCargo ){

            super(nombre,id,telefono, email);
            this.nivelCargo = nivelCargo;

        }

        public NivelCargo getNivelCargo() {
            return nivelCargo;
        }

        public void setNivelCargo(NivelCargo nivelCargo) {
            this.nivelCargo = nivelCargo;
        }

    }

