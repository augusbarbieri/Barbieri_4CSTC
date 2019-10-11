public class Horario {

    // Atributos:
    private int hora;
    private int minutos;
    private  int segundos;

    // Constructores:
    public Horario() {
        hora = 12;
        minutos = 48;
        segundos = 0;
    }

    public Horario( int hour, int minutes, int secs ){
        hora = hour;
        minutos = minutes;
        segundos = secs;
    }

    public int getHora(){
        return this.hora;
    }

    public int getMinutos(){
        return this.minutos;
    }

    public int getSegundos(){
        return this.segundos;
    }

    //Setters

    public void setHora(int hour){
        this.hora = hour;
    }

    public void setMinutos(int mins){
        this.minutos = mins;
    }

    public void setSegundos(int secs){
        this.segundos = secs;
    }

    // Metodos

    public boolean esMenor(Horario p1){
        boolean esMenor = false;

        if( this.hora() < p1.hora() ){ // si la hora actual es menor estrictamente
            esMenor = true;
            return esMenor;
        }

        else if(this.hora() == p1.hora()){ // si la hora es igual comparo los minutos

            if(this.minutos() < p1.minutos()){ // si los minutos son menores estrictamente son iguales
                esMenor = true;
                return esMenor;
            }
            else if(this.minutos() == p1.minutos()){ // si los minutos son iguales comparo los segundos
                if(this.segundos() < p1.segundos()){
                    esMenor = true;
                    return esMenor;
                }
            }
        }

        else{
            return esMenor;
        }

    }

    public boolean sonIguales(Horario p1){
        boolean SonIguales = (this.hora() == p1.hora()) && (this.minutos() == p1.hora()) && (this.segundos() == p1.segundos());
        return SonIguales;
    }

}
