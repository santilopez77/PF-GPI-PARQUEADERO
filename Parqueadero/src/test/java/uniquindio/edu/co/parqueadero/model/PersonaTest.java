package uniquindio.edu.co.parqueadero.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    /**
     *Test para validar un caso exitoso de creacion de persona

     */
    @Test
    void crearPersonaValida() {
        // Caso de éxito
        Persona persona = new Persona("Juan Perez", 12345, "3001234567", "juan@email.com");
        assertEquals("Juan Perez", persona.getNombre());
        assertEquals(12345, persona.getId());
        assertEquals("3001234567", persona.getTelefono());
        assertEquals("juan@email.com", persona.getEmail());
    }

    /**
     * Test para validar un nombre invalido de persona
     */


    @Test
    void crearPersonaNombreInvalido() {

        assertThrows(AssertionError.class, () -> {
            new Persona("", 12345, "3001234567", "juan@email.com");
        });
    }

    @Test
    void crearPersonaIdInvalido() {
        // El assert debería fallar si el ID es negativo o cero
        assertThrows(AssertionError.class, () -> {
            new Persona("Juan Perez", 12345, "3001234567", "juan@email.com");
        });
    }

    @Test
    void crearPersonaTelefonoInvalido() {
        // El assert debería fallar si el teléfono no tiene 10 dígitos o tiene letras
        assertThrows(AssertionError.class, () -> {
            new Persona("Juan Perez", 12345, "123", "juan@email.com");
        });
        
        assertThrows(AssertionError.class, () -> {
            new Persona("Juan Perez", 12345, "12345678", "juan@email.com");
        });
    }

    @Test
    void crearPersonaEmailInvalido() {
        // El assert debería fallar si el email no tiene el formato correcto
        assertThrows(AssertionError.class, () -> {
            new Persona("Juan Perez", 12345, "3001234567", "email-sin-arroba");
        });
    }
}