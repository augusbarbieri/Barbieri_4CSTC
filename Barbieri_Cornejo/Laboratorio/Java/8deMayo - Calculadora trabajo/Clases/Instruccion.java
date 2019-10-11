import java.util.ArrayList;
import java.util.Stack;

public class Instruccion{

    //Atributos
    private String nombreInstruccion;
    private String nombreVariable;

    //Constructores
    public Instruccion(){
    	nombreInstruccion = "";
    	nombreVariable = "";
    }

    public Instruccion(String instName, String varName){
    	nombreInstruccion = instName;
    	nombreVariable = varName;
    }

    //Setters
    public void setNombreInstruccion(String x){
    	this.nombreInstruccion = x;
    }

    public void setNombreVariable(String x){
    	this.nombreVariable = x;
    }

    //Getters
    public String getNombreInstruccion(){
    	return this.nombreInstruccion;
    }

    public String getNombreVariable(){
    	return this.nombreVariable;
    }

    //Metodos


}
