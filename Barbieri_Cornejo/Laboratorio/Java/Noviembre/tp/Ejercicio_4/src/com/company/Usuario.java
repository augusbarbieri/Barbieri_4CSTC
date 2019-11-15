package com.company;

import java.util.HashMap;

public class Usuario {

    //Elementos

        private String nombre;
        private String apellido;
        private int dni;
        HashMap<String, Float> listaBebidas = new HashMap<String, Float>();

    //Constructores

        public Usuario(String nombre, String apellido, int dni) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
        }

        public Usuario(HashMap<String, Float> listaBebidas) {
            this.listaBebidas = listaBebidas;
        }

    //Setters

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setDni(int dni) {
            this.dni = dni;
        }

        public void setListaBebidas(HashMap<String, Float> listaBebidas) {
            this.listaBebidas = listaBebidas;
        }

    //Getters

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public int getDni() {
            return dni;
        }

        public HashMap<String, Float> getListaBebidas() {
            return listaBebidas;
        }

    //Metodos


}
