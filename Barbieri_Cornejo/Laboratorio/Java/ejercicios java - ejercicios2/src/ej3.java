import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {

        /*
                Escriba un programa que pida al usuario que escriba dos números,
                que obtenga los números del usuario y muestre el número más grande,
                seguido de las palabras “el número es más grande”.
                Si los números son iguales, imprima el mensaje “Estos números son iguales”.
         */

        Scanner entrada = new Scanner(System.in);

        int []nums = new int[2];

        for(int i=0; i<2; i++){
            System.out.println("Ingrese el numero" + (i+1));
            nums[i] = entrada.nextInt();
        }

        if(nums[0] < nums[1]){
            System.out.println("El numero mas grande es " + nums[0]);
        }
        else if(nums[0] == nums[1]){
            System.out.println("Los numeros ingresados son iguales");
        }
        else{
            System.out.println("El numero mas grande es " + nums[1]);
        }

    }
}