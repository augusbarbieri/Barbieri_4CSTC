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

        public MascotaSaluda(String newNombre, String newDueño, int newalegria, String saludo) {
            super(newNombre, newDueño, newalegria);
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

        numSalud = new void Scanner(System.in);
        System.out.println("Ingrese tipo de animal 1-Perro;2-Gato;3-Pajaro;4-Pez");
        numSalud = scan.nextInt();

        public void animaleSaludo(int numSalud){
            swich(num){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    bajarVida();
                    break;

            }
        }

}
