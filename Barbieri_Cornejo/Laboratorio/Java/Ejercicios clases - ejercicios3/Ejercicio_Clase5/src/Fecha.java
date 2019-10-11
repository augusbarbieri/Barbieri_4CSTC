public class Fecha {

    //Atributos
    private int dia;
    private int mes;
    private int año;

    //Constructores

    public dia( int day, int month, int year ){
        dia = day;
        mes = month;
        año = year;
    }

    //getters

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAño(){
        return this.año;
    }

    //Setters

    public void setDia(int day){
        this.dia = day;
    }

    public void setMes(int month){
        this.mes = month;
    }

    public void setAño(int year){
        this.año = year;
    }


    //Metodos

    public void agregoDias(int dias){
        this.dia = getDia() + dias;
    }

    public void agregoMeses(int meses){
        this.mes = getMes() + meses;
    }

    public void agregoAños(int años){
        this.año = getAño() + años;
    }

    public int diferenciadias(Fecha x){
        int diff = 0;
        diff = (x.getMes - this.getMes)*30;
        diff = diff + (30 - this.getDia) + (30 - x.getDia);

        return diff;
    }

    public boolean FechasDistintas(Fecha x){
        boolean distintas= false;
        if(this.año()!=x.getAño()){
            distintas = true;
        }
        else{
            if(this.mes()!=x.getMes()){
                distintas = true;
            }
            else{
                if(this.diaa()!=x.getDia()){
                    distintas = true;
                }
                else{
                }
            }
        }
        return distintas;
    }

    public boolean FechaMenoraOtra(Fecha x){
        boolean menor= false;
        if(this.dia<x.getDia() && this.mes()<x.getMes() && this.año()<x.getAño()){
            menor= true;
        }
        return menor;
    }


}
