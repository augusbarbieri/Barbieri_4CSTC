package Ejercicio_7;

import java.util.HashMap;

public class Libreria {
    private HashMap<Editorial1, Integer> vendidos = new HashMap<Editorial1, Integer>();


        //Metodos

    public Editorial1 masVendido() {

        Editorial1[] editoriales = Editorial1.values();
        Editorial1 masVendida = editoriales[0];
        for(int i = 1; i < editoriales.length; i++) {
            if(this.vendidos.get(masVendida) < this.vendidos.get(editoriales[i])) {

                masVendida = editoriales[i];
            }
        }
        System.out.println(masVendida.getnombre() + " con " + this.vendidos.get(masVendida) + " ventas");
        return masVendida;
    }
}