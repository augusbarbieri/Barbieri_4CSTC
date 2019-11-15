public class Pez extends MascotaNoSaluda{


    //Elementos

    private int vidas=10;

    //Constructores

        public Pez(String newNombre, String newDueño) {
            super(newNombre, newDueño);
        }

        public Pez(String newNombre, String newDueño, int newVidas) {
            super(newNombre, newDueño);
            this.vidas = newVidas;
        }

    //Setters

        public void setVidas(int vidas) {
            this.vidas = vidas;
        }

    //Getters

        public int getVidas() {
            return vidas;
        }

    //Metodos


    public void bajarVida(String nombre){
        if(this.getNombreDueño().equals(nombre);) {
            this.vidas=this.vidas-1;

        }
        else
            this.vidas=0;
    }






}
