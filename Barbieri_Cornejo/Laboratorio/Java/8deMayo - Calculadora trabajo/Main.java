import java.util.ArrayList;				
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(18);
        numeros.add(19);
        numeros.add(28);
        numeros.add(29);
        
        ArrayList<Integer> copiaDeNumeros = new ArrayList<>(numeros);

        for ( Integer num : copiaDeNumeros) {
            System.out.println(num);
        }

        copiaDeNumeros = numeros;
        copiaDeNumeros.set(0, 1111);

        System.out.println(numeros.get(0));//imprime 1111
        System.out.println(copiaDeNumeros.get(0));//imprime 1111

        numeros.set(1, 2222);

        System.out.println(numeros.get(1));
        System.out.println(copiaDeNumeros.get(1));

        ArrayList elementos = new ArrayList();
        elementos.add("casa");
        elementos.add(12);
        elementos.add(3.14);

        for (int i = 0; i < elementos.size(); i++) {
            System.out.println(elementos.get(i));
        }

        //-------------------------------------------

        Stack pila1 = new Stack();
        Stack<Rectangulo> pila2 = new Stack<Rectangulo>();

        pila1.empty();
        //retorna true si la pila está vacía y false si tiene elementos

        Rectangulo rect1 = new Rectangulo();
        Plato p1 = new Plato();

        pila1.push("primerElemento");
        pila1.push(12);
        pila1.push(rect1);
        pila1.push(p1);

        System.out.println(pila1);

        pila1.peek(); // retorna el último valor de la pila

        System.out.println(pila1.peek());//imprime último elemento

        //pila1.pop(); elimina el último elemento y lo retorna

        System.out.println(pila1.pop());

        pila1.push(numeros);

        System.out.println(pila1);

        pila1.search(12);//devuelve el índice del elemento 12
        // pila1: [coso, 12, Rectangulo@2de80c, [1111, 2222, 28, 29]]
        //          4     3          2                   1 


    }
}
