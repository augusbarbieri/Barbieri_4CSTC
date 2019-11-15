package com.company;

import java.util.HashMap;

public class Bebidasazucaradas extends Bebida {

    //Elementos
        private int cantidadAzucar;

        public Bebidasazucaradas(String nombre, String apellido, int dni) {
            super(nombre, apellido, dni);
        }

        public Bebidasazucaradas(HashMap<String, Float> listaBebidas) {
            super(listaBebidas);
        }

        public Bebidasazucaradas(String nombre, String apellido, int dni, String nombre1, int coeficientePositividad, int coeficienteNegatividad) {
            super(nombre, apellido, dni, nombre1, coeficientePositividad, coeficienteNegatividad);
        }

        public Bebidasazucaradas(HashMap<String, Float> listaBebidas, String nombre, int coeficientePositividad, int coeficienteNegatividad) {
            super(listaBebidas, nombre, coeficientePositividad, coeficienteNegatividad);
        }

    //Constructores

        public Bebidasazucaradas(String nombre, String apellido, int dni, int cantidadAzucar) {
            super(nombre, apellido, dni);
            this.cantidadAzucar = cantidadAzucar;
        }

        public Bebidasazucaradas(HashMap<String, Float> listaBebidas, int cantidadAzucar) {
            super(listaBebidas);
            this.cantidadAzucar = cantidadAzucar;
        }

        public Bebidasazucaradas(String nombre, String apellido, int dni, String nombre1, int coeficientePositividad, int coeficienteNegatividad, int cantidadAzucar) {
            super(nombre, apellido, dni, nombre1, coeficientePositividad, coeficienteNegatividad);
            this.cantidadAzucar = cantidadAzucar;
        }

        public Bebidasazucaradas(HashMap<String, Float> listaBebidas, String nombre, int coeficientePositividad, int coeficienteNegatividad, int cantidadAzucar) {
            super(listaBebidas, nombre, coeficientePositividad, coeficienteNegatividad);
            this.cantidadAzucar = cantidadAzucar;
        }

    //Setters

        public void setCantidadAzucar(int cantidadAzucar) {
            this.cantidadAzucar = cantidadAzucar;
        }

    //Getters

        public int getCantidadAzucar() {
            return cantidadAzucar;
        }

    //Metodos
}
