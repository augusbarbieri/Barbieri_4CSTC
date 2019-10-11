import java.util.Scanner;

public class ej7 {
    public static void main(String[] args) {

        /*
            Desarrolle un algoritmo que permita encontrar el mínimo común múltiplo
            entre dos números enteros ingresados por pantalla.
        */

        int num1 = 0, num2 = 0, mul = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero:");
        num1 = entrada.nextInt();
        System.out.println("Ingrese otro numero:");
        num2 = entrada.nextInt();

        mul = (num1 > num2) ? num1 : num2;

        while(true)
        {
            if (mul % num1 == 0 && mul % num2 == 0)
            {
                System.out.println("Lcm: " + mul);
                break;
            }
            else
                ++mul;
        }

    }
}


