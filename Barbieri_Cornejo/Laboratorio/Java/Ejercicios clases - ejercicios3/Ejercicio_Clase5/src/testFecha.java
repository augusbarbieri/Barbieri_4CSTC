public class testFecha {
    public static void main(String[] args) {
            
        int a, b, c, e, f, g;
        a = 1;
        b = 2;
        c = 2013;
        d = 28;
        e = 6;
        f = 2009;
        g = 16;

        Fecha fecha1 = new Fecha(a, b, c);
        Fecha fecha2 = new Fecha(g, e, f);

        boolean valorEsperado = false;
        boolean valorFuncion = false;

        valorEsperado = 1;
        valorFuncion = fecha1.FechasDistintas(fecha2);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        valorEsperado = 1;
        valorFuncion = fecha1.FechaMenoraOtra(fecha2);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");


    }
}