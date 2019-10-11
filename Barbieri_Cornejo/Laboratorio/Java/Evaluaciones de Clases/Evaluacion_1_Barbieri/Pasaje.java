import java.util.ArrayList;


public class Pasaje{

	//Elementos

		private double MetrosPagados;		// Metros que el cliente dijo que iba a recorrer
    	private double MetrosRecorridos;	// Metros que en realidad recorrio (dato que viene del cielo)
    	private double PlataPagada;		// Plata que abono por su viaje
    	private double PlataReal;		// Plata que deberia haber abonado por su viaje

	//Constructores

    	public Pasaje(){
        MetrosPagados = 15;
        MetrosRecorridos = 20;
        PlataPagada = 100;
        PlataReal = 200;
    }

	//Setters

		public void setMetrosPagados(double metropago) {
	        this.MetrosPagados = metropago;
	    }
	    public void setMetrosRecorridos(double metrorecorri) {
	        this.MetrosRecorridos = metrorecorri;
	    }
	    public void setPlataPagada(double platapag) {
	        this.PlataPagada = platapag;
	    }
	    public void setPlataReal(double platarea) {
	        this.PlataReal = platarea;
	    }

	//Getters

	    public double getMetrosPagados(){
	        return this.MetrosPagados;
	    }
	    public double getMetrosRecorridos(){
	        return this.MetrosRecorridos;
	    }
	    public double getPlataPagada(){
	        return this.PlataPagada;
	    }
	    public double getPlataReal(){
	        return this.PlataReal;
	    }

	//Metodos

	    public void Descuento(){
	    	if (this.cliente.PasajeroFrecuente() == true){

	    		this.PlataPagada = this.PlataPagada / 2;
	    	}
	    }

	    public void Plata_Real_A_Pagar(){
	    	if(this.cliente.PasajeroFrecuente()== true)	{

	    	this.PlataReal=(this.MetrosPagados * 0.50) / 2;

	    	 }
	    	 else{
	    	 	this.PlataPagada=this.MetrosPagados * 0.50;
	    	 }
	    }

	    public void Plata_Abonada(){
			if(this.cliente.PasajeroFrecuente()== true)	{

	    	this.PlataReal=(this.MetrosRecorridos * 0.50) / 2;

	    	 }
			else{
				this.PlataReal=this.MetrosRecorridos * 0.50;
			}
	    }

	    public boolean Pago_Correcto(){

	    	boolean Pago_Correcto;

	    	if(this.PlataReal == this.PlataPagada){

	    		Pago_Correcto=true;

	    	}

	    	else{

	    		Pago_Correcto=false;
	    	}

	    	return Pago_Correcto;

	    }

	    public boolean Metros_Correctos(){

	    	boolean Metros_Correctos;

	    	if(this.MetrosRecorridos==this.MetrosPagados){

	    		Metros_Correctos=true;
	    	}

	    	else{

	    		Metros_Correctos=false;

	    	}
	    	return Metros_Correctos;
	    }



}
