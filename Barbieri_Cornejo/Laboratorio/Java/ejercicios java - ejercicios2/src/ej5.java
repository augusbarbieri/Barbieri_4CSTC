import java.util.Scanner;

public class ej5 {

    private int numero;



    public static void main(String[] args) {

        /*
            Escriba un programa que reciba un año y un mes e informe por consola
            la cantidad de de días que tiene ese mes de ese año. Considerar años bisiestos.
         */

        int año = 0, mes = 0;
        boolean bisiesto;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un año - en numeros - ");
        año = entrada.nextInt();
        System.out.println("Ingrese un mes - en numeros - ");
        mes = entrada.nextInt();

        if( año%4 != 0 && ( año%100 == 0 || año%400 != 0 ) ){
            System.out.println("El año no es bisiesto");
            bisiesto = false;
            System.out.println("La cantidad de dias del mes " + mes + " es de " + dias(mes,bisiesto));
        }
        else{
            System.out.println("El año es bisiesto");
            bisiesto = true;
            System.out.println("La cantidad de dias del mes " + mes + " es de " + dias(mes,bisiesto));
        }

    }

    public static int dias(int meses, boolean bis){

        int dias = 0;

        switch(meses){
            case 1:
            dias = 31;
            break;
            case 2:
            if(bis == true){
                dias = 29;
            }
            else{
                dias = 28;
            }
            break;
            case 3:
            dias = 31;
            break;
            case 4:
            dias = 30;
            break;
            case 5:
            dias = 31;
            break;
            case 6:
            dias = 30;
            break;
            case 7:
            dias = 31;
            break;
            case 8:
            dias = 31;
            break;
            case 9:
            dias = 30;
            break;
            case 10:
            dias = 31;
            break;
            case 11:
            dias = 30;
            break;
            case 12:
            dias = 31;
            break;
        }

        return dias;
    }

}