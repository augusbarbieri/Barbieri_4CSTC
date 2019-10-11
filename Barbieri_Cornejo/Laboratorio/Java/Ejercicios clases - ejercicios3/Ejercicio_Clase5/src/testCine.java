public class testCine {
    public static void main(String[] args) {

        Cine cine1 = new Cine();
        Cine cine2 = new Cine(150, "Cabildo", 3, 4);

        boolean valorEsperado = 0;
        boolean valorFuncion = 0;

        valorEsperado = false;
        valorFuncion = cine2.sonIguales(cine1);
        System.out.println((valorEsperado==valorFuncion)?"No pasó el test.":"Pasó el test.");

        valorEsperado = true;
        valorFuncion = cine2.entrada125(cine1);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        valorEsperado = true;
        valorFuncion = cine2.mismaZona(cine1);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        valorEsperado = true;
        valorFuncion = cine2.cantidadsalas_peliculas(cine1);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

    }
}