import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {

         /*
          1) Escriba un programa que calcule e imprima el producto de tres
             números enteros. (Ej. num1 * num2 * num3)
         */

        Scanner nuevo = new Scanner(System.in);

        int []nums = new int[3];
        int mul = 1;

        for(int i=0; i<3; i++) {
            System.out.println("Ingrese el " + (i+1) + " numero");
            nums[i] = nuevo.nextInt();
            mul = mul *nums[i];
        }
        System.out.println("EL producto de los numeros ingresados es: " + mul);


    }
}
