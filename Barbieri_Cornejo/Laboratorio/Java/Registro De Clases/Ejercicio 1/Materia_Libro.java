import java.util.ArrayList;

public class LibroMaterias{

	// Atributos
	private Materias[] ListaMaterias = new ListaMaterias[14];
	private String curso;

	// Constructores
	public LibroMaterias(){
		curso = "1A";
	}
	public LibroMaterias(String cursoX){
		curso = cursoX;
	}

	// Setters
	public void setCurso(String cursoX){
		this.curso = cursoX;
	}

	// Getters
	public String getCurso(){
		return this.curso;
	} 

	//Metodos
	public void addMateria(int i,Materias nueva){
        this.ListaMaterias[i] = nueva;
    }

}