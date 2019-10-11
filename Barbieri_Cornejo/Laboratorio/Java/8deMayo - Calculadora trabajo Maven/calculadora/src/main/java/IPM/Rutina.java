package IPM;

import java.util.ArrayList;
import java.util.Stack;

public class Rutina{

    //Atributos
    private ArrayList<Instruccion> list_Insts;
    private String nombre;

    //Constructores
    public Rutina(){
    	list_Insts = new ArrayList<Instruccion>();
    	nombre = "RutinaA";
    }

    public Rutina(String name){
    	list_Insts = new ArrayList<Instruccion>();
    	nombre = name;
    }

    //Setters
    public void setNombre(String x){
    	this.nombre = x;
    }

    //Getters
    public String getNombre(){
    	return this.nombre;
    }

    //Metodos


    public ArrayList<Instruccion> getList_Insts() {
        return list_Insts;
    }

    public void addInstruccion(Instruccion x){
    	this.list_Insts.add(x);
    }

    public void addInstruccionPos(int pos, Instruccion x){
    	this.list_Insts.add(pos,x);
    }

    public boolean checkEmpty(){
    	boolean vacio;
    	vacio = this.list_Insts.isEmpty();
    	return vacio;
    }

}
