package uniquindio.edu.co.parqueadero;

import org.junit.jupiter.api.Test;
import uniquindio.edu.co.parqueadero.model.Carro;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarroTest {
    @Test
    public void calcularTarifaTest() {

        Carro carro = new Carro("ABC123", "Juan", 1234, 8.0, 16.0, 4, 2500, "A1");

        double resultado = carro.calcularTarifa();
        assertEquals(20000, resultado);
    }
}
