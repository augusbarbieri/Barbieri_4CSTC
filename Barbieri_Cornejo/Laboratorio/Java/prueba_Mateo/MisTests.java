import java.util.Stack;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MisTests{

    // Tests de Metodos de la Clase Colectivo

    @Test
    void pagadosBoletos(){

        Colectivo enter = new Colectivo(1, false, 5); // 5 pasajeros

        // hay 4 pasajeros
        Pasajero nuevo1 = new Pasajero(43441456, "Mateo");
        Pasajero nuevo2 = new Pasajero(43442567, "Santiago");
        Pasajero nuevo3 = new Pasajero(43456765, "Lucas");
        Pasajero nuevo4 = new Pasajero(43446892, "María");

        Boleto a = new Boleto(nuevo1,325, 300, true);
        Boleto b = new Boleto(nuevo2, 350, 190, false);
        Boleto c = new Boleto(nuevo3, 275, 190, false);
        Boleto d = new Boleto(nuevo1, 1500, 300, true);
        Boleto e = new Boleto(nuevo1, 550, 300, true);
        Boleto f = new Boleto(nuevo2, 500, 190, false);
        Boleto g = new Boleto(nuevo1, 450, 300, true);
        Boleto h = new Boleto(nuevo1, 475, 300, true);
        Boleto i = new Boleto(nuevo1, 425, 300, true);
        Boleto j = new Boleto(nuevo4, 575, 300, true);
        Boleto k = new Boleto(nuevo4, 600, 300, true);

        enter.addBoletosTotales(a);
        enter.addBoletosTotales(b);
        enter.addBoletosTotales(c);
        enter.addBoletosTotales(d);
        enter.addBoletosTotales(e);
        enter.addBoletosTotales(f);
        enter.addBoletosTotales(g);
        enter.addBoletosTotales(h);
        enter.addBoletosTotales(i);
        enter.addBoletosTotales(j);
        enter.addBoletosTotales(k);

        // 4 boletos actuales
        enter.addBoletosActuales(a);
        enter.addBoletosActuales(f);
        enter.addBoletosActuales(j);
        enter.addBoletosActuales(c);

        boolean valorEsperado = false;
        boolean valorObtenido = enter.boletosPagados();

        assertTrue(valorEsperado == valorObtenido);
    }

    @Test
    void metrosAdecuados(){

        Colectivo enter = new Colectivo(1, false, 5);

        Pasajero nuevo1 = new Pasajero(43441456, "Mateo");
        Pasajero nuevo2 = new Pasajero(43442567, "Santiago");
        Pasajero nuevo3 = new Pasajero(43456765, "Lucas");
        Pasajero nuevo4 = new Pasajero(43446892, "María");

        Boleto a = new Boleto(nuevo1, 325, 300, true); // ingresada - los recorridos son menores a los pagados
        Boleto b = new Boleto(nuevo2,350, 190, false);
        Boleto c = new Boleto(nuevo3,  275, 190, false); //ingresada - los recorridos son menores a los pagados
        Boleto d = new Boleto(nuevo1, 1500, 300, true);
        Boleto e = new Boleto(nuevo1, 550, 300, true);
        Boleto f = new Boleto(nuevo2,  500, 190, false);//ingresada - los recorridos son menores a los pagados
        Boleto g = new Boleto(nuevo1, 450, 300, true);
        Boleto h = new Boleto(nuevo1, 475, 300, true);
        Boleto i = new Boleto(nuevo1, 425, 300, true);

        Boleto j = new Boleto(nuevo4, 575, 300, true); //ingresada - los recorridos son menores a los ingresados

        Boleto k = new Boleto(nuevo4, 600, 300, true);

        enter.addBoletosTotales(a);
        enter.addBoletosTotales(b);
        enter.addBoletosTotales(c);
        enter.addBoletosTotales(d);
        enter.addBoletosTotales(e);
        enter.addBoletosTotales(f);
        enter.addBoletosTotales(g);
        enter.addBoletosTotales(h);
        enter.addBoletosTotales(i);
        enter.addBoletosTotales(j);
        enter.addBoletosTotales(k);

        enter.addBoletosActuales(a);
        enter.addBoletosActuales(f);
        enter.addBoletosActuales(j);
        enter.addBoletosActuales(c);

        boolean valorEsperado = true;
        boolean valorObtenido = enter.metrosCorrectos();

        assertTrue(valorEsperado == valorObtenido);
    }

    @Test
    void descuentoAplicado(){

        Colectivo enter = new Colectivo(1, false, 5); // 5 pasajeros

        // hay 4 pasajeros
        Pasajero nuevo1 = new Pasajero(43441456, "Mateo");
        Pasajero nuevo2 = new Pasajero(43442567, "Santiago");
        Pasajero nuevo3 = new Pasajero(43456765, "Lucas");
        Pasajero nuevo4 = new Pasajero(43446892, "María");

        Boleto a = new Boleto(nuevo1, 325, 300, true); // FRECUENTE
        Boleto b = new Boleto(nuevo2,  350, 190, false);
        Boleto c = new Boleto(nuevo3,  275, 190, false); // NO FRECUENTE
        Boleto d = new Boleto(nuevo1, 1500, 300, true);
        Boleto e = new Boleto(nuevo1, 550, 300, true);
        Boleto f = new Boleto(nuevo2,  500, 190, false); // NO FRECUENTE
        Boleto g = new Boleto(nuevo1, 450, 300, true);
        Boleto h = new Boleto(nuevo1, 475, 300, true);
        Boleto i = new Boleto(nuevo1, 425, 300, true);
        Boleto j = new Boleto(nuevo4, 575, 300, true); // FRECUENTE
        Boleto k = new Boleto(nuevo4, 600, 300, true);

        enter.addBoletosTotales(a);
        enter.addBoletosTotales(b);
        enter.addBoletosTotales(c);
        enter.addBoletosTotales(d);
        enter.addBoletosTotales(e);
        enter.addBoletosTotales(f);
        enter.addBoletosTotales(g);
        enter.addBoletosTotales(h);
        enter.addBoletosTotales(i);
        enter.addBoletosTotales(j);
        enter.addBoletosTotales(k);

        // 4 boletos actuales
        enter.addBoletosActuales(a);
        enter.addBoletosActuales(f);
        enter.addBoletosActuales(j);
        enter.addBoletosActuales(c);

        boolean valorEsperado = true;
        boolean valorObtenido = enter.descAplicado();

        assertFalse(valorEsperado == valorObtenido);
    }

    @Test
    void unidadEnOrden(){

        Colectivo enter = new Colectivo(1, false, 5); // 5 pasajeros

        // hay 4 pasajeros
        Pasajero nuevo1 = new Pasajero(43441456, "Mateo");
        Pasajero nuevo2 = new Pasajero(43442567, "Santiago");
        Pasajero nuevo3 = new Pasajero(43456765, "Lucas");
        Pasajero nuevo4 = new Pasajero(43446892, "María");

        Boleto a = new Boleto(nuevo1,325, 300, true);
        Boleto b = new Boleto(nuevo2, 350, 190, false);
        Boleto c = new Boleto(nuevo3,  275, 190, false);
        Boleto d = new Boleto(nuevo1, 1500, 300, true);
        Boleto e = new Boleto(nuevo1, 550, 300, true);
        Boleto f = new Boleto(nuevo2,  500, 190, false);
        Boleto g = new Boleto(nuevo1, 450, 300, true);
        Boleto h = new Boleto(nuevo1, 475, 300, true);
        Boleto i = new Boleto(nuevo1, 425, 300, true);
        Boleto j = new Boleto(nuevo4, 575, 300, true);
        Boleto k = new Boleto(nuevo4, 600, 300, true);

        enter.addBoletosTotales(a);
        enter.addBoletosTotales(b);
        enter.addBoletosTotales(c);
        enter.addBoletosTotales(d);
        enter.addBoletosTotales(e);
        enter.addBoletosTotales(f);
        enter.addBoletosTotales(g);
        enter.addBoletosTotales(h);
        enter.addBoletosTotales(i);
        enter.addBoletosTotales(j);
        enter.addBoletosTotales(k);

        // 4 boletos actuales
        enter.addBoletosActuales(a);
        enter.addBoletosActuales(f);
        enter.addBoletosActuales(j);
        enter.addBoletosActuales(c);

        boolean valorEsperado = false;
        boolean valorObtenido = enter.estaEnOrden();

        assertTrue(valorEsperado == valorObtenido);
    }

    @Test
    void unidadEnOrden(){

        Colectivo enter = new Colectivo(1, false, 5); // 5 pasajeros

        // hay 4 pasajeros
        Pasajero nuevo1 = new Pasajero(43441456, "Mateo");
        Pasajero nuevo2 = new Pasajero(43442567, "Santiago");
        Pasajero nuevo3 = new Pasajero(43456765, "Lucas");
        Pasajero nuevo4 = new Pasajero(43446892, "María");

        Boleto a = new Boleto(nuevo1,325, 300, true);
        Boleto b = new Boleto(nuevo2, 350, 190, false);
        Boleto c = new Boleto(nuevo3,  275, 190, false);
        Boleto d = new Boleto(nuevo1, 1500, 300, true);
        Boleto e = new Boleto(nuevo1, 550, 300, true);
        Boleto f = new Boleto(nuevo2,  500, 190, false);
        Boleto g = new Boleto(nuevo1, 450, 300, true);
        Boleto h = new Boleto(nuevo1, 475, 300, true);
        Boleto i = new Boleto(nuevo1, 425, 300, true);
        Boleto j = new Boleto(nuevo4, 575, 300, true);
        Boleto k = new Boleto(nuevo4, 600, 300, true);

        enter.addBoletosTotales(a);
        enter.addBoletosTotales(b);
        enter.addBoletosTotales(c);
        enter.addBoletosTotales(d);
        enter.addBoletosTotales(e);
        enter.addBoletosTotales(f);
        enter.addBoletosTotales(g);
        enter.addBoletosTotales(h);
        enter.addBoletosTotales(i);
        enter.addBoletosTotales(j);
        enter.addBoletosTotales(k);

        // 4 boletos actuales
        enter.addBoletosActuales(a);
        enter.addBoletosActuales(f);
        enter.addBoletosActuales(j);
        enter.addBoletosActuales(c);

        boolean valorEsperado = false;
        boolean valorObtenido = enter.estaEnOrden();

        assertTrue(valorEsperado == valorObtenido);
    }

    @Test
    void PasajeroFrecuente(){

        Colectivo enter = new Colectivo(1, false, 5); // 5 pasajeros

        // hay 4 pasajeros
        Pasajero nuevo1 = new Pasajero(43441456, "Mateo");
        Pasajero nuevo2 = new Pasajero(43442567, "Santiago");
        Pasajero nuevo3 = new Pasajero(43456765, "Lucas");
        Pasajero nuevo4 = new Pasajero(43446892, "María");

        //30 boletos
        Boleto a = new Boleto(nuevo1,325, 300, true); // 1
        Boleto b = new Boleto(nuevo2, 350, 190, false);
        Boleto c = new Boleto(nuevo3,  275, 190, false);
        Boleto d = new Boleto(nuevo1, 1500, 300, true); // 2
        Boleto e = new Boleto(nuevo1, 550, 300, true); // 3
        Boleto f = new Boleto(nuevo2,  500, 190, false);
        Boleto g = new Boleto(nuevo1, 450, 300, true); // 4
        Boleto h = new Boleto(nuevo1, 475, 300, true);// 5
        Boleto i = new Boleto(nuevo1, 425, 300, true);// 6
        Boleto j = new Boleto(nuevo4, 575, 300, true);// 7
        Boleto k = new Boleto(nuevo4, 600, 300, true);// 8
        for(int contador=0; contador<17; contador++){
            enter.addBoletosTotales(new Boleto(nuevo1,325, 300, true));
        }

        //30 boletos totales
        enter.addBoletosTotales(a);
        enter.addBoletosTotales(b);
        enter.addBoletosTotales(c);
        enter.addBoletosTotales(d);
        enter.addBoletosTotales(e);
        enter.addBoletosTotales(f);
        enter.addBoletosTotales(g);
        enter.addBoletosTotales(h);
        enter.addBoletosTotales(i);
        enter.addBoletosTotales(j);
        enter.addBoletosTotales(k);

        // 4 boletos actuales
        enter.addBoletosActuales(a);
        enter.addBoletosActuales(f);
        enter.addBoletosActuales(j);
        enter.addBoletosActuales(c);

        boolean valorEsperado = true;
        enter.pasajeroFrecuente(nuevo1.getiDTarjeta());
        boolean valorObtenido = a.getFrecuente();

        assertTrue(valorEsperado == valorObtenido);
    }

    // Tests de la clase boleto

    @Test
    void DescuentoCorrecto1(){

        Pasajero usuario = new Pasajero(5133678, "Gerardo");
        Boleto registro = new Boleto(usuario,325, 320, false);

        registro.calcularDescuento();

        double valorEsperado = 0;
        double valorObtenido = registro.getDescuento();

        assertTrue(valorEsperado == valorObtenido);
    }

    @Test
    void DescuentoCorrecto2(){

        Pasajero usuario2 = new Pasajero(5133679, "Alexander");
        Boleto registro2 = new Boleto(usuario2,150, 80, true);

        registro2.calcularDescuento();

        double valorEsperado = 0;
        double valorObtenido = registro2.getDescuento();

        assertFalse(valorEsperado == valorObtenido);
    }

    @Test
    void calculoDePrecio(){

        Pasajero usuario = new Pasajero(5133678, "Gerardo");
        Boleto registro = new Boleto(usuario,325, 320, false);

        registro.calcularPrecio();

        double valorEsperado = 162.5;
        double valorObtenido = registro.getPrecio();

        assertTrue(valorEsperado == valorObtenido);

    }

}