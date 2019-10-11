import java.util.Stack;
import java.util.ArrayList;

public class Boleto{

    //Atributes
    private Pasajero pasajero;
    private double precio;
    private double metrosPagados;
    private double metrosRecorridos;
    private double descuento;
    private boolean frecuente;

    //Constructors
    public Boleto(Pasajero x, double pagado, double recorrido, boolean frecuencia){
        pasajero = x;
        precio = 0;
        metrosPagados = pagado;
        metrosRecorridos = recorrido;
        descuento = 0;
        frecuente = frecuencia;
    }

    //Setters
    public void setPasajero(Pasajero x){
        this.pasajero = x;
    }

    public void setPrecio(double x){
        this.precio = x;
    }

    public void setMetrosPagados(double x){
        this.metrosPagados = x;
    }

    public void setMetrosRecorridos(double x){
        this.metrosRecorridos = x;
    }

    public void setDescuento(double x){
        this.descuento = x;
    }

    public void setFrecuente(boolean x){
        this.frecuente = x;
    }

    //Getters
    public Pasajero getPasajero(){
        return this.pasajero;
    }

    public double getPrecio(){
        return this.precio;
    }

    public double getMetrosPagados(){
        return this.metrosPagados;
    }

    public double getMetrosRecorridos(){
        return this.metrosRecorridos;
    }

    public double getDescuento(){
        return this.descuento;
    }

    public boolean getFrecuente(){
        return this.frecuente;
    }

    //Methods
    public void calcularDescuento(){
        if(this.frecuente == true){
            this.setDescuento(this.getMetrosPagados()/2);
        }
    }

    public void calcularPrecio(){
        double price = 0.5 * this.getMetrosPagados() - this.getDescuento();
        this.setPrecio(price);
    }

}