import java.util.ArrayList;

public class Alumno{

    // Atributos
    private ArrayList<Integer> lista_de_notas = new ArrayList<Integer>();
    private String Nombre;
    private String Apellido;

    // Constructores
    public Alumno(){
        Nombre = "Sabrina";
        Apellido = "Gutierrez";
    }
    public Alumno(String name, String surname){
        Nombre = name;
        Apellido = surname;
    }

    // Setters
    public void setNombre(String name){
        this.Nombre = name;
    }
    public void setApellido(String surname){
        this.Apellido = surname;
    }

    // Getters
    public String getNombre() {
        return this.Nombre;
    }
    public String getApellido() {
        return this.Apellido;
    }

    //Metodos
    public void addNotas(int nota){
        this.lista_de_notas.add(nota);
    }
    public void addNotaPos(int pos, int nota){
        this.lista_de_notas.add(pos, nota);
    }
    public int getNota(int pos){
        return this.lista_de_notas.get(pos);
    }
    public void deleteNotas(){
        this.lista_de_notas.clear();
    }
    public void cleanByPos(int pos){
        this.lista_de_notas.remove(pos);
    }
    public boolean checkEmpty(){
        return this.lista_de_notas.empty();
    }
    public boolean contieneElemento(int elemento){
        return this.lista_de_notas.contains(elemento);
    }

}
