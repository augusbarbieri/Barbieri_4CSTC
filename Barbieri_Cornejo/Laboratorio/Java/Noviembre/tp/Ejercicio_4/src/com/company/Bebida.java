package com.company;

import java.util.HashMap;

public class Bebida extends Usuario{

    //Elementos

        private String nombre;
        private int coeficientePositividad;
        private int coeficienteNegatividad;


        public Bebida(String nombre, String apellido, int dni) {
            super(nombre, apellido, dni);
        }

        public Bebida(HashMap<String, Float> listaBebidas) {
            super(listaBebidas);
        }

    //Constructores

        public Bebida(String nombre, String apellido, int dni, String nombre1, int coeficientePositividad, int coeficienteNegatividad) {
            super(nombre, apellido, dni);
            this.nombre = nombre1;
            this.coeficientePositividad = coeficientePositividad;
            this.coeficienteNegatividad = coeficienteNegatividad;
        }

        public Bebida(HashMap<String, Float> listaBebidas, String nombre, int coeficientePositividad, int coeficienteNegatividad) {
            super(listaBebidas);
            this.nombre = nombre;
            this.coeficientePositividad = coeficientePositividad;
            this.coeficienteNegatividad = coeficienteNegatividad;
        }

    //Setters

        @Override
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setCoeficientePositividad(int coeficientePositividad) {
            this.coeficientePositividad = coeficientePositividad;
        }

        public void setCoeficienteNegatividad(int coeficienteNegatividad) {
            this.coeficienteNegatividad = coeficienteNegatividad;
        }

    //Getters

        @Override
        public String getNombre() {
            return nombre;
        }

        public int getCoeficientePositividad() {
            return coeficientePositividad;
        }

        public int getCoeficienteNegatividad() {
            return coeficienteNegatividad;
        }

    //Metodos



}
