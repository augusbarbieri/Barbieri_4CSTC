import java.util.Scanner;

public class ej12 {

    public static void main(String[] args) {

    /*
        Sabiendo que la definición de factorial de un número N  (que se simboliza N! )
         es igual a:
	                N! = 1 x 2 x 3 x 4 x … x (N -2) x (N -1) x N
         (por ejemplo, el factorial de 5 es 5! = 1 x 2 x 3 x 4 x 5 )
         Realizar un programa que haga dicho cálculo para cualquier valor ingresado.
     */
        int factorial = 0, numero = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero para determinar su factorial");
        numero = entrada.nextInt();

        if (numero == 0){
            return 1;
        }
        else{
            while (numero != 0) {
                factorial = factorial *numero ;
                numero--;
            }
        }

        System.out.println("El factorial del numero ingresado es: " +factorial);

    }
}