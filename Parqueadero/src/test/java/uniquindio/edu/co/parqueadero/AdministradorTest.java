package uniquindio.edu.co.parqueadero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uniquindio.edu.co.parqueadero.model.Administrador;
import uniquindio.edu.co.parqueadero.model.NivelCargo;

public class AdministradorTest {

    @Test
    public void NivelCargoNuloTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Administrador("Juan", 123, "3121234567", "juan@gmail.com", null, "juan123", "123");
        });
    }

    @Test
    public void UsernameNuloTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Administrador("Juan", 123, "3121234567", "juan@gmail.com", NivelCargo.GERENTE, null, "123");
        });
    }

    @Test
    public void UsernameVacioTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Administrador("Juan", 123, "3121234567", "juan@gmail.com", NivelCargo.GERENTE, "", "123");
        });
    }

    @Test
    public void PasswordNuloTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Administrador("Juan", 123, "3121234567", "juan@gmail.com", NivelCargo.GERENTE, "juan123", null);
        });
    }

    @Test
    public void PasswordVacioTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Administrador("Juan", 123, "3121234567", "juan@gmail.com", NivelCargo.GERENTE, "juan123", "");
        });
    }

    @Test
    public void PasswordSinMayusculaTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            new Administrador("Juan", 123, "3121234567", "juan@gmail.com", NivelCargo.GERENTE, "juan123", "password");
        });
    }
}