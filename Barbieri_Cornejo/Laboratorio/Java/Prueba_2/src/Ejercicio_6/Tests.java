package Ejercicio_6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    //Test de Persona

    @Test
    public void testMayorDeEdad(){
        Persona persona1 = new Persona();
        assertFalse(persona1.mayorEdad());
    }
    @Test
    public void testLetraA(){
        Persona persona1 = new Persona();
        assertTrue(persona1.letraA());
    }
    @Test
    public void testDniMenor(){
        Persona persona1 = new Persona();
        assertFalse(persona1.dniMenor());
    }

    //Test de Madre
    @Test
    public void testhijosMenoresdeEdad(){
        Madre madre1 = new Madre();

    }

}
