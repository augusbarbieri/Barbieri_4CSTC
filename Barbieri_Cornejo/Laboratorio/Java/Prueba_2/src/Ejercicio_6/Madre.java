package Ejercicio_6;

import java.util.*;
import java.lang.String;

public class Madre extends Persona {
        private String nombreEmpresa;
        private HashSet<Hijo> conjuntoHijos = new HashSet<Hijo>();

        //Constuctores
        public Madre(String nombreEmpresa) {
            super("nombre","apellido",0,0,"sexo","ocupacion");
            nombreEmpresa = nombreEmpresa;
        }
        public Madre(){
            nombreEmpresa="Oscar.Inc";
        }
        //Getters
        public String getnombreEmpresa() {
            return nombreEmpresa;
        }
        public Set<Hijo> getconjuntoHijos() {
            return conjuntoHijos;
        }

        //Setters
        public void setnombreEmpresa(String nombreEmpresa) {
            nombreEmpresa = nombreEmpresa;
        }
        public void setconjuntoHijos(Set<Hijo> conjuntoHijos) {
            conjuntoHijos = conjuntoHijos;
        }


        //Metodos
        public HashSet<Hijo> hijosMenoresdeEdad(){
            HashSet<Hijo> menores = new HashSet<Hijo>();
            for(Hijo i : this.conjuntoHijos){
                if (i.getEdad()<18){
                    menores.add(i);
                }
            }
            return menores;

        }


}
