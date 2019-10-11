/*
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
*/
import  java.util.*;

public class Ejemplo{
	public static void main(String[] args){

		ArrayList<ArrayList<Integer>> matrizA = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> filaA1 = new ArrayList<Integer>();
		ArrayList<Integer> filaA2 = new ArrayList<Integer>();
		ArrayList<Integer> filaA3 = new ArrayList<Integer>();
		for (int i = 1-1; i < 3; i++) {
			filaA1.add(i);
			filaA2.add(i);
			filaA3.add(i);
		}
		matrizA.add(filaA1);
		matrizA.add(filaA2);
		matrizA.add(filaA3);
		System.out.println(matrizA);
		//imprime: [[0, 1, 2], [0, 1, 2], [0, 1, 2]]

		ArrayList<ArrayList<Integer>> matrizB = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> filaB1 = new ArrayList<Integer>();
		ArrayList<Integer> filaB2 = new ArrayList<Integer>();
		matrizB.add(filaB1);
		matrizB.add(filaB2);
		System.out.println(matrizB);
		//imprime: [[], []]

		//---------------------------------------------------------------------//

		HashMap<String,Integer> h1 = new HashMap<String,Integer>();
		System.out.println(h1);

		h1.isEmpty(); // nos dice si está vacío o no
		h1.size(); // nos dice la cantidad de claves/valor que contiene el map
		h1.put("nombreClaveUno", 2);// agrega la clave llamada "nombreClave"  con el valor 2
		h1.put("nombreClaveDos", 123);
		h1.put("nombreClaveTres", 34);
		System.out.println(h1);
		//imprime lo siguiente: {nombreClaveTres=34, nombreClaveDos=123, nombreClaveUno=2}
		
		h1.keySet();
		System.out.println(h1.keySet());
		//imprime el conjunto de todas las claves del map: [nombreClaveTres, nombreClaveDos, nombreClaveUno]

		h1.values();
		System.out.println(h1.values());
		//imprime todos los valores del map: [34, 123, 2]

		h1.containsKey("nombreClaveUno"); // retorna true
		h1.containsKey("casa"); // retorna false
		h1.containsValue(123); // retorna true
		h1.containsValue(15); // retorna false
		System.out.println(h1.entrySet());

		h1.get("nombreClaveUno");
		System.out.println(h1.get("nombreClaveUno"));
		//retorna el valor asociado a la clave "nombreClaveUno"

		h1.put("cuaderno", 2);
		h1.put("cuaderno", 3);
		//al agregar una clave ya existente, reemplaza el valor asociado
		System.out.println(h1);

		h1.replace("cuaderno", 19);
		//reemplaza el valor asociado a "cuaderno" por el valor 19
		System.out.println(h1);
		//imprime: {nombreClaveTres=34, cuaderno=19, nombreClaveDos=123, nombreClaveUno=2}

		h1.remove("nombreClaveUno");
		//elimina la clave/valor cuya clave es "nombreClaveUno"
		System.out.println(h1);
		//imprime: {nombreClaveTres=34, cuaderno=19, nombreClaveDos=123}
		h1.clear(); //elimina todas las clave/valor del map

		//nota: los elementos del map no estarán ordenados

		/*
		fuente(api de java SE):
		https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
		 */


		//---------------------------------------------------------------------//

		HashSet<String> palabras = new HashSet<>();
		System.out.println(palabras);// imprime: []

		palabras.add("casa");
		palabras.add("perro");
		palabras.add("computadora");
		System.out.println(palabras);
		//imprime: [casa, perro, computadora]

		palabras.isEmpty();//retorna true o false según si está vacío o no
		palabras.size();// retorna la cantidad de elementos que tiene el set
		palabras.contains("casa");//retorna true o false según si está "casa" en el set
		palabras.remove("perro");//elimina el elemento "perro"
		palabras.clear();//elimina todos los elementos del set y lo deja vacío

		/*
		fuente (api de java SE):
		https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html#HashSet--
		 */

		/*
		API significa Application Programming Interface. En
		español significa interfaz de programación de aplicaciones.
		Es un conjunto de librerías Java (clases) ofrecidas por la
		compañía Oracle ya listas para que sean usadas por todos los
		desarrolladores o programadores.
		 */


	}
}