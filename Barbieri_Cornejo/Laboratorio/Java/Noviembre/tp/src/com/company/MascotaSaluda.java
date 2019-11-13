public abstract class MascotaSaluda extends Mascota {

    //Elementos

        private String saludo;

    //Constructores

        public MascotaSaluda(String newNombre, String newDueño) {
            super(newNombre, newDueño);
        }

        public MascotaSaluda(String newNombre, String newDueño, String saludo) {
            super(newNombre, newDueño);
            this.saludo = saludo;
        }

    //Setters

        public void setSaludo(String saludo) {
            this.saludo = saludo;
        }


    //Getters

        public String getSaludo() {
            return saludo;
        }


    //Metodos



}
