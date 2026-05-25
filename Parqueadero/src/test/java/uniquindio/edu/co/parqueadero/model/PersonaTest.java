package uniquindio.edu.co.parqueadero.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    @Test
    public void NombreNuloTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona(null, 498, "3121234567", "juan@gmail.com");
        });
    }

    @Test
    public void NombreVacioTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("", 498, "3121234567", "juan@gmail.com");
        });
    }

    @Test
    public void IdNegativoTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("melissa", -1, "3121234567", "juan@gmail.com");
        });
    }

    @Test
    public void IdCeroTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("melissa", 0, "3121234567", "juan@gmail.com");
        });
    }

    @Test
    public void TelefonoNuloTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("melissa", 498, null, "juan@gmail.com");
        });
    }

    @Test
    public void TelefonoConMenosDe10DigitosTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("melissa", 498, "3121234", "juan@gmail.com");
        });
    }

    @Test
    public void TelefonoConLetrasTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("melissa", 498, "31212abc67", "juan@gmail.com");
        });
    }

    @Test
    public void EmailNuloTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("melissa", 498, "3121234567", null);
        });
    }

    @Test
    public void EmailSinArrobaTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("melissa", 498, "3121234567", "juangmail.com");
        }
        );
    }
}

