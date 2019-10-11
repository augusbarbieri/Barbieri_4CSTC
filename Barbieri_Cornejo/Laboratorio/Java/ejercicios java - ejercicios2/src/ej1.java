import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {


        //Ejemplo


        System.out.println("hola! Ingrese un número entero");
        Scanner nameVariable = new Scanner(System.in);

        float num = nameVariable.nextInt();
        System.out.println("ingresaste el número: " + num);

        System.out.println("---------------------------------");


        System.out.println("ingrese su nombre");
        Scanner nombre = new Scanner(System.in);
        String  nombreDeUsuario = nombre.nextLine();
        System.out.println("ingresaste el nombre: "+ nombreDeUsuario);

    }
}
