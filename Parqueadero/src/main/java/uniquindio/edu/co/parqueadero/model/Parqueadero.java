package uniquindio.edu.co.parqueadero.model;
import java.util.List;

public class Parqueadero {

    private String nombre;
    private String nit;
    private int espaciosTotales;

    private List<Vehiculo> listVehiculo;
    private List<Espacio> listEspacio;
    private List<Persona> listPersona;
    private List<Registro> listRegistro;

    public Parqueadero(String nombre, String nit, int espaciosTotales) {
        this.nombre = nombre;
        this.nit = nit;
        this.espaciosTotales = espaciosTotales;
    }

    //----------------------------------------------CRUD OPERARIO-----------------------------------------

    /**
     * Metodo para buscar si un empleado ya existe en el programa
     *
     * @param id del operario
     * @return variable true o false que indique la existencía
     */
    public boolean buscarEmpleado(int id) {
        boolean existe = false;
        for (Persona persona : listPersona) {
            if (persona.getId() == id) {
                existe = true;
                break;

            }
        }
        return existe;
    }

    /**
     * Metodo para buscar si un vehiculo ya existe
     *
     * @param placa del vehiculo
     * @return variable true o false que indique la existencía
     */

    public boolean buscarVehiculo(String placa) {

        boolean existe = false;

        for (Vehiculo vehiculo : listVehiculo) {

            if (vehiculo.getPlaca().equals(placa)) {

                existe = true;
                break;
            }
        }

        return existe;
    }

    /**
     * Metodo para buscar si un espacio existe
     *
     * @param codigo del espacio
     * @return variable true o false que indique la existencía
     */

    public boolean buscarEspacio(int codigo) {

        boolean existe = false;

        for (Espacio espacio : listEspacio) {

            if (espacio.getCodigo() == (codigo)) {

                existe = true;
                break;
            }
        }

        return existe;
    }

    /**
     * Metodo para crear un operario en el programa
     *
     * @param nombre          del operario
     * @param id              del operario
     * @param email           del operario
     * @param horasTrabajadas del operario
     * @return mensaje indicando la operación
     */
    public String crearOperario(String nombre, int id, String telefono, String email, int horasTrabajadas) {
        String respuesta = "";
        if (buscarEmpleado(id)) {
            respuesta = "El operario con id " + id + " ya existe en el sistema.";
        } else {
            Operario nuevoOperario = new Operario(nombre, id, telefono, email, horasTrabajadas);
            listPersona.add(nuevoOperario);
            respuesta = "El operario " + nuevoOperario.getNombre() + " se registró exitosamente.";
        }
        return respuesta;
    }

    /**
     * Metodo para saber si un espacio esta disponible
     *
     * @param estadoEspacio del espacio
     * @return un booleano con el estado en falso o verdadero
     */
    public boolean encontrarEspacioDisponible(EstadoEspacio estadoEspacio) {
        boolean encontrado = false;
        for (Espacio e : listEspacio) {
            if (e.getEstadoEspacio() == EstadoEspacio.DISPONIBLE) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Metodo para consultar cuantos espacios hay disponibles
     *
     * @return mensaje con el total de espacios ocupados
     */

    public String consultarEspaciosDisponibles() {
        int total = listEspacio.size();
        int ocupados = 0;
        int disponibles = 0;

        for (Espacio esp : listEspacio) {
            if (esp.getEstadoEspacio() == EstadoEspacio.OCUPADO) {
                ocupados++;
            }
        }

        disponibles = total - ocupados;
        return "El Total de espacios es: " + total + "Los ocupados son: " + ocupados + "y los espacios disponibles: " + disponibles;
    }


    /**
     * Metodo para registrar el ingreso de las motos al parqueadero
     *
     * @param placa           de la Moto
     * @param nombreConductor de la Moto
     * @param idConductor     de la Moto
     * @param horaIngreso     de la Moto
     * @param horaSalida      de la Moto
     * @param cilindraje      de la Moto
     * @param valorHora       de la Moto
     * @param espacioAsignado de la Moto
     * @return mensaje indicando operación
     */
    public String registrarIngresoMoto(String placa, String nombreConductor, int idConductor, double horaIngreso, double horaSalida,
                                       int cilindraje, double valorHora, String espacioAsignado) {

        String respuesta = "";
        if (encontrarEspacioDisponible(EstadoEspacio.DISPONIBLE)) {
            respuesta = "El vehiculo no puede ingresar ya que el espacio esta ocupado por otro vehiculo";
        } else {

            Moto nuevaMoto = new Moto(placa, nombreConductor, idConductor, horaIngreso, horaSalida, cilindraje, valorHora, espacioAsignado);
            listVehiculo.add(nuevaMoto);
            respuesta = "La moto ha ingresado exitosamente ";
        }
        return respuesta;
    }

    /**
     * Metodo para registrar el ingreso de los Carros al parqueadero
     *
     * @param placa           del Carro
     * @param nombreConductor del Carro
     * @param idConductor     del Carro
     * @param horaIngreso     del Carro
     * @param horaSalida      del Carro
     * @param numeroPuertas   del Carro
     * @param valorHora       del Carro
     * @param espacioAsignado del Carro
     * @return mensaje indicando operación
     */

    public String registrarIngresoCarro(String placa, String nombreConductor, int idConductor, double horaIngreso, double horaSalida
            , int numeroPuertas, double valorHora, String espacioAsignado) {

        String respuesta = "";
        if (buscarVehiculo(placa)) {
            respuesta = "La placa ya existe en el sistema";

        } else {

            Carro nuevoCarro = new Carro(placa, nombreConductor, idConductor, horaIngreso, horaSalida, numeroPuertas, valorHora, espacioAsignado);

            listVehiculo.add(nuevoCarro);

            respuesta = "El carro ingreso exitosamente";
        }

        return respuesta;
    }

    /**
     * Metodo para registrar el ingreso de las Bicicletas al parqueadero
     *
     * @param placa           de la Bicicleta
     * @param nombreConductor de la Bicicleta
     * @param idConductor     de la Bicicleta
     * @param horaIngreso     de la Bicicleta
     * @param horaSalida      de la Bicicleta
     * @param marca           de la Bicicleta
     * @param valorHora       de la Bicicleta
     * @param espacioAsignado de la Bicicleta
     * @return mensaje indicando operación
     */
    public String registrarIngresoBicicleta(String placa, String nombreConductor, int idConductor, double horaIngreso, double horaSalida, String marca,
                                            double valorHora, String espacioAsignado) {

        String respuesta = "";

        if (buscarVehiculo(placa)) {

            respuesta = "La placa ya existe en el sistema";

        } else {

            Bicicleta nuevaBicicleta = new Bicicleta(placa, nombreConductor, idConductor, horaIngreso, horaSalida, marca, valorHora, espacioAsignado);

            listVehiculo.add(nuevaBicicleta);

            respuesta = "La bicicleta ingreso exitosamente";
        }

        return respuesta;
    }

    /**
     * Metodo para registrar salida de vehiculos
     *
     * @param placa del vehiculo
     * @return mensaje indicando operación
     */

    public String registrarSalidaVehiculo(String placa) {

        String respuesta = "";

        if (buscarVehiculo(placa)) {

            for (Vehiculo vehiculo : listVehiculo) {

                if (vehiculo.getPlaca().equals(placa)) {

                    vehiculo.setEstadoVehiculo(EstadoVehiculo.AFUERA);

                    respuesta = "El vehiculo salió exitosamente";
                }
            }

        } else {

            respuesta = "El vehiculo no existe";
        }

        return respuesta;
    }


    /**
     * Metodo para consultar cuantos vehiculos hay dentro del parqueadero
     *
     * @param placa del vehiculo
     * @return mensaje indicando operación
     */

    public String vehiculosDentroParqueadero(String placa) {

        String respuesta = "";
        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo.getPlaca().equals(placa)) {
            }
            if (vehiculo.getEstadoVehiculo() == EstadoVehiculo.ADENTRO) {
                respuesta = "Placa: " + vehiculo.getPlaca() + "Conductor: " + vehiculo.getNombreConductor() + "Hora ingreso: " + vehiculo.getHoraIngreso() + "Espacio asignado " + vehiculo.getEspacioAsignado();

            } else {
                respuesta = "El vehiculo no esta estacionado en ningun espacio";
            }

        }
        return respuesta;
    }

    /**
     * Metodo para consultar todos los vehiculos dentro del parqueadero
     *
     * @return mensaje indicando operación
     */

    public String consultarVehiculosDentro() {

        String respuesta = "";

        for (Vehiculo vehiculo : listVehiculo) {

            if (vehiculo.getEstadoVehiculo() == EstadoVehiculo.ADENTRO) {

                respuesta += "Placa: " + vehiculo.getPlaca() + "Conductor: " + vehiculo.getNombreConductor() + "Hora ingreso: " + vehiculo.getHoraIngreso() + "Espacio asignado: " + vehiculo.getEspacioAsignado();
                break;
            }
        }

        return respuesta;
    }

    /**
     * Metodo para consultar espacios ocupados
     *
     * @return mensaje indicando operación
     */

    public String consultarEspaciosOcupados() {

        String respuesta = "";

        for (Espacio espacio : listEspacio) {

            if (espacio.getEstadoEspacio().equals(EstadoEspacio.OCUPADO)) {

                respuesta = "Codigo: " + espacio.getCodigo() + "Tipo espacio: " + espacio.getTipoEspacio() + "Estado: " + espacio.getEstadoEspacio();
            }
        }

        return respuesta;
    }

    /**
     * Metodo para consultar total vehiculos ingresados
     *Lo borre porque tengo que hacer uno de cada uno, osea uno de carros otro de motos y otro de bicicletas
     * @return total vehiculos
     */


    /**
     * Metodo para obtener los ingresos del carro
     *
     * @return valor de los ingresos del Carro
     */
    public double obtenerValorIngresoCarro() {
        double valorCarro = 0;
        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Carro) {
                Carro carro = (Carro) vehiculo;
                valorCarro = carro.calcularTarifa();
            }

        }
        return valorCarro;
    }

    /**
     * Metodo para obtener los ingresos de la moto
     *
     * @return valor de los ingresos de la moto
     */
    public double obtenerValorIngresoMoto() {
        double valorMoto = 0;
        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                valorMoto = moto.calcularTarifa();
            }

        }
        return valorMoto;
    }

    /**
     * Metodo para obtener los ingresos de la Bicicleta
     *
     * @return valor de los ingresos de la bicicleta
     */
    public double obtenerValorIngresoBicicleta() {
        double valorBici = 0;
        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Bicicleta) {
                Bicicleta bici = (Bicicleta) vehiculo;
                valorBici = bici.calcularTarifa();
            }

        }
        return valorBici;
    }

    /**
     * Metodo para obtener los ingresos Totales generados en el parqueadero
     *
     * @return valor de los ingresos totales del parqueadero
     */
    public double obtenerIngresosTotales() {

        double valorTotal = 0;

        valorTotal = (obtenerValorIngresoBicicleta() + obtenerValorIngresoCarro() + obtenerValorIngresoMoto());
        return valorTotal;
    }


    /**
     * Metodo para obtener el tiempo del carro
     *
     * @return valor con el tiempo del carro en el parqueadero
     */
    public double tiempoCarro() {
        double tiempoCarro = 0;
        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Carro) {
                Carro carro = (Carro) vehiculo;
                tiempoCarro = (carro.getHoraIngreso() - carro.getHoraSalida());
            }

        }
        return tiempoCarro;
    }

    /**
     * Metodo para obtener el tiempo de la moto
     *
     * @return valor con el tiempo de la moto en el parqueadero
     */
    public double tiempoMoto() {
        double tiempoMoto = 0;
        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                tiempoMoto = (moto.getHoraIngreso() - moto.getHoraSalida());
            }

        }
        return tiempoMoto;
    }

    /**
     * Metodo para calcular tiempo de la bicicleta
     *
     * @return valor con el tiempo de la bici en el parqueadero
     */
    public double tiempoBicicleta() {
        double tiempoBici = 0;
        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Bicicleta) {
                Bicicleta bici = (Bicicleta) vehiculo;
                tiempoBici = (bici.getHoraIngreso() - bici.getHoraSalida());
            }

        }
        return tiempoBici;
    }

    /**
     * Metodo para calcular el tiempo promedio de permanencia de los vehiculos en el parqueadero
     */
    public double calcularPromedioPermanencia() {
        double promedio = 0;

        promedio = (tiempoBicicleta() + tiempoMoto() + tiempoCarro());

        return promedio;
    }

    /**
     * Metodo para consultar el total de los vehiculos ingresados en el día
     * me falta la salida
     */


    //----------------------------------------------CRUD ADMINISTRADOR-----------------------------------------

    /**
     * Metodo para crear espacios
     *
     * @param codigo           del espacio
     * @param VehiculoAsignado del espacio
     * @return mensaje indicando operación
     */

    public String crearEspacio(int codigo, String VehiculoAsignado) {

        String respuesta = "";

        if (buscarEspacio(codigo)) {

            respuesta = "El espacio ya existe";

        } else {

            Espacio nuevoEspacio = new Espacio(codigo, VehiculoAsignado);

            listEspacio.add(nuevoEspacio);

            respuesta = "El espacio fue creado exitosamente";
        }

        return respuesta;
    }

    /**
     * Metodo para modificar estado de un espacio
     *
     * @param codigo      del espacio
     * @param nuevoEstado del espacio
     * @return mensaje indicando operación
     */

    public String modificarEstadoEspacio(int codigo, EstadoEspacio nuevoEstado) {

        String respuesta = "";

        if (buscarEspacio(codigo)) {

            for (Espacio espacio : listEspacio) {

                if (espacio.getCodigo() == (codigo)) {

                    espacio.setEstadoEspacio(nuevoEstado);

                    respuesta = "Estado modificado exitosamente";
                }
            }

        } else {

            respuesta = "El espacio no existe";
        }

        return respuesta;
    }

    /**
     * Metodo para deshabilitar espacio
     *
     * @param codigo del espacio
     * @return mensaje indicando operación
     */

    public String deshabilitarEspacio(int codigo) {

        String respuesta = "";

        if (buscarEspacio(codigo)) {

            for (Espacio espacio : listEspacio) {

                if (espacio.getCodigo() == (codigo)) {

                    espacio.setEstadoEspacio(EstadoEspacio.MANTENIMIENTO);

                    respuesta = "Espacio deshabilitado exitosamente";
                }
            }

        } else {

            respuesta = "El espacio no existe";
        }

        return respuesta;
    }

    /**
     * Metodo para habilitar espacio
     *
     * @param codigo del espacio
     * @return mensaje indicando operación
     */

    public String habilitarEspacio(int codigo) {

        String respuesta = "";

        if (buscarEspacio(codigo)) {

            for (Espacio espacio : listEspacio) {

                if (espacio.getCodigo() == (codigo)) {

                    espacio.setEstadoEspacio(EstadoEspacio.DISPONIBLE);

                    respuesta = "Espacio habilitado exitosamente";
                }
            }

        } else {

            respuesta = "El espacio no existe";
        }

        return respuesta;
    }

    /**
     * Metodo para modificar valorHora de carro
     *
     * @return mensaje indicativo de la operación
     */
    public String asignarValorHoraCarro() {
        String respuesta = "";

        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Carro) {
                Carro carro = (Carro) vehiculo;
                carro.setValorHora(2000);
                respuesta = "El valor de la hora para carro es " + carro.getValorHora();
            }
        }
        return respuesta;

    }

    /**
     * Metodo para modificar valorHora de moto
     *
     * @return mensaje indicativo de la operación
     */
    public String asignarValorHoraMoto() {
        String respuesta = "";

        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                moto.setValorHora(1500);
                respuesta = "El valor de la hora para moto es " + moto.getValorHora();
            }
        }
        return respuesta;

    }

    /**
     * Metodo para modificar valorHora de bicicleta
     *
     * @return mensaje indicativo de la operación
     */
    public String asignarValorHoraBici() {
        String respuesta = "";

        for (Vehiculo vehiculo : listVehiculo) {
            if (vehiculo instanceof Bicicleta) {
                Bicicleta bici = (Bicicleta) vehiculo;
                bici.setValorHora(1500);
                respuesta = "El valor de la hora para bici es " + bici.getValorHora();
            }
        }
        return respuesta;

    }

    /**
     * Metodo para gestionar usuarios que tienen acceso frecuente al parqueadero
     * No tengo idea de como hacerlo la verdad
     *
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getEspaciosTotales() {
        return espaciosTotales;
    }

    public void setEspaciosTotales(int espaciosTotales) {
        this.espaciosTotales = espaciosTotales;
    }

    public List<Vehiculo> getListVehiculo() {
        return listVehiculo;
    }

    public void setListVehiculo(List<Vehiculo> listVehiculo) {
        this.listVehiculo = listVehiculo;
    }

    public List<Espacio> getListEspacio() {
        return listEspacio;
    }

    public void setListEspacio(List<Espacio> listEspacio) {
        this.listEspacio = listEspacio;
    }

    public List<Persona> getListEmpleado() {
        return listPersona;
    }

    public void setListEmpleado(List<Persona> listPersona) {
        this.listPersona = listPersona;
    }

    public List<Registro> getListRegistro() {
        return listRegistro;
    }

    public void setListRegistro(List<Registro> listRegistro) {
        this.listRegistro = listRegistro;
    }

    @Override
    public String toString() {
        return "Parqueadero{" + "nombre='" + nombre + "', nit='" + nit + "'}";
    }
}