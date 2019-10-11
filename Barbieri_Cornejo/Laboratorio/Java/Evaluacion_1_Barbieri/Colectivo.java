import java.util.ArrayList;


public class Colectivo{

	//Elementos

		private int NumeroColectivo;
    	private int CantidadPasajerosTotales;	// Dato ingresado manualmente
    	private int CantidadPasajerosPagados;
    	private ArrayList<Pasajero> Lista_Pasajeros = new ArrayList<Pasajero>();
    	private Pasajero cliente;

	//Constructores

    	public Colectivo(){
        NumeroColectivo = 1;
        CantidadPasajerosTotales = 20;
        CantidadPasajerosPagados = 1;
    }

	//Setters

		public void setNumeroColectivo(int numero) {
	        this.NumeroColectivo = numero;
	    }
	    public void setCantidadPasajerosTotales(int total) {
	        this.CantidadPasajerosTotales = total;
	    }
	    public void setCantidadPasajerosPagados(int pagados) {
	        this.CantidadPasajerosPagados = pagados;
	    }

	//Getters

	    public int getNumeroColectivo(){
	        return this.NumeroColectivo;
	    }
	    public int getCantidadPasajerosTotales(){
	        return this.CantidadPasajerosTotales;
	    }
	    public int getCantidadPasajerosPagados(){
	        return this.CantidadPasajerosPagados;
	    }

	//Metodos

	    public void Cantidad_Pagados(){

	    	this.CantidadPasajerosPagados=Lista_Pasajeros.size();

	    }

	    public boolean Pagos(){

	    	boolean Pagos;

	    	if(this.CantidadPasajerosPagados==this.CantidadPasajerosTotales){

	    		Pagos=true;

	    	}

	    	else{

	    		Pagos=false;
	    	}
	    	return Pagos;
	    }

	    public boolean Colectivo_Feliz_Ordenado(){

	    	boolean ordenado;
	    	boolean primero;

	    	for(int i=0;i<this.Lista_Pasajeros.size();i++){
		    	if(this.Lista_Pasajeros.get(i).get.Pago_Correcto()==true && this.Metros_Correctos(i)==true && this.PasajeroFrecuente(i)==true){

		    		primero=true;

		    	}

		    	else{
		    		primero=false;
		    	}

	    	}

	    	if(primero == true && this.Pagos() == true){
	    		ordenado = true;
	    	}
	    	else{
	    		ordenado = false;
	    	}

	    return ordenado;

		}




}
