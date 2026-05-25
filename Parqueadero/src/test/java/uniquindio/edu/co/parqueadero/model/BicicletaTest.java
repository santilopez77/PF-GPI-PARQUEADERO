package uniquindio.edu.co.parqueadero.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BicicletaTest {


    @Test
    public void calcularTarifaTest() {

        Bicicleta bicicleta = new Bicicleta("ABC123", "Juan", 1234, 8.0, 16.0, "GW", 1200, "A1");

        double resultado = bicicleta.calcularTarifa();
        assertEquals(9600, resultado);
    }
}

