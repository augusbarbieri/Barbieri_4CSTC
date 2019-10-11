package Ejercicio_6;

public class Hijo extends Persona {


        private String NombreColegio;
        private String JuegoFavorito;


        //Constructores

        public Hijo(String nombreColegio, String juegoFavorito) {
            NombreColegio = nombreColegio;
            JuegoFavorito = juegoFavorito;
        }

        public Hijo(){
            super("nombre","apellido",0,0,"sexo","ocupacion");
            NombreColegio = "Poli";
            JuegoFavorito = "Minecraft";
        }


        //Getters

        public String getNombreColegio() {
            return NombreColegio;
        }

        public String getJuegoFavorito() {
            return JuegoFavorito;
        }


        //Setters

        public void setNombreColegio(String nombreColegio) {
            NombreColegio = nombreColegio;
        }

        public void setJuegoFavorito(String juegoFavorito) {
            JuegoFavorito = juegoFavorito;
        }


        //Metodos

        public void imprimirMetodos(){
                    super.imprimirDatos();
                    System.out.println("Escuela a la que asiste: "+this.getNombreColegio());
                    System.out.println("Juego favorito: "+this.getJuegoFavorito());
        }


}



