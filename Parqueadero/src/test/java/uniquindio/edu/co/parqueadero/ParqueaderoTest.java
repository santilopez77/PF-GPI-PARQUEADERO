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

        admin = new Administrador("Juan", 1, "3148092683", "juan@gmail.com",
                NivelCargo.ALTO, "admin", "A123");

        operario = new Operario("santiago", 2, "3137846872", "santiago@gmail.com",
                8, "operario", "O123");

        parqueadero.getListEmpleado().add(admin);
        parqueadero.getListEmpleado().add(operario);

        Espacio espacio = new Espacio(1, "Carro");
        espacio.setEstadoEspacio(EstadoEspacio.DISPONIBLE); // 🔥 CLAVE PARA QUE FUNCIONE

        parqueadero.getListEspacio().add(espacio);
    }

    @Test
    public void iniciarSesionAdministradorTest() {
        String resultado = parqueadero.iniciarSesionAdministrador("admin", "A123");
        Assertions.assertEquals("Inicio de sesión exitoso como administrador", resultado);
    }

    @Test
    public void iniciarSesionOperarioTest() {
        String resultado = parqueadero.iniciarSesionOperario("operario", "O123");
        Assertions.assertEquals("Inicio de sesión exitoso como operario", resultado);
    }

    @Test
    public void esAdministradorTest() {
        Assertions.assertTrue(parqueadero.esAdministrador(1));
    }

    @Test
    public void esOperarioTest() {
        Assertions.assertTrue(parqueadero.esOperario(2));
    }

    @Test
    public void buscarEmpleadoTest() {
        Assertions.assertTrue(parqueadero.buscarEmpleado(1));
    }

    @Test
    public void buscarVehiculoTest() {
        Moto moto = new Moto("ABC123", "Juan", 123, 8.0, 10.0, 150, 2000, "1");
        parqueadero.getListVehiculo().add(moto);

        Assertions.assertTrue(parqueadero.buscarVehiculo("ABC123"));
    }

    @Test
    public void buscarEspacioTest() {
        Assertions.assertTrue(parqueadero.buscarEspacio(1));
    }

    @Test
    public void encontrarEspacioDisponibleTest() {
        // 🔥 ahora sí coincide con tu lógica (codigo como String)
        Assertions.assertTrue(parqueadero.encontrarEspacioDisponible("1"));
    }

    @Test
    public void registrarIngresoMotoTest() {
        String resultado = parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

        Assertions.assertEquals("La moto ha ingresado exitosamente", resultado);
    }

    @Test
    public void registrarIngresoCarroTest() {
        String resultado = parqueadero.registrarIngresoCarro(
                2, "CAR123", "Carlos", 456,
                8.0, 0.0, 4, 3000, "1"
        );

        Assertions.assertEquals("El carro ingreso exitosamente", resultado);
    }

    @Test
    public void registrarIngresoBicicletaTest() {
        String resultado = parqueadero.registrarIngresoBicicleta(
                2, "BICI1", "Ana", 789,
                8.0, 0.0, "GW", 1000, "1"
        );

        Assertions.assertEquals("La bicicleta ingreso exitosamente", resultado);
    }

    @Test
    public void registrarSalidaVehiculoTest() {

        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

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

        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

        String resultado = parqueadero.consultarVehiculoDentroParqueadero(2, "ABC123");

        Assertions.assertTrue(resultado.contains("ABC123"));
    }

    @Test
    public void consultarTotalVehiculosDentroTest() {

        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

        String resultado = parqueadero.consultarTotalVehiculosDentro(2);

        Assertions.assertTrue(resultado.contains("1"));
    }

    @Test
    public void consultarEspaciosOcupadosTest() {

        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

        String resultado = parqueadero.consultarEspaciosOcupados(2);

        Assertions.assertTrue(resultado.contains("OCUPADO"));
    }

    @Test
    public void totalCarrosIngresadosTest() {
        parqueadero.registrarIngresoCarro(
                2, "CAR123", "Carlos", 456,
                8.0, 0.0, 4, 3000, "1"
        );

        Assertions.assertEquals(1, parqueadero.totalCarrosIngresados());
    }

    @Test
    public void totalMotosIngresadasTest() {
        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

        Assertions.assertEquals(1, parqueadero.totalMotosIngresadas());
    }

    @Test
    public void totalBicicletasIngresadasTest() {
        parqueadero.registrarIngresoBicicleta(
                2, "BICI1", "Ana", 789,
                8.0, 0.0, "GW", 1000, "1"
        );

        Assertions.assertEquals(1, parqueadero.totalBicicletasIngresadas());
    }

    @Test
    public void obtenerIngresosTotalesTest() {

        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

        parqueadero.registrarSalidaVehiculo(2, "ABC123", 10.0);

        double resultado = parqueadero.obtenerIngresosTotales();

        Assertions.assertEquals(4000, resultado);
    }

    @Test
    public void calcularPromedioPermanenciaTest() {

        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

        parqueadero.registrarSalidaVehiculo(2, "ABC123", 10.0);

        double resultado = parqueadero.calcularPromedioPermanencia();

        Assertions.assertEquals(2.0, resultado);
    }

    @Test
    public void vehiculosMayorTiempoTest() {

        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

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

        parqueadero.generarRegistro(8.0, 10.0, 3000);

        Assertions.assertEquals(tamanio + 1, parqueadero.getListRegistro().size());

        Registro registro = parqueadero.getListRegistro().get(parqueadero.getListRegistro().size() - 1);

        Assertions.assertEquals(8.0, registro.horaIngreso());

        Assertions.assertEquals(10.0, registro.horaSalida());

        Assertions.assertEquals(3000, registro.valorRegistro());
    }

    @Test
    public void crearAdministradorTest() {

        String resultado = parqueadero.crearAdministrador(
                1, "Nuevo", 10, "3126298273", "nuevo@gmail.com",
                NivelCargo.MEDIO, "nuevo", "A123"
        );

        Assertions.assertEquals("Administrador creado exitosamente", resultado);
    }

    @Test
    public void crearOperarioTest() {

        String resultado = parqueadero.crearOperario(
                1, "Pedro", 20, "3137846872", "pedro@gmail.com",
                8, "pedro", "K123"
        );

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

        parqueadero.registrarIngresoCarro(
                2, "CAR123", "Carlos", 456,
                8.0, 0.0, 4, 3000, "1"
        );

        String resultado = parqueadero.asignarValorHoraCarro(1);
        Assertions.assertTrue(resultado.contains("2000"));
    }

    @Test
    public void asignarValorHoraMotoTest() {

        parqueadero.registrarIngresoMoto(
                2, "ABC123", "Juan", 123,
                8.0, 0.0, 150, 2000, "1"
        );

        String resultado = parqueadero.asignarValorHoraMoto(1);
        Assertions.assertTrue(resultado.contains("1500"));
    }

    @Test
    public void asignarValorHoraBiciTest() {

        parqueadero.registrarIngresoBicicleta(
                2, "BICI1", "Ana", 789,
                8.0, 0.0, "GW", 1000, "1"
        );

        String resultado = parqueadero.asignarValorHoraBici(1);
        Assertions.assertTrue(resultado.contains("1500"));
    }

    @Test
    public void registrarUsuarioTest() {

        String resultado = parqueadero.registrarUsuario(
                1, "Luis", 30, "3114869578",
                "luis@gmail.com", TipoUsuario.ESTUDIANTE
        );

        Assertions.assertEquals("El usuario fue registrado exitosamente", resultado);
    }

    @Test
    public void calcularTarifaEstudianteTest() {
        Parqueadero parqueadero = new Parqueadero("Central", "12345", 10);
        Assertions.assertEquals(9000, parqueadero.calcularTarifaEstudiante(10000));
    }

    @Test
    public void calcularTarifaDocenteTest() {
        Parqueadero parqueadero = new Parqueadero("Central", "12345", 10);
        Assertions.assertEquals(8500, parqueadero.calcularTarifaDocente(10000));
    }

    @Test
    public void calcularTarifaAdministrativoTest() {
        Parqueadero parqueadero = new Parqueadero("Central", "12345", 10);
        Assertions.assertEquals(8000, parqueadero.calcularTarifaAdministrativo(10000));
    }
}