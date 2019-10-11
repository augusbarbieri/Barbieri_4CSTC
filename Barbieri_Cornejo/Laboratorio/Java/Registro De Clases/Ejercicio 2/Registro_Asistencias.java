import java.util.ArrayList;

public class Registro_Asistencias{

    // Atributos
    private ArrayList<Alumno> ListaAlumnos = new ArrayList<Alumno>();
    private String curso;
    private String especialidad;

    // Constructores
    public Registro_Asistencias(){
        curso = "3°CSTC";
        especialidad = "computacion";
    }
    public Materias(String course, String especialidad){
        curso = course;
        especialidad = especialidad;
    }

    // Setters
    public void setCurso(String course){
        this.curso = course;
    }
    public void setEspecialidad(String especial){
        this.especialidad = especial;
    }

    // Getters
    public String getCurso() {
        return this.curso;
    }
    public String getEspecialidad() {
        return this.especialidad;
    }

    //Metodos
    public void addAlumno(Alumno a){
        this.ListaAlumnos.add(a);
    }
    public void addAlumnoPos(int pos, Alumno a){
        this.ListaAlumnos.add(pos, a);
    }
    public Alumno getAlumno(int pos){
        return this.ListaAlumnos.get(pos);
    }
    public void deleteElements(){
        this.ListaAlumnos.clear();
    }
    public void cleanByPos(int pos){
        this.ListaAlumnos.remove(pos);
    }
    public boolean checkEmpty(){
        return this.ListaAlumnos.empty();
    }
    public boolean contieneElemento(String elemento){
        return this.ListaAlumnos.contains(elemento);
    }

    public Alumno MasFaltas(){
        Alumno Mayor = new Alumno();
        int contadorMayor = 0;
        for(int i = 0; i<this.ListaAlumnos.size(); i++){
            int contadorAlumno = 0;
            for(int j = 0; j<this.ListaAlumnos[i].lista_asistencias.size(); j++){
                if(this.ListaAlumnos[i].lista_asistencias[j] == 1){
                    contadorAlumno++;
                }
            }
            if(contadorMayor < contadorAlumno){
                contadorMayor = contadorAlumno;
                Mayor = this.ListaAlumnos[i];
            }
        }
        return Mayor;
    }
    public Alumno MenosFaltas(){
        Alumno Menor = new Alumno();
        int contadorMenor = 0;
        for(int i = 0; i<this.ListaAlumnos.size(); i++){
            int contadorAlumno = 0;
            for(int j = 0; j<this.ListaAlumnos[i].lista_asistencias.size(); j++){
                if(this.ListaAlumnos[i].lista_asistencias[j] == 0){
                    contadorAlumno++;
                }
            }
            if(contadorMenor < contadorAlumno){
                contadorMenor = contadorAlumno;
                Menor = this.ListaAlumnos[i];
            }
        }
        return Menor;
    }
    public ArrayList<Alumno> ListaDeLibres(){
        ArrayList<Alumno> ListaLibres = new ArrayList<Alumno>();
        Alumno Libre = new Alumno();
        for(int i = 0; i<this.ListaAlumnos.size(); i++){
            int contadorFaltas = 0;
            for(int j = 0; j<this.ListaAlumnos[i].lista_asistencias.size(); j++){
                if(this.ListaAlumnos[i].lista_asistencias[j] == 1){
                    contadorFaltas++;
                }
            }
            if(contadorFaltas > 15){
                Libre = this.ListaAlumnos[i];
                ListaLibres.add(Libre);
            }
        }
        return ListaLibres;
    }

}
