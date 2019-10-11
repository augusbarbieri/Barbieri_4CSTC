public class Persona {

    // 1) Atributos

    private String nombre;
    private int edad;
    private int dni;
    private int telefono;
    private String direccion;

    // Constructores

    public Persona(){
        nombre = "Vacío";
        edad = 18;
        dni = 0;
        telefono = 0;
        direccion = "nula";
    }

    public Persona(String Nombre){
        nombre = Nombre;
        edad = 18;
        dni = 0;
        telefono = 0;
        direccion = "nula";
    }

    public Persona(String name, int age, int DNI, int number, String dir){
        nombre = name;
        edad = age;
        dni = DNI;
        telefono = number;
        direccion = dir;
    }

        // Getters

        public String getnombre(){ // devuelve el valor de la altura
            return this.nombre;
        }

        public int getedad(){
            return this.edad;
        }

        public int getdni(){
            return this.dni;
        }

        public int gettelefono(){
            return this.telefono;
        }

        public String getdireccion(){
            return this.direccion;
        }

        // Setters

        public void setEdad(int edadX) {
        this.edad = edadX;
        }

        public void setTelefono(int telefonoX) {
            this.telefono = telefonoX;
        }

        public void setNombre(String nombreX) {
            this.nombre = nombreX;
        }

        public void setDni(int dniX) {
            this.dni = dniX;
        }

        public void setDireccion(String direccionX) {
            this.direccion = direccionX;
        }

    // 2) Metodos

        public boolean esMayordeEdad(){
            boolean esMayor = this.getedad()  >= 18;
            return esMayor;
        }
        public boolean sonLaMismaPersona(Persona p1){
            boolean Sonlamisma = this.getdni() == p1.getdni();
            return Sonlamisma;
        }

        public boolean tienenLaMismaEdad(Persona p1){
            boolean mismaedad = this.getedad() == p1.getedad();
            return mismaedad;
        }

        public boolean tienenMismoNombre(Persona p1){
            boolean MismoNombre = this.getnombre() == p1.getnombre();
            return MismoNombre;
        }

        public boolean tienenmismotelefono(Persona p1){
            boolean Mismotelefono = this.gettelefono() == p1.gettelefono();
            return Mismotelefono;
        }


}
