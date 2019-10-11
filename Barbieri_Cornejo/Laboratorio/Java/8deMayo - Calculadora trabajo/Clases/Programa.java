import java.util.ArrayList;
import java.util.Stack;

public class Programa{

    //Atributos
    private ArrayList<Rutina> listRutinas;

    //Constructores
    public Programa(){
    	listRutinas = new ArrayList<Rutina>();
    }

    //Setters


    //Getters


    public ArrayList<Rutina> getListRutinas() {
        return listRutinas;
    }

    //Metodos
    public void addRutina(Rutina x){
    	this.listRutinas.add(x);
    }

    public void addRutinaPos(int pos, Rutina x){
    	this.listRutinas.add(pos,x);
    }

    public boolean checkEmpty(){
    	boolean vacio;
    	vacio = this.listRutinas.isEmpty();
    	return vacio;
    }

}