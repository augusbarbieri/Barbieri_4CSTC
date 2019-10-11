public class testHorario {
    public static void main(String[] args) {

        Horario hora1 = new Horario();
        Horario hora2 = new Horario(1, 23, 59);

        boolean valorEsperado = 0;
        boolean valorFuncion = 0;

        valorEsperado = false;
        valorFuncion = hora1.esMenor(hora2);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");

        valorEsperado = false;
        valorFuncion = hora1.sonIguales(hora2);
        System.out.println((valorEsperado==valorFuncion)?"Pasó el test.":"No pasó el test.");


    }

}