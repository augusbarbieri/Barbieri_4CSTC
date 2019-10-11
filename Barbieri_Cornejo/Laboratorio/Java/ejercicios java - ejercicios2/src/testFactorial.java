public class testFactorial {

    public static void main(String[] args) { 

        Factorial caso1 = new Factorial(0);
        Factorial caso2 = new Factorial();

        int valorEsperado = 0;
        int valorFuncion = 0;

        valorEsperado = 1;
        valorFuncion = caso1.hagoFactorial();

        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        valorEsperado = 40320;
        valorFuncion = caso2.hagoFactorial();

        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

    }
}