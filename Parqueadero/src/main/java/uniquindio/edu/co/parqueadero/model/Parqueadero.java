package uniquindio.edu.co.parqueadero.model;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

    private String nombre;
    private String nit;
    private int espaciosTotales;

    private List<Vehiculo> listVehiculo;
    private List<Espacio> listEspacio;
    private List<Persona> listPersona;
    private List<Registro> listRegistro;
    private List<Reporte> listReporte;

    public Parqueadero(String nombre, String nit, int espaciosTotales) {
        this.nombre = nombre;
        this.nit = nit;
        this.espaciosTotales = espaciosTotales;
        this.listVehiculo = new ArrayList<>();
        this.listEspacio = new ArrayList<>();
        this.listPersona = new ArrayList<>();
        this.listRegistro = new ArrayList<>();
        this.listReporte = new ArrayList<>();
    }
    //----------------------------------------------CRUD PARQUEADERO--------------------------------------

    /**
     * Metodo para iniciar sesión en el sistema de parte del administrador
     *
     * @param usernameA del administrador
     * @param passwordA del administrador
     * @return mensaje indicando operación
     */

    public String iniciarSesionAdministrador(String usernameA, String passwordA) {

        for (Persona persona : listPersona) {

            if (persona instanceof Administrador administrador) {

                if (administrador.getUsernameA().equals(usernameA) && administrador.getPasswordA().equals(passwordA)) {

                    return "Inicio de sesión exitoso como administrador";
                }
            }
        }

        return "El usuario o la contraseña es incorrecto";
    }

    /**
     * Metodo para iniciar sesión en el sistema de parte del operario
     *
     * @param usernameO del operario
     * @param passwordO del operario
     * @return mensaje indicando operación
     */

    public String iniciarSesionOperario(String usernameO, String passwordO) {

        for (Persona persona : listPersona) {

            if (persona instanceof Operario operario) {

                if (operario.getUsernameO().equals(usernameO) && operario.getPasswordO().equals(passwordO)) {

                    return "Inicio de sesión exitoso como operario";
                }
            }
        }

        return "El usuario o la contraseña es incorrecto";
    }

    /**
     * Metodo para verificar si una persona es administrador
     *
     * @param id de la persona
     * @return true o false dependiendo si es administrador
     */

    public boolean esAdministrador(int id) {

        boolean esAdmin = false;

        for (Persona persona : listPersona) {

            if (persona instanceof Administrador) {
                if (persona.getId() == id) {
                    esAdmin = true;
                    break;
                }
            }
        }
        return esAdmin;
    }

    /**
     * Metodo para verificar si una persona es operario
     *
     * @param id de la persona
     * @return true o false dependiendo si es operario
     */

    public boolean esOperario(int id) {

        boolean esOperario = false;

        for (Persona persona : listPersona) {

            if (persona instanceof Operario) {
                if (persona.getId() == id) {

                    esOperario = true;
                    break;
                }
            }
        }
        return esOperario;
    }

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

            if (espacio.getCodigo() == codigo) {

                existe = true;
                break;
            }
        }

        return existe;
    }

    /**
     * Metodo para saber si un espacio esta disponible
     *
     * @return un booleano con el estado en falso o verdadero
     */

    public boolean encontrarEspacioDisponible(EstadoEspacio estadoEspacio) {

        boolean encontrado = false;

        for (Espacio espacio : listEspacio) {

            if (espacio.getEstadoEspacio() == EstadoEspacio.DISPONIBLE) {

                encontrado = true;
                break;
            }
        }

        return encontrado;
    }

    //----------------------------------------------CRUD OPERARIO-----------------------------------------


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

    public String registrarIngresoMoto(int id, String placa, String nombreConductor, int idConductor, double horaIngreso, double horaSalida, int cilindraje, double valorHora, String espacioAsignado) {

        String respuesta = "";
        if (esOperario(id)) {


            if (encontrarEspacioDisponible(EstadoEspacio.OCUPADO)) {

                respuesta = "El espacio esta ocupado";

            } else {

                Moto nuevaMoto = new Moto(placa, nombreConductor, idConductor, horaIngreso, horaSalida, cilindraje, valorHora, espacioAsignado);

                nuevaMoto.setEstadoVehiculo(EstadoVehiculo.ADENTRO);

                listVehiculo.add(nuevaMoto);

                respuesta = "La moto ha ingresado exitosamente";
            }
        } else {

            respuesta = "No tiene permisos de operario";
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

    public String registrarIngresoCarro(int id, String placa, String nombreConductor, int idConductor, double horaIngreso, double horaSalida, int numeroPuertas, double valorHora, String espacioAsignado) {

        String respuesta = "";
        if (esOperario(id)) {

            if (encontrarEspacioDisponible(EstadoEspacio.OCUPADO)) {

                respuesta = "El espacio esta ocupado";

            } else {

                Carro nuevoCarro = new Carro(placa, nombreConductor, idConductor, horaIngreso, horaSalida, numeroPuertas, valorHora, espacioAsignado);

                nuevoCarro.setEstadoVehiculo(EstadoVehiculo.ADENTRO);

                listVehiculo.add(nuevoCarro);

                respuesta = "El carro ingreso exitosamente";
            }
        } else {

            respuesta = "No tiene permisos de operario";
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

    public String registrarIngresoBicicleta(int id, String placa, String nombreConductor, int idConductor, double horaIngreso, double horaSalida, String marca, double valorHora, String espacioAsignado) {

        String respuesta = "";
        if (esOperario(id)) {
            if (encontrarEspacioDisponible(EstadoEspacio.OCUPADO)) {

                respuesta = "El espacio esta ocupado";

            } else {

                Bicicleta nuevaBicicleta = new Bicicleta(placa, nombreConductor, idConductor, horaIngreso, horaSalida, marca, valorHora, espacioAsignado);

                nuevaBicicleta.setEstadoVehiculo(EstadoVehiculo.ADENTRO);

                listVehiculo.add(nuevaBicicleta);

                respuesta = "La bicicleta ingreso exitosamente";
            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para registrar salida de vehiculos
     *
     * @param placa del vehiculo
     * @return mensaje indicando operación
     */

    public String registrarSalidaVehiculo(int id, String placa, double horaSalida) {

        String respuesta = "";
        if (esOperario(id)) {

            if (buscarVehiculo(placa)) {

                for (Vehiculo vehiculo : listVehiculo) {

                    if (vehiculo.getPlaca().equals(placa) && vehiculo.getEstadoVehiculo() == EstadoVehiculo.ADENTRO) {

                        vehiculo.setHoraSalida(horaSalida);

                        double tiempoTotal = vehiculo.getHoraSalida() - vehiculo.getHoraIngreso();

                        double valorPagar = vehiculo.calcularTarifa();

                        generarRegistro(vehiculo.getHoraIngreso(), vehiculo.getHoraSalida(), valorPagar);

                        vehiculo.setEstadoVehiculo(EstadoVehiculo.AFUERA);

                        respuesta = "Vehiculo retirado exitosamente" + " Tiempo total: " + tiempoTotal + " Valor a pagar: " + valorPagar;

                        break;
                    }
                }

            } else {
                respuesta = "El vehiculo no existe";

            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para consultar cuantos espacios hay disponibles
     *
     * @return mensaje con el total de espacios ocupados
     */

    public String consultarEspaciosDisponibles(int id) {
        String respuesta = "";
        if (esOperario(id)) {

            int total = listEspacio.size();
            int ocupados = 0;
            int disponibles = 0;

            for (Espacio espacio : listEspacio) {

                if (espacio.getEstadoEspacio() == EstadoEspacio.OCUPADO) {

                    ocupados++;
                }
            }

            disponibles += total - ocupados;
            respuesta = "El Total de espacios es: " + total + " Los ocupados son: " + ocupados + " y los espacios disponibles: " + disponibles;
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para consultar un vehiculo dentro del parqueadero
     *
     * @param placa del vehiculo
     * @return mensaje indicando operación
     */

    public String consultarVehiculoDentroParqueadero(int idOperario, String placa) {

        String respuesta = "";

        if (esOperario(idOperario)) {

            boolean encontrado = false;

            for (Vehiculo vehiculo : listVehiculo) {

                if (vehiculo.getPlaca().equals(placa) && vehiculo.getEstadoVehiculo() == EstadoVehiculo.ADENTRO) {

                    respuesta = "Placa: " + vehiculo.getPlaca() + " Conductor: " + vehiculo.getNombreConductor() + " Hora ingreso: " + vehiculo.getHoraIngreso() + " Espacio asignado: " + vehiculo.getEspacioAsignado();

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {

                respuesta = "El vehiculo no esta estacionado";
            }

        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para consultar todos los vehiculos dentro del parqueadero
     *
     * @return mensaje indicando operación
     */

    public String consultarTotalVehiculosDentro(int idOperario) {

        String respuesta = "";
        int total = 0;

        if (esOperario(idOperario)) {

            for (Vehiculo vehiculo : listVehiculo) {

                if (vehiculo.getEstadoVehiculo() == EstadoVehiculo.ADENTRO) {

                    total++;
                }
            }

            respuesta = "Total vehiculos dentro del parqueadero: " + total;

        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para consultar espacios ocupados
     *
     * @return mensaje indicando operación
     */

    public String consultarEspaciosOcupados(int id) {

        String respuesta = "";
        if (esOperario(id)) {
            for (Espacio espacio : listEspacio) {

                if (espacio.getEstadoEspacio() == EstadoEspacio.OCUPADO) {

                    respuesta = "Codigo: " + espacio.getCodigo() + " Tipo espacio: " + espacio.getTipoEspacio() + " Estado: " + espacio.getEstadoEspacio();
                }
            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }
    //----------------------------------------------CRUD REPORTE-----------------------------------------

    /**
     * Metodo para consultar total de carros ingresados
     *
     * @return total de carros
     */

    public int totalCarrosIngresados() {

        int total = 0;

        for (Vehiculo vehiculo : listVehiculo) {

            if (vehiculo instanceof Carro) {

                total++;
            }
        }

        return total;
    }

    /**
     * Metodo para consultar total de motos ingresadas
     *
     * @return total de motos
     */

    public int totalMotosIngresadas() {

        int total = 0;

        for (Vehiculo vehiculo : listVehiculo) {

            if (vehiculo instanceof Moto) {

                total++;
            }
        }

        return total;
    }

    /**
     * Metodo para consultar total de bicicletas ingresadas
     *
     * @return total de bicicletas
     */

    public int totalBicicletasIngresadas() {

        int total = 0;

        for (Vehiculo vehiculo : listVehiculo) {

            if (vehiculo instanceof Bicicleta) {

                total++;
            }
        }

        return total;
    }

    /**
     * Metodo para obtener los ingresos del carro
     *
     * @return valor de los ingresos del Carro
     */

    public double obtenerValorIngresoCarro() {

        double valorCarro = 0;

        for (Vehiculo vehiculo : listVehiculo) {

            if (vehiculo instanceof Carro carro) {

                valorCarro += carro.calcularTarifa();
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

            if (vehiculo instanceof Moto moto) {

                valorMoto += moto.calcularTarifa();
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

            if (vehiculo instanceof Bicicleta bici) {

                valorBici += bici.calcularTarifa();
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

        valorTotal += obtenerValorIngresoBicicleta() + obtenerValorIngresoCarro() + obtenerValorIngresoMoto();

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

            if (vehiculo instanceof Carro carro) {

                tiempoCarro += (carro.getHoraSalida() - carro.getHoraIngreso());
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

            if (vehiculo instanceof Moto moto) {

                tiempoMoto += (moto.getHoraSalida() - moto.getHoraIngreso());
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

            if (vehiculo instanceof Bicicleta bici) {

                tiempoBici += (bici.getHoraSalida() - bici.getHoraIngreso());
            }
        }

        return tiempoBici;
    }

    /**
     * Metodo para calcular el tiempo promedio de permanencia de los vehiculos en el parqueadero
     *
     * @return promedio de permanencia
     */

    public double calcularPromedioPermanencia() {

        double promedio = 0;

        int totalVehiculos = listVehiculo.size();

        if (totalVehiculos > 0) {

            promedio = (tiempoBicicleta() + tiempoMoto() + tiempoCarro()) / totalVehiculos;
        }

        return promedio;
    }

    /**
     * Metodo para consultar vehiculos que permanecieron mas de cierto tiempo
     *
     * @param horas del vehiculo
     * @return mensaje indicando operación
     */

    public String vehiculosMayorTiempo(double horas) {

        String respuesta = "";

        for (Vehiculo vehiculo : listVehiculo) {

            double tiempo = vehiculo.getHoraSalida() - vehiculo.getHoraIngreso();

            if (tiempo > horas) {

                respuesta += "Placa: " + vehiculo.getPlaca() + " Tiempo: " + tiempo;
            }
        }

        return respuesta;
    }

    /**
     * Metodo para generar reporte del parqueadero
     *
     * @param horas limite de tiempo
     * @return mensaje indicando operación
     */

    public Reporte generarReporte(double horas) {

        int totalVehiculos = totalCarrosIngresados() + totalMotosIngresadas() + totalBicicletasIngresadas();

        double ingresos = obtenerIngresosTotales();

        double promedio = calcularPromedioPermanencia();

        String vehiculosTiempo = vehiculosMayorTiempo(horas);

        return new Reporte(totalVehiculos, ingresos, promedio, vehiculosTiempo);
    }


    /**
     * Metodo para generar registro
     *
     * @param horaIngreso   del registro
     * @param horaSalida    del registro
     * @param valorRegistro del registro
     * @return registro generado
     */

    public Registro generarRegistro(double horaIngreso, double horaSalida, double valorRegistro) {

        Registro nuevoRegistro = new Registro(horaIngreso, horaSalida, valorRegistro);

        listRegistro.add(nuevoRegistro);

        return nuevoRegistro;
    }

    //----------------------------------------------CRUD ADMINISTRADOR-----------------------------------------

    /**
     * Metodo para crear administrador
     *
     * @param idA    del administrador
     * @param nombre     del administrador
     * @param id         del administrador
     * @param telefono   del administrador
     * @param email      del administrador
     * @param nivelCargo del administrador
     * @return mensaje indicando operación
     */

    public String crearAdministrador(int idA, String nombre, int id, String telefono, String email, NivelCargo nivelCargo, String usernameA, String passwordA) {

        String respuesta = "";

        if (esAdministrador(idA)) {

            if (buscarEmpleado(id)) {

                respuesta = "El administrador ya existe";

            } else {

                Administrador nuevoAdministrador = new Administrador(nombre, id, telefono, email, nivelCargo, usernameA, passwordA);

                listPersona.add(nuevoAdministrador);

                respuesta = "Administrador creado exitosamente";
            }

        } else {

            respuesta = "No tiene permisos de administrador";
        }

        return respuesta;
    }

    /**
     * Metodo para crear un operario en el programa
     *
     * @param nombre          del operario
     * @param idAdmin         del Administrador
     * @param id              del operario
     * @param telefono        del operario
     * @param email           del operario
     * @param horasTrabajadas del operario
     * @return mensaje indicando la operación
     */

    public String crearOperario(int idAdmin, String nombre, int id, String telefono, String email, int horasTrabajadas, String usernameO, String passwordO) {

        String respuesta = "";

        if (esAdministrador(idAdmin)) {

            if (buscarEmpleado(id)) {

                respuesta = "El operario ya existe";

            } else {

                Operario nuevoOperario = new Operario(nombre, id, telefono, email, horasTrabajadas, usernameO, passwordO);

                listPersona.add(nuevoOperario);

                respuesta = "Operario creado exitosamente";
            }

        } else {

            respuesta = "No tiene permisos de administrador";
        }

        return respuesta;
    }

    /**
     * Metodo para crear espacios
     *
     * @param codigo           del espacio
     * @param VehiculoAsignado del espacio
     * @return mensaje indicando operación
     */

    public String crearEspacio(int id, int codigo, String VehiculoAsignado) {

        String respuesta = "";
        if (esAdministrador(id)) {

            if (buscarEspacio(codigo)) {

                respuesta = "El espacio ya existe";

            } else {

                Espacio nuevoEspacio = new Espacio(codigo, VehiculoAsignado);

                listEspacio.add(nuevoEspacio);

                respuesta = "El espacio fue creado exitosamente";
            }
        } else {

            respuesta = "No tiene permisos de operario";
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

    public String modificarEstadoEspacio(int id, int codigo, EstadoEspacio nuevoEstado) {

        String respuesta = "";

        if (esAdministrador(id)) {
            if (buscarEspacio(codigo)) {

                for (Espacio espacio : listEspacio) {

                    if (espacio.getCodigo() == codigo) {

                        espacio.setEstadoEspacio(nuevoEstado);

                        respuesta = "Estado modificado exitosamente";
                        break;
                    }
                }

            } else {

                respuesta = "El espacio no existe";
            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para deshabilitar espacio
     *
     * @param codigo del espacio
     * @return mensaje indicando operación
     */

    public String deshabilitarEspacio(int id, int codigo) {

        String respuesta = "";
        if (esAdministrador(id)) {

            if (buscarEspacio(codigo)) {

                for (Espacio espacio : listEspacio) {

                    if (espacio.getCodigo() == codigo) {

                        espacio.setEstadoEspacio(EstadoEspacio.MANTENIMIENTO);

                        respuesta = "Espacio deshabilitado exitosamente";
                        break;
                    }
                }

            } else {

                respuesta = "El espacio no existe";
            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para habilitar espacio
     *
     * @param codigo del espacio
     * @return mensaje indicando operación
     */

    public String habilitarEspacio(int idAdmin, int codigo) {

        String respuesta = "";

        if (esAdministrador(idAdmin)) {

            if (buscarEspacio(codigo)) {

                for (Espacio espacio : listEspacio) {

                    if (espacio.getCodigo() == codigo) {

                        espacio.setEstadoEspacio(EstadoEspacio.DISPONIBLE);

                        respuesta = "Espacio habilitado exitosamente";
                        break;
                    }
                }

            } else {

                respuesta = "El espacio no existe";
            }

        } else {

            respuesta = "No tiene permisos de administrador";
        }

        return respuesta;
    }

    /**
     * Metodo para modificar valorHora de carro
     *
     * @param id del administrador
     * @return mensaje indicativo de la operación
     */

    public String asignarValorHoraCarro(int id) {

        String respuesta = "";
        if (esAdministrador(id)) {

            for (Vehiculo vehiculo : listVehiculo) {

                if (vehiculo instanceof Carro carro) {

                    carro.setValorHora(2000);

                    respuesta = "El valor de la hora para carro es " + carro.getValorHora();
                }
            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para modificar valorHora de moto
     *
     * @param id del administrador
     * @return mensaje indicativo de la operación
     */

    public String asignarValorHoraMoto(int id) {

        String respuesta = "";
        if (esAdministrador(id)) {

            for (Vehiculo vehiculo : listVehiculo) {

                if (vehiculo instanceof Moto moto) {

                    moto.setValorHora(1500);

                    respuesta = "El valor de la hora para moto es " + moto.getValorHora();
                }
            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para modificar valorHora de bicicleta
     *
     * @param id del administrador
     * @return mensaje indicativo de la operación
     */

    public String asignarValorHoraBici(int id) {

        String respuesta = "";
        if (esAdministrador(id)) {

            for (Vehiculo vehiculo : listVehiculo) {

                if (vehiculo instanceof Bicicleta bici) {

                    bici.setValorHora(1500);

                    respuesta = "El valor de la hora para bici es " + bici.getValorHora();
                }
            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }

    /**
     * Metodo para registrar usuarios autorizados
     *
     * @param nombre      del usuario
     * @param id          del usuario
     * @param telefono    del usuario
     * @param email       del usuario
     * @param tipoUsuario del usuario
     * @return mensaje indicando operación
     */

    public String registrarUsuario(int idA, String nombre, int id, String telefono, String email, TipoUsuario tipoUsuario) {

        String respuesta = "";
        if (esAdministrador(idA)) {

            if (buscarEmpleado(id)) {

                respuesta = "El usuario ya existe";

            } else {

                Usuario nuevoUsuario = new Usuario(nombre, id, telefono, email, tipoUsuario);

                listPersona.add(nuevoUsuario);

                respuesta = "El usuario fue registrado exitosamente";
            }
        } else {

            respuesta = "No tiene permisos de operario";
        }

        return respuesta;
    }


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

    public List<Reporte> getListReporte() {
        return listReporte;
    }

    public void setListReporte(List<Reporte> listReporte) {
        this.listReporte = listReporte;
    }

    @Override
    public String toString() {
        return "Parqueadero{" + "nombre='" + nombre + '\'' + ", nit='" + nit + '\'' + '}';
    }
}