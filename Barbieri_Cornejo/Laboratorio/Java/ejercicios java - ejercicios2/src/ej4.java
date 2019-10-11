import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {

        /*
            Escriba un algoritmo para determinar si un número N es divisible por M.
         */

        int N = 0, M = 0;


        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero N");
        N = entrada.nextInt();
        System.out.println("Ingrese un numero M");
        M = entrada.nextInt();

        if(N%M == 0){
            System.out.println("Los numeros son divisibles");
        }
        else{
            System.out.println("Los numeros no son divisibles entre si");
        }

    }
}
