import java.util.Stack;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test{

    // Tests de Metodos de la Clase Colectivo

	Colectivo enter = new Colectivo (1,20,6);

	Pasajero nuevo1 = new Pasajero ("Augusto", 1, 7);
	Pasajero nuevo2 = new Pasajero ("Valentina", 2, 10);
	Pasajero nuevo3 = new Pasajero ("Nadia", 3, 15);
	Pasajero nuevo4 = new Pasajero ("Cornejo", 4, 20);
	Pasajero nuevo5 = new Pasajero ("Mateo", 5, 27);
	Pasajero nuevo6 = new Pasajero ("Esteban", 6, 30);


	Pasaje a = new Pasaje (100,200,300,400); 
	Pasaje b = new Pasaje (100,250,255,425);
	Pasaje c = new Pasaje (100,260,265,430);
	Pasaje d = new Pasaje (100,270,275,435);
	Pasaje e = new Pasaje (100,280,285,440);
	Pasaje f = new Pasaje (100,290,295,445);
	Pasaje g = new Pasaje (100,300,305,450);
	Pasaje h = new Pasaje (100,310,315,460);
	Pasaje i = new Pasaje (100,320,325,465);
	Pasaje j = new Pasaje (100,330,335,470);

	enter.addCantidadPasajerosTotales(a);
    enter.addCantidadPasajerosTotales(b);
    enter.addCantidadPasajerosTotales(c);
    enter.addCantidadPasajerosTotales(d);
    enter.addCantidadPasajerosTotales(e);
    enter.addCantidadPasajerosTotales(f);
    enter.addCantidadPasajerosTotales(g);
    enter.addCantidadPasajerosTotales(h);
    enter.addCantidadPasajerosTotales(i);
    enter.addCantidadPasajerosTotales(j);


    enter.addCantidadPasajerosPagados(a);
    enter.addCantidadPasajerosPagados(f);
    enter.addCantidadPasajerosPagados(j);
    enter.addCantidadPasajerosPagados(c);

    @Test
    void Boletopagado(){
        boolean valorEsperado = false;
        boolean valorObtenido = enter.boletoPagados();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    void Metroscorrectos(){

    	boolean valorEsperado = false;
        boolean valorObtenido = enter.metroscorrectos();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    void DescuentoAplicado(){
    	boolean valorEsperado = true;
        boolean valorObtenido = enter.descAplicado();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    void ColectivoOK(){
    	boolean valorEsperado = false;
        boolean valorObtenido = enter.Colectivo_Feliz_Ordenado();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    void PasajeroFrecuente(){
    	boolean valorEsperado = true;
        enter.pasajeroFrecuente(nuevo1.getiDTarjeta());
        boolean valorObtenido = a.getFrecuente();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    void PasajeroFrecuente(){
    	boolean valorEsperado = true;
        boolean valorObtenido = a.getDescuento();

        assertEquals(valorEsperado,valorObtenido);
    }

}