import java.util.Scanner;

public class Main{
    public static void  main(String[] args){

        Restaurante a = new Restaurante();
        Restaurante b = new Restaurante();

        Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa(false);
        Mesa mesa3 = new Mesa();
        Mesa mesa4 = new Mesa(false);

        Plato plato1 = new Plato();
        Plato plato2 = new Plato("Milanesa a caballo", 1, 30, 2);
        Plato plato4 = new Plato("Milanesa a caballo", 5, 14, 1);
        Plato plato5 = new Plato("Milanesa a caballo", 3, 8, 5);

        mesa1.addPlatos(plato1);

        a.add(plato1);
        a.add(plato2);
        a.add(plato4);
        a.add(plato5);

        // Tests de Mesa

        System.out.println("Test ocupada");
        if(mesa1.getOcupada() == true)
        	System.out.println("Esta ocupada, ahora la vacio y..:");
        else System.out.println("Esta vacia");
        mesa1.vaciarDesocupada();
        if(mesa1.getOcupada() == true)
        	System.out.println("Esta vacia, pasa el test");
        else System.out.println("Esta ocupada, falla el test");

        System.out.println("Test checkEmpty");
        mesa1.VaciarDesocupada();
        boolean vacia = true;
        boolean vaciafuncion = mesa1.isEmpty();
        System.out.println((vacia == vaciafuncion)?"Pasó el test.":"No pasó el test.");

        // tests de Restaurante

        System.out.println("Test checkEmpty");
        boolean esperado = true;
        boolean valorFuncion = b.checkEmpty();
        System.out.println((esperado == valorFuncion)?"Pasó el test.":"No pasó el test.");

        System.out.println("Test Plato_Mas_Pedido");
        String mas_pedido = "Milanesa a caballo";
        String valorFuncion = a.Plato_Mas_Pedido();
        System.out.println((mas_pedido == valorFuncion)?"Pasó el test.":"No pasó el test.");

        System.out.println("Test Plato_Menos_Pedido");
        String menos_pedido = "Fideos con salsa bolognesa";
        String valorReal = a.Plato_Menos_Pedido();
        System.out.println((menos_pedido == valorReal)?"Pasó el test.":"No pasó el test.");

    }
}