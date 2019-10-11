public class Empleado extends Persona {

    private String ocupacion;

    public Empleado(){
        super(34);
    }

    public Empleado(String nombre){
        super(nombre);
        this.ocupacion = "ingeniero";
    }

    public boolean puedeVotar(){ 
    	return super.esMayorDeEdad();

    }

    public static void main(String[] args){
        Empleado e1 = new Empleado("Roberto");
        Empleado e2 = new Empleado();

    }
}
