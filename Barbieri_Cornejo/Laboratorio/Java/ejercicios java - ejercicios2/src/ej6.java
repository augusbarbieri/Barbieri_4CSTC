import java.util.Scanner;

public class ej6 {
    public static void main(String[] args) {

        /*
            Pasar un período expresado en segundos a un período expresado
            en días, horas, minutos y segundos.
         */

        int segundos = 0, minutos = 0, horas = 0, dias = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un periodo en segundos:");
        segundos = entrada.nextInt();

        minutos = segundos/60;
        horas = minutos/60;
        dias = horas/24;

        System.out.println("EL tiempo ingresado en segundos corresponde a "+minutos+" minutos, "+horas+" horas y "+dias+" dias");

    }
}
