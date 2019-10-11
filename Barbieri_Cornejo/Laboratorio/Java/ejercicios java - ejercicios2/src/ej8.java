import java.util.Scanner;

public class ej8 {
    public static void main(String[] args){

        /*
            Escriba un programa que imprima los primeros n números pares.
            El valor n se ingresa por teclado.
            Luego modifíquelo para que, además de  imprimirlos calcule su suma.

         */

        int n = 0, pares = 0, suma = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero entero:");
        n = entrada.nextInt();
        System.out.println("Se mostraran los primeros "+n+" numeros pares");

        for(int i=1; i<=n; i++){
            pares =+ i*2;
            System.out.println("Numero par "+(i+1)+" : "+pares);
            suma=+pares;
        }

        System.out.println("La suma de los "+n+" numeros pares es: "+suma);

    }
}
