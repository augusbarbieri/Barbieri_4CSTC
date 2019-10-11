import java.util.ArrayList;

public class Alumno{

    // Atributos
    private ArrayList<Integer> lista_asistencias = new ArrayList<Integer>();
    private String nombre;
    private String apellido;

    // Constructores
    public Alumno(){
        nombre = "Matias";
        apellido = "Gutierrez";
    }
    public Alumno(String name, String surname){
        nombre = name;
        apellido = surname;
    }

    // Setters
    public void setNombre(String name){
        this.nombre = name;
    }
    public void setApellido(String surname){
        this.apellido = surname;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }

    //Metodos
    public void addAsist(int asistencia){
        this.lista_asistencias.add(asistencia);
    }
    public void addAssistPos(int pos, int asistencia){
        this.lista_asistencias.add(pos, asistencia);
    }
    public int getElement(int pos){
        return this.lista_asistencias.get(pos);
    }
    public void deleteElements(){
        this.lista_asistencias.clear();
    }
    public void cleanByPos(int pos){
        this.lista_asistencias.remove(pos);
    }
    public boolean checkEmpty(){
        return this.lista_asistencias.empty();
    }

}
