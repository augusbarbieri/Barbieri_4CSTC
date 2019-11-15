import java.util.ArrayList;

public class Mascota {

    //Elementos

        private String nombre;
        private String nombreDueño;
        private int alegria;

        boolean aceptarNom = false;


    //Constructores

        public Mascota(String newNombre, String newDueño,int newalegria) {
            nombre = newNombre;
            nombreDueño = newDueño;
            alegria = newalegria;
        }

        public Mascota(String newNombre, String newDueño) {
        }


    //Setters

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setNombreDueño(String nombreDueño) {
            this.nombreDueño = nombreDueño;
        }

        public void setAlegria(int alegria) {
            this.alegria = alegria;
        }

    //Getters

        public String getNombre() {
            return nombre;
        }

        public String getNombreDueño() {
            return nombreDueño;
        }

        public int getAlegria() {
            return alegria;
        }


    //Metodos






}
