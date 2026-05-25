package uniquindio.edu.co.parqueadero;

import org.junit.jupiter.api.Test;
import uniquindio.edu.co.parqueadero.model.Moto;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest{

@Test
public void calcularTarifaTest() {

    Moto moto = new Moto(
            "ABC123",
            "Juan",
            1234,
            8.0,
            11.0,
            150,
            2000,
            "A1"
    );

    double resultado = moto.calcularTarifa();
    assertEquals(6000,resultado);
}


    }
