package uniquindio.edu.co.parqueadero;

public class MotoTest {
    @org.junit.jupiter.api.Test
    void testCalcularTarifaMoto() {
        uniquindio.edu.co.parqueadero.model.Moto moto = new uniquindio.edu.co.parqueadero.model.Moto(
            "XYZ-789", "Carlos Perez", 12345, 10.0, 12.0, 250, 1500.0, "M1"
        );

        // El cálculo en la clase Moto es valorHora * (getHoraSalida() - getHoraIngreso())
        double tarifaEsperada = 1500.0 * (12.0 - 10.0);
        org.junit.jupiter.api.Assertions.assertEquals(tarifaEsperada, moto.calcularTarifa());
    }

}
