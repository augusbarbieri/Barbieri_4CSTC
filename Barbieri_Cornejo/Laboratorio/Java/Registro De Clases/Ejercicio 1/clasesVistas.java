import java.util.ArrayList;

public class clasesVistas{

	// Atributos
	private ArrayList<String> listaTemas = new ArrayList<String>();
	private int dia;
	private int mes;
	private int numerodeclase;

	// Constructores
	public clasesVistas(){
		dia = 1;
		mes = 7;
		numerodeclase = 1;
	}
	public clasesVistas(int day, int month, int numero){
		dia = day;
		mes = month;
		numerodeclase = numero;
	}

	// Setters
	public void setDia(String diaX){
		this.dia = diaX;
	}
	public void setMes(String mesX){
		this.mes = mesX;
	}
	public void setNumeroDeClase(String numeroX){
		this.numerodeclase = numeroX;
	}

	// Getters
	public String getDia(){
		return this.dia;
	}
	public String getMes(){
		return this.mes;
	}
	public String getNumeroDeClase(){
		return this.numerodeclase;
	}

	// Metodos
	public void addTema(String tema){
        this.listaTemas.add(tema);
    }
    public boolean contieneElemento(String elemento){
		return this.listaTemas.contains(elemento);
	}
	public void deleteElements(){
		this.listaTemas.clear();
	}
	public boolean checkEmpty(){
		return this.listaTemas.empty();
	}

}