package uniquindio.edu.co.parqueadero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniquindio.edu.co.parqueadero.model.*;

public class ParqueaderoTest {

    private Parqueadero parqueadero;
    private Administrador admin;
    private Operario operario;

    @BeforeEach
    public void setUp() {

        parqueadero = new Parqueadero("Central", "12345", 10);

        admin = new Administrador("Juan", 1, "3120000000", "juan@gmail.com", NivelCargo.ALTO, "admin", "123");

        operario = new Operario("santiago", 2, "3130000000", "santiago@gmail.com", 8, "operario", "123");

        parqueadero.getListEmpleado().add(admin);
        parqueadero.getListEmpleado().add(operario);

        Espacio espacio = new Espacio(1, "Carro");

        parqueadero.getListEspacio().add(espacio);
    }

    @Test
    public void iniciarSesionAdministradorTest() {

        String resultado = parqueadero.iniciarSesionAdministrador("admin", "123");

        Assertions.assertEquals("Inicio de sesión exitoso como administrador", resultado);
    }

    @Test
    public void iniciarSesionOperarioTest() {

        String resultado = parqueadero.iniciarSesionOperario("operario", "123");

        Assertions.assertEquals("Inicio de sesión exitoso como operario", resultado);
    }

    @Test
    public void esAdministradorTest() {

        boolean resultado = parqueadero.esAdministrador(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void esOperarioTest() {

        boolean resultado = parqueadero.esOperario(2);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void buscarEmpleadoTest() {

        boolean resultado = parqueadero.buscarEmpleado(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void buscarVehiculoTest() {

        Moto moto = new Moto("ABC123", "Juan", 123, 8.0, 10.0, 150, 2000, "A1");

        parqueadero.getListVehiculo().add(moto);

        boolean resultado = parqueadero.buscarVehiculo("ABC123");

        Assertions.assertTrue(resultado);
    }

    @Test
    public void buscarEspacioTest() {

        boolean resultado = parqueadero.buscarEspacio(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void encontrarEspacioDisponibleTest() {

        boolean resultado = parqueadero.encontrarEspacioDisponible(EstadoEspacio.DISPONIBLE);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void registrarIngresoMotoTest() {

        String resultado = parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        Assertions.assertEquals("La moto ha ingresado exitosamente", resultado);
    }

    @Test
    public void registrarIngresoCarroTest() {

        String resultado = parqueadero.registrarIngresoCarro(2, "CAR123", "Carlos", 456, 8.0, 0.0, 4, 3000, "C1");

        Assertions.assertEquals("El carro ingreso exitosamente", resultado);
    }

    @Test
    public void registrarIngresoBicicletaTest() {

        String resultado = parqueadero.registrarIngresoBicicleta(2, "BICI1", "Ana", 789, 8.0, 0.0, "GW", 1000, "B1");

        Assertions.assertEquals("La bicicleta ingreso exitosamente", resultado);
    }

    @Test
    public void registrarSalidaVehiculoTest() {

        parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        String resultado = parqueadero.registrarSalidaVehiculo(2, "ABC123", 10.0);

        Assertions.assertTrue(resultado.contains("Vehiculo retirado exitosamente"));
    }

    @Test
    public void consultarEspaciosDisponiblesTest() {

        String resultado = parqueadero.consultarEspaciosDisponibles(2);

        Assertions.assertTrue(resultado.contains("espacios"));
    }

    @Test
    public void consultarVehiculoDentroParqueaderoTest() {

        parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        String resultado = parqueadero.consultarVehiculoDentroParqueadero(2, "ABC123");

        Assertions.assertTrue(resultado.contains("ABC123"));
    }

    @Test
    public void consultarTotalVehiculosDentroTest() {

        parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        String resultado = parqueadero.consultarTotalVehiculosDentro(2);

        Assertions.assertTrue(resultado.contains("1"));
    }

    @Test
    public void consultarEspaciosOcupadosTest() {

        parqueadero.modificarEstadoEspacio(1, 1, EstadoEspacio.OCUPADO);

        String resultado = parqueadero.consultarEspaciosOcupados(2);

        Assertions.assertTrue(resultado.contains("OCUPADO"));
    }

    @Test
    public void totalCarrosIngresadosTest() {

        parqueadero.registrarIngresoCarro(2, "CAR123", "Carlos", 456, 8.0, 0.0, 4, 3000, "C1");

        int resultado = parqueadero.totalCarrosIngresados();

        Assertions.assertEquals(1, resultado);
    }

    @Test
    public void totalMotosIngresadasTest() {

        parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        int resultado = parqueadero.totalMotosIngresadas();

        Assertions.assertEquals(1, resultado);
    }

    @Test
    public void totalBicicletasIngresadasTest() {

        parqueadero.registrarIngresoBicicleta(2, "BICI1", "Ana", 789, 8.0, 0.0, "GW", 1000, "B1");

        int resultado = parqueadero.totalBicicletasIngresadas();

        Assertions.assertEquals(1, resultado);
    }

    @Test
    public void obtenerIngresosTotalesTest() {

        parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        parqueadero.registrarSalidaVehiculo(2, "ABC123", 10.0);

        double resultado = parqueadero.obtenerIngresosTotales();

        Assertions.assertEquals(4000, resultado);
    }

    @Test
    public void calcularPromedioPermanenciaTest() {

        parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        parqueadero.registrarSalidaVehiculo(2, "ABC123", 10.0);

        double resultado = parqueadero.calcularPromedioPermanencia();

        Assertions.assertEquals(2.0, resultado);
    }

    @Test
    public void vehiculosMayorTiempoTest() {

        parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        parqueadero.registrarSalidaVehiculo(2, "ABC123", 12.0);

        String resultado = parqueadero.vehiculosMayorTiempo(2);

        Assertions.assertTrue(resultado.contains("ABC123"));
    }

    @Test
    public void generarReporteTest() {

        Reporte reporte = parqueadero.generarReporte(2);

        Assertions.assertNotNull(reporte);
    }

    @Test
    public void generarRegistroTest() {

        int tamanio = parqueadero.getListRegistro().size();

        Registro registro = parqueadero.generarRegistro(8.0, 10.0, 3000);

        Assertions.assertEquals(tamanio + 1, parqueadero.getListRegistro().size());

        Assertions.assertEquals(8.0, registro.getHoraIngreso());

        Assertions.assertEquals(10.0, registro.getHoraSalida());

        Assertions.assertEquals(3000, registro.getValorRegistro());
    }

    @Test
    public void crearAdministradorTest() {

        String resultado = parqueadero.crearAdministrador(1, "Nuevo", 10, "312", "nuevo@gmail.com", NivelCargo.MEDIO, "nuevo", "123");

        Assertions.assertEquals("Administrador creado exitosamente", resultado);
    }

    @Test
    public void crearOperarioTest() {

        String resultado = parqueadero.crearOperario(1, "Pedro", 20, "313", "pedro@gmail.com", 8, "pedro", "123");

        Assertions.assertEquals("Operario creado exitosamente", resultado);
    }

    @Test
    public void crearEspacioTest() {

        String resultado = parqueadero.crearEspacio(1, 20, "Moto");

        Assertions.assertEquals("El espacio fue creado exitosamente", resultado);
    }

    @Test
    public void modificarEstadoEspacioTest() {

        String resultado = parqueadero.modificarEstadoEspacio(1, 1, EstadoEspacio.OCUPADO);

        Assertions.assertEquals("Estado modificado exitosamente", resultado);
    }

    @Test
    public void deshabilitarEspacioTest() {

        String resultado = parqueadero.deshabilitarEspacio(1, 1);

        Assertions.assertEquals("Espacio deshabilitado exitosamente", resultado);
    }

    @Test
    public void habilitarEspacioTest() {

        parqueadero.deshabilitarEspacio(1, 1);

        String resultado = parqueadero.habilitarEspacio(1, 1);

        Assertions.assertEquals("Espacio habilitado exitosamente", resultado);
    }

    @Test
    public void asignarValorHoraCarroTest() {

        parqueadero.registrarIngresoCarro(2, "CAR123", "Carlos", 456, 8.0, 0.0, 4, 3000, "C1");

        String resultado = parqueadero.asignarValorHoraCarro(1);

        Assertions.assertTrue(resultado.contains("2000"));
    }

    @Test
    public void asignarValorHoraMotoTest() {

        parqueadero.registrarIngresoMoto(2, "ABC123", "Juan", 123, 8.0, 0.0, 150, 2000, "A1");

        String resultado = parqueadero.asignarValorHoraMoto(1);

        Assertions.assertTrue(resultado.contains("1500"));
    }

    @Test
    public void asignarValorHoraBiciTest() {

        parqueadero.registrarIngresoBicicleta(2, "BICI1", "Ana", 789, 8.0, 0.0, "GW", 1000, "B1");

        String resultado = parqueadero.asignarValorHoraBici(1);

        Assertions.assertTrue(resultado.contains("1500"));
    }

    @Test
    public void registrarUsuarioTest() {

        String resultado = parqueadero.registrarUsuario(1, "Luis", 30, "311", "luis@gmail.com", TipoUsuario.ESTUDIANTE);

        Assertions.assertEquals("El usuario fue registrado exitosamente", resultado);
    }
}