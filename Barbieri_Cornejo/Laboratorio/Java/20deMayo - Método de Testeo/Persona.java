public class Persona {

    public String nombre;
    public int edad;

    public Persona(){
        nombre = "Roberto";
        edad = 44;
    }

    public boolean sonIguales(Persona p2){
        boolean siSonIguales = this.nombre == p2.nombre && this.edad == p2.edad;

        return  siSonIguales;
    }
}
