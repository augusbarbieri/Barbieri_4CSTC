import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class misTests {

    @Test
    void ejemploATest(){
        int num1 = 1;
        int num2 = 123;
        assertFalse(num1 == num2);
    }

    @Test
    void ejemploBTest(){
        int num1 = 1;
        int num2 = 123;
        assertTrue(num1 != num2);
    }

    @Test
    void ejemploCTest(){
        int num1 = 1;
        int num2 = 1;
        assertEquals(num1, num2);
    }

    @Test
    void ejemploDTest(){
        Persona p1 = new Persona();
        Persona p2 = new Persona();

        boolean valorEsperado = true;
        boolean valorObtenido = p1.sonIguales(p2);

        assertEquals(valorEsperado, valorObtenido);
        assertEquals(true, p1.sonIguales(p2));
    }
}

