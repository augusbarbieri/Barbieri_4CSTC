public class Persona {

    private String nombre;
    private int edad;
    protected int dni;

    public Persona(){

    }

    public Persona(int edad){
        this("Carolina");
        this.edad = e dad;
    }


    public Persona(String nombre){
        this.nombre = nombre;
        this.edad = 56;
        this.dni = 12345678;

    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }
}
