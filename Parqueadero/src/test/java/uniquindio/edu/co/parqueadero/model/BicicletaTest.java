package uniquindio.edu.co.parqueadero.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BicicletaTest {


    @Test
    void calcularTarifa() {
        Bicicleta bicicleta = new Bicicleta(
            "GW123", "Juan Perez", 98765, 8.0, 10.0, "GW", 1000.0, "B1"
        );

        double tarifaEsperada = 1000.0 * (10.0 - 8.0);
        assertEquals(tarifaEsperada, bicicleta.calcularTarifa());
    }
    }
