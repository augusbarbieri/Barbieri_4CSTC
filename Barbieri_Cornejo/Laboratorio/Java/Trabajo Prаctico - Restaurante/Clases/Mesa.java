import java.util.ArrayList;

public class Mesa{

    //Elementos
    private ArrayList<Plato> Lista_Platos = new ArrayList<Plato>();
    private boolean Ocupada;

    //Constructores
    public Mesa(){
        Ocupada = true;
    }
    public Mesa(boolean state){
        Ocupada = state;
    }

    //Setters
    public void setOcupada(boolean value) {
        this.Ocupada = value;
    }

    public void addPlatos(Plato newPlato) {

    	this.Lista_Platos.add(newPlato);
    }

    //Getters
    public boolean getOcupada(){
        return this.Ocupada;
    }

    //Metodos
    public void VaciarDesocupada(){
        if(this.Ocupada == false){
            this.Lista_Platos.clear();
        }
    }


}