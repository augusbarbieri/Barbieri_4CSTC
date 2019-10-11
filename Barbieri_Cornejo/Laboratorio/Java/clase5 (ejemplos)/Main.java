public class Main {
    public static void main(String[] argum){

    
    	Rectangulo rec1 = new Rectangulo();
        
        int alturaDeRec1 = rec1.getAltura();

        /* forma equivalente:

        int alturaDeRec1 =  new Rectangulo().getAltura();

        */        
        
        // se crean dos objetos de clase "Rectangulo"
        Rectangulo rec2 = new Rectangulo();
        Rectangulo rec3 = new Rectangulo();

        // se imprimen la altura y ancho de los objetos
        System.out.println("altura de rec2: " + rec2.getAltura());
        System.out.println("ancho de rec2: " + rec2.getAncho());

        System.out.println("altura de rec3: " + rec3.getAltura());
        System.out.println("altura de rec3: " + rec3.getAncho());


        // rec2 == rec3 es falso. 
        // a pesar de que sean objetos con atributos idénticos

        System.out.println("referencia de rec2: " + rec2);
        System.out.println("referencia de rec2: " + rec3);

        // se utiliza un constructor para determinar la altura a un valor de "123" (el ancho es 15 por defecto)
        Rectangulo r1 = new Rectangulo(123);
        System.out.println("altura de r1: " + r1.getAltura());
        System.out.println("ancho de r1: " + r1.getAncho());

        // se utiliza un constructor para determinar la altura a un valor de "123" y el ancho a "156"
        Rectangulo r2 = new Rectangulo(122,156);
        System.out.println("altura de r2: " + r2.getAltura());
        System.out.println("ancho de r2: " + r2.getAncho());

        // el metodo compara si las caracteristicas son igualrs de ambos

        System.out.println("r1 y r2, son iguales? Respuesta: " + r1.sonIguales(r2));

    } 
}