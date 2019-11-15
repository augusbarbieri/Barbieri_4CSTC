package com.company;

import java.util.HashMap;

public class Bebidasneutras extends Bebida {

    //Elementos
        public Bebidasneutras(String nombre, String apellido, int dni) {
            super(nombre, apellido, dni);
        }

        public Bebidasneutras(HashMap<String, Float> listaBebidas) {
            super(listaBebidas);
        }

        public Bebidasneutras(String nombre, String apellido, int dni, String nombre1, int coeficientePositividad, int coeficienteNegatividad) {
            super(nombre, apellido, dni, nombre1, coeficientePositividad, coeficienteNegatividad);
        }

        public Bebidasneutras(HashMap<String, Float> listaBebidas, String nombre, int coeficientePositividad, int coeficienteNegatividad) {
            super(listaBebidas, nombre, coeficientePositividad, coeficienteNegatividad);
        }


    //Constructores



    //Setters

    //Getters

    //Metodos


}
