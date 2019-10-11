import java.util.ArrayList;

public class Materias{

	// Atributos
	private ArrayList<clasesVistas> ListaClasesVistas = new ArrayList<clasesVistas>();
	private String profesor;
	private String horario;

	// Constructores
	public Materias(){
		profesor = "Matias";
		horario = "12:05";
	}
	public Materias(String profe, String hora){
		profesor = profe;
		horario = hora;
	}

	// Setters
	public void setProfesor(String profe){
		this.profesor = profe;
	}
	public void setHorario(String hora){
		this.horario = hora;
	}

	// Getters
	public String getProfesor(){
		return this.profesor;
	}
	public String getHorario(){
		return this.horario;
	}

	//Metodos
	public void addClasesVistas(clasesVistas clase){
        this.ListaClasesVistas.add(clase)
    }
	public void addClasesVistasPos(int pos, int asistencia){
		this.ListaClasesVistas.add(pos, asistencia);
	}
	public clasesVistas getElement(int pos){
		return this.lista_asistencias.get(pos);
	}
	public void deleteElements(){
		this.ListaClasesVistas.clear();
	}
	public void cleanByPos(int pos){
		this.ListaClasesVistas.remove(pos);
	}
	public boolean checkEmpty(){
		return this.ListaClasesVistas.empty();
	}

}
