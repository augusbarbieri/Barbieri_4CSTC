import java.util.ArrayList;

public class Materia(){

    //Atributos
    private String Nombre;
    private ArrayList<Alumno> Lista_Alumnos = new ArrayList<Alumno>();
    private String Curso;
    private String Horarios_Cursada;
    private String Dias_Cursada;

    //Constructores
    public Materia(){
        Nombre = "Biologia";
        Curso = "1°A";
        Horarios_Cursada = "12:05 - 13:30";
        Dias_Cursada = "Martes-Jueves";
    }
    public Materia(String name, String course, String hours, String days){
        Nombre = name;
        Curso = course;
        Horarios_Cursada = hours;
        Dias_Cursada = days;
    }

    //Setters
    public void setNombre(String name){
        this.Nombre = name;
    }
    public void setCurso(String course){
        this.Curso = course;
    }
    public void setHorarios_Cursada(String hours){
        this.Horarios_Cursada = hours;
    }
    public void setDias_Cursada(String days){
        this.Dias_Cursada = days;
    }

    //Getters
    public String setNombre(String name){
        return this.Nombre = name;
    }
    public void setCurso(String course){
        return this.Curso = course;
    }
    public void setHorarios_Cursada(String hours){
        return this.Horarios_Cursada = hours;
    }
    public void setDias_Cursada(String days){
        return this.Dias_Cursada = days;
    }


    //Metodos

}
