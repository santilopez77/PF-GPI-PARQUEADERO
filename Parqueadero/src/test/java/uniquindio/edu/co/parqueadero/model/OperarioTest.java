package uniquindio.edu.co.parqueadero.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperarioTest {

    @Test
    public void HorasTrabajadasNulasTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Operario("melissa", 498, "3121234567", "juan@gmail.com", -1, "juan123", "123");
        });
    }

    @Test
    public void UsernameNuloTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Operario("Juan", 123, "3121234567", "juan@gmail.com", 12, "123", null);
        });
    }

    @Test
    public void UsernameVacioTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Operario("Juan", 123, "3121234567", "juan@gmail.com", 12, null, "password");
        });
    }

    @Test
    public void PasswordNuloTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Operario("Juan", 123, "3121234567", "juan@gmail.com", 12, "123", null);
        });
    }

    @Test
    public void PasswordVacioTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Operario("Juan", 123, "3121234567", "juan@gmail.com", 12, "123", "");
        });
    }

    @Test
    public void PasswordSinMayusculaTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Operario("Juan", 123, "3121234567", "juan@gmail.com", 12, "123", "password");
        });
    }
}

