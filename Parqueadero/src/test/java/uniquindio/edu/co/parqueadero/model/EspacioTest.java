package uniquindio.edu.co.parqueadero.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EspacioTest {

    @Test
    public void constructorCodigoNegativoTest() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Espacio(-1, "ABC123");
        });

        Assertions.assertEquals("El codigo debe ser positivo", exception.getMessage());
    }

    @Test
    public void constructorVehiculoAsignadoNuloTest() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Espacio(1, null);
        });

        Assertions.assertEquals("El vehiculo asignado no puede estar vacio", exception.getMessage());
    }

    @Test
    public void constructorVehiculoAsignadoVacioTest() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Espacio(1, "");
        });

        Assertions.assertEquals("El vehiculo asignado no puede estar vacio", exception.getMessage());
    }

}