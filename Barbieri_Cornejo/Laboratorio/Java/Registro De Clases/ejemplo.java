import java.util.ArrayList;

public class ejemplo{

	public static void main(String[] args){

		ArrayList<Persona> b = new ArrayList<Persona>();

		Persona pepe1 = new Persona();
		Persona pepe2 = new Persona();

		b.add(pepe1);
		b.add(pepe2);

		ArrayList a = new ArrayList();
		System.out.println(a.size());

		a.add(5);
		a.add("casa");
		a.add(2.1);
		a.add(pepe2);

		System.out.println(a.size());

		// Añade el elemento al ArrayList en la posición 1
		a.add(1, "Elemento");

		// Devuelve el elemento que esta en la posición '2' del ArrayList
		a.get(2);

		// Comprueba se existe del elemento ('Elemento') que se le pasa como parametro
		a.contains("Elemento");

		// Borra el elemento de la posición '1' del ArrayList   
        a.remove(1); 

		//Borra todos los elementos de ArrayList   
		a.clear();

		// Devuelve True si el ArrayList esta vacio. Sino, devuelve False   
		a.isEmpty();

		// Devuelve el índice de la primera aparición del número 1 en el ArrayList
        a.indexOf(1);
        
        // Devuelve el índice de la última aparición del número 1 en el ArrayList   
        a.lastIndexOf(1);

		/*

		clases envolventes

		como arrayList sólo usa objetos, no podemos crear
		arrayLists de tipos primitivos como int, float y boolean.

		Por ello, en vez de usar tipos primitivos, usaremos
		clases que sirven para "reemplazar" a los tipos primitivos.
		Tales clases se llaman clases envolventes.

		int    ---> Integer
		Integer i = new Integer(23);
		i.integerValue(), retorna el valor 23

		*/

		ArrayList<Integer> enteros = new ArrayList<Integer>(); 

		/*

		float  ---> Float
		Float f = new Float(2.2);
		f.floatValue(), retorna el valor 2.2

		*/

		ArrayList<Float> ff = new ArrayList<Float>();

		/*

		boolean---> Boolean
		Boolean b1 = new Boolean(false);
		Boolean b2 = new Boolean(true);
		b1.booleanValue(), retorna el valor false

		*/

		ArrayList<Boolean> bb = new ArrayList<Boolean>();

	}

}
