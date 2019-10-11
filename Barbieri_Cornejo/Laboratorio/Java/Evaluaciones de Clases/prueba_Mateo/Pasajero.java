import java.util.Stack;
import java.util.ArrayList;

public class Pasajero{

    //Atributes
    private final int iDTarjeta;
    private String nombre;

    //Constructors
    public Pasajero(int id, String name){
        iDTarjeta = id;
        nombre = name;
    }

    //Setters

    public void setNombre(String name){
        this.nombre = name;
    }

    //Getters
    public int getiDTarjeta(){
        return this.iDTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    //Methods - none


}