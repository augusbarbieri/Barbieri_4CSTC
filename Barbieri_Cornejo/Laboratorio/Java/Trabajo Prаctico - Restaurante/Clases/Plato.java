import java.util.ArrayList;

public class Plato{

    //Elementos
    private String Nombre;
    private int NumeroDeMesa;
    private int NumeroDePedido;
    private int Cantidad;

    //Constructores
    public Plato(){
        Nombre = "Fideos con salsa bolognesa";
        NumeroDeMesa = 0;
        NumeroDePedido = 7;
        Cantidad = 1;
    }
    public Plato(String name, int table, int order, int amount){
        Nombre = name;
        NumeroDeMesa = table;
        NumeroDePedido = order;
        Cantidad = amount;
    }

    //Setters
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public void setNumeroDeMesa(int numeroDeMesa) {
        this.NumeroDeMesa = numeroDeMesa;
    }
    public void setNumeroDePedido(int numeroDePedido) {
        this.NumeroDePedido = numeroDePedido;
    }
    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }

    //Getters
    public String getNombre(){
        return this.Nombre;
    }
    public int getNumeroDeMesa(){
        return this.NumeroDeMesa;
    }
    public int getNumeroDePedido(){
        return this.NumeroDePedido;
    }
    public int getCantidad(){
        return this.Cantidad;
    }

    //Metodos - Ninguno

}