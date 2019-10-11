import java.util.ArrayList;
import java.util.Stack;

public class Variable{

    //Atributos
    private String nombre;
    private int valor;

    //Constructores
    public Variable(){
    	nombre = "x";
    	valor = 1;
    }

    public Variable(String name, int x){
    	nombre = name;
    	valor = x;
    }

    //Setters
    public void setNombre(String name){
    	this.nombre = name;
    }

    public void setValor(int x){
    	this.valor = x;
    }

    //Getters
    public String getNombre(){
    	return this.nombre;
    }

    public int getValor(){
    	return this.valor;
    }

    //Metodos


}
