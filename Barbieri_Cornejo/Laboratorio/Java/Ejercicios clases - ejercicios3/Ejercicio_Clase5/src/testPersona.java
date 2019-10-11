import java.util.Scanner;

public class testPersona {
    public static void main(String[] args) {

         //hecho

        Persona josefine = new Persona("josefa", 18, 46464646, 99999999, "Carambita 9898");
        Persona patricie = new Persona("miguer", 15, 89891478,66781616, "Bongo Grande 5000");

        boolean valorEsperado = 0;
        boolean valorFuncion = 0;

        valorEsperado = true;
        valorFuncion = josefine.esMayordeEdad();
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        valorEsperado = false;
        valorFuncion = patricie.esMayordeEdad();
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        valorEsperado = false;
        valorFuncion = patricie.sonLaMismaPersona(josefine);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        valorEsperado = false;
        valorFuncion = patricie.tienenLaMismaEdad(josefine);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        }

    }