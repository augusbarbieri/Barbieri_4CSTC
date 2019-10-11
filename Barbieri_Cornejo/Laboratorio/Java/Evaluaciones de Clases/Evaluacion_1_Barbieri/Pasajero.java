import java.util.ArrayList;


public class Pasajero{

	//Elementos

		private String NombrePasajero;
    	private int IdTarjeta;
    	private int CantidadViajes;
    	private Pasaje boleto;

	//Constructores

    	public Pasajero(){
        NombrePasajero = "Valen Gottelli";
        IdTarjeta = 1;
        CantidadViajes = 7;
    }


	//Setters

		public void setNombrePasajero(String nombre) {
	        this.NombrePasajero = nombre;
	    }
	    public void setIdPasajero(int identificacion) {
	        this.IdTarjeta = identificacion;
	    }
	    public void setCantidadViajes(int viajestotales) {
	        this.CantidadViajes = viajestotales;
	    }

	//Getters

		public String getNombrePasajero(){
	        return this.NombrePasajero;
	    }
	    public int getsetIdTarjeta(){
	        return this.IdTarjeta;
	    }
	    public int getCantidadViajes(){
	        return this.CantidadViajes;
	    }


	//Metodos

	    public boolean PasajeroFrecuente(){

	    	boolean PasajeroFrecuente;

	    	if (this.getCantidadViajes() >= 25){

	    		PasajeroFrecuente = true;

	    	}

	    	else{

	    		PasajeroFrecuente = false;
	    	}

	    	return PasajeroFrecuente;

	    }



}


