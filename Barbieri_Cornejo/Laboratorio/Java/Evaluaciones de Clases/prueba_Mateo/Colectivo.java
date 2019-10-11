import java.util.Stack;
import java.util.ArrayList;

public class Colectivo{

    //Atributes
    private int colectivoID;
    private ArrayList<Boleto> boletosTotales;  //boletos de toda la historia
    private ArrayList<Boleto> boletosActuales; //boletos pagados del momento
    private boolean orden;
    private int presentes; //pasajeros presentes en el colectivo

    //Constructors
    public Colectivo(int iD, boolean estado, int cantidad){
        colectivoID = iD;
        boletosTotales = new ArrayList<Boleto>();
        boletosActuales = new ArrayList<Boleto>();
        orden = estado;
        presentes = cantidad;
    }

    //Setters
    public void setOrden(boolean estado){
        this.orden = estado;
    }

    //Gettters
    public boolean getOrden(){
        return this.orden;
    }

    public int getPresentes(){
        return this.presentes;
    }

    //Methods


    public ArrayList<Boleto> getBoletosTotales() {
        return this.boletosTotales;
    }

    public ArrayList<Boleto> getBoletosActuales() {
        return this.boletosActuales;
    }

    public void addBoletosTotales(Boleto x){
        this.boletosTotales.add(x);
    }

    public void addBoletosActuales(Boleto x){
        this.boletosActuales.add(x);
    }

    public boolean boletosPagados(){
        boolean concuerda;
        if(this.boletosActuales.size() == this.presentes){
            concuerda = true;
        }
        else{
            concuerda = false;
        }
        return concuerda;
    }

    public boolean metrosCorrectos(){
        boolean correcto = false;
        int largo = this.boletosActuales.size();
        for(int i=0; i<largo; i++){
            if(this.boletosActuales.get(i).getMetrosPagados() >= this.boletosActuales.get(i).getMetrosRecorridos()){
                correcto = true;
            }
            else{
                correcto = false;
            }
            if(correcto == false){
                break;
            }
        }
        return correcto;
    }

    public boolean descAplicado(){
        boolean hecho = false;
        int largo = this.boletosActuales.size();
        for(int i=0; i<largo; i++){
            if(this.boletosActuales.get(i).getFrecuente() == true && this.boletosActuales.get(i).getDescuento()>0){
                hecho = true;
            }
            else{
                hecho = false;
            }
            if(hecho == false){
                break;
            }
        }
        return hecho;
    }

    public boolean estaEnOrden(){
    	boolean correcto = false;
    	if(this.boletosPagados()==true && this.metrosCorrectos()==true && this.descAplicado()==true){
    		correcto = true;
    	}
    	return correcto;
    }

    public void pasajeroFrecuente(int tarjeta){
        boolean frecuente = false;
        int igual = 0;
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        for(int i=0; i<this.boletosTotales.size(); i++){
            if(this.boletosTotales.get(i).getPasajero().getiDTarjeta() == tarjeta){
                igual = igual +1;
                posiciones.add(i);
            }
        }
        if(igual >= 25){
            frecuente = true;
            for(int i=0; i<posiciones.size(); i++){
                this.boletosTotales.get(posiciones.get(i)).setFrecuente(frecuente);
            }
        }
    }

}
