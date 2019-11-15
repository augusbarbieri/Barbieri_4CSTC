package com.company;

import java.util.HashMap;

public class Bebidasalcoholicas extends Bebida {

    //Elementos
        private int cantidadAlcohol;

        public Bebidasalcoholicas(String nombre, String apellido, int dni) {
            super(nombre, apellido, dni);
        }

        public Bebidasalcoholicas(HashMap<String, Float> listaBebidas) {
            super(listaBebidas);
        }

        public Bebidasalcoholicas(String nombre, String apellido, int dni, String nombre1, int coeficientePositividad, int coeficienteNegatividad) {
            super(nombre, apellido, dni, nombre1, coeficientePositividad, coeficienteNegatividad);
        }

        public Bebidasalcoholicas(HashMap<String, Float> listaBebidas, String nombre, int coeficientePositividad, int coeficienteNegatividad) {
            super(listaBebidas, nombre, coeficientePositividad, coeficienteNegatividad);
        }

    //Constructores

        public Bebidasalcoholicas(String nombre, String apellido, int dni, int cantidadAlcohol) {
            super(nombre, apellido, dni);
            this.cantidadAlcohol = cantidadAlcohol;
        }

        public Bebidasalcoholicas(HashMap<String, Float> listaBebidas, int cantidadAlcohol) {
            super(listaBebidas);
            this.cantidadAlcohol = cantidadAlcohol;
        }

        public Bebidasalcoholicas(String nombre, String apellido, int dni, String nombre1, int coeficientePositividad, int coeficienteNegatividad, int cantidadAlcohol) {
            super(nombre, apellido, dni, nombre1, coeficientePositividad, coeficienteNegatividad);
            this.cantidadAlcohol = cantidadAlcohol;
        }

        public Bebidasalcoholicas(HashMap<String, Float> listaBebidas, String nombre, int coeficientePositividad, int coeficienteNegatividad, int cantidadAlcohol) {
            super(listaBebidas, nombre, coeficientePositividad, coeficienteNegatividad);
            this.cantidadAlcohol = cantidadAlcohol;
        }

    //Setters

        public void setCantidadAlcohol(int cantidadAlcohol) {
            this.cantidadAlcohol = cantidadAlcohol;
        }

    //Getters

        public int getCantidadAlcohol() {
            return cantidadAlcohol;
        }

    //Metodos

}
