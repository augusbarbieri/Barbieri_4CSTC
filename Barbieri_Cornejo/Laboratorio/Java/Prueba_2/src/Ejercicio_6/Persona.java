package Ejercicio_6;

public class Persona {

        private String nombre;
        private String apellido;
        private int edad;
        private int dni;
        private String sexo;
        private String ocupacion;


        //Constructores

        public Persona(String nombre, String apellido, int edad, int dni, String sexo, String ocupacion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.dni = dni;
            this.sexo = sexo;
            this.ocupacion = ocupacion;
        }
        public Persona(){
            nombre="Augusto";
            apellido="Barbieri";
            edad=17;
            dni=44159050;
            sexo="Masculino";
            ocupacion="Pediatra";
        }


        //Setters
        public void setNombre (String nombre){
            this.nombre = nombre;
        }
        public void setApellido (String apellido){
            this.apellido = apellido;
        }
        public void setEdad ( int edad){
            this.edad = edad;
        }
        public void setDni ( int dni){
            this.dni = dni;
        }
        public void setSexo (String sexo){
            this.sexo = sexo;
        }
        public void setOcupacion (String ocupacion){
            this.ocupacion = ocupacion;
        }

        //Getters
        public String getNombre () {
            return this.nombre;
        }
        public String getApellido () {
            return this.apellido;
        }
        public int getEdad () {
            return this.edad;
        }
        public int getDni () {
            return this.dni;
        }
        public String getSexo () {
            return this.sexo;
        }
        public String getOcupacion () {
            return this.ocupacion;
        }

        //Metodos
        public boolean mayorEdad() {
            boolean resultado = false;
            if (this.getEdad() >= 18) {
                resultado = true;
            }
            else{
            }
            return resultado;
        }

        public boolean letraA() {
            boolean verificar = false;
            char[] arregloNombre = this.nombre.toCharArray();
            if ((arregloNombre[0] == 'a') || (arregloNombre[0] == 'A')) {
                verificar = true;
            }
            return verificar;
        }

        public boolean dniMenor() {
            boolean verificador = false;
            if (this.getDni() < 38000000) {
                verificador = true;
            }
            else{
            }
            return verificador;
        }

        public void imprimirDatos(){
            System.out.println("Nombre: "+this.getNombre());
            System.out.println("Apellido: "+this.getApellido());
            System.out.println("Edad: "+this.getEdad());
            System.out.println("Dni: "+this.getDni());
            System.out.println("Sexo: "+this.getSexo());
            System.out.println("Ocupacion: "+this.getOcupacion());

        }

}
