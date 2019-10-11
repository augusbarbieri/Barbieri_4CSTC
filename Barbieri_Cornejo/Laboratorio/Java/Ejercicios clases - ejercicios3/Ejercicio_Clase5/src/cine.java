public class cine{

    // atributos

    private int entrada;
    private int cant_salas;
    private String zona;
    private int cantidad_peliculas;

    // Constructor

    public cine(){
        entrada_precio= 125;
        cant_salas = 5
         zona = "urquiza";
        cantidad_peliculas=8;
    }

    // Getters

    public int getCant_salas() {
        return this.cant_salas;
    }

    public int getCantidad_peliculas() {
        return this.cantidad_peliculas;
    }

    public int getEntrada() {
        return this.entrada_precio;
    }

    public String getZona() {
        return this.zona;
    }

    // Setters

    public void setCant_salas(int cant_salas) {
        this.cant_salas = cant_salas;
    }

    public void setCantidad_peliculas(int cantidad_peliculasx) {
        this.cantidad_peliculas = cantidad_peliculasx;
    }

    public void setEntrada_precio(int entrada_preciox) {
        this.entrada_precio = entrada_preciox;
    }

    public void setZona(String zonax) {
        this.zona = zonax;
    }

    // Metodos

    public boolean sonIguales(cine c1) {
       if(this.getCant_salas()=c1.getCant_salas() && this.getCantidad_peliculas()=c1.getCantidad_peliculas() && this.getEntrada()=c1.getEntrada() && this.getZona()=c1.getZona()){
           return true;
       }
    }

    public boolean entrada125(cine c1){
        if( c1.getEntrada()==125){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cantidadsalas_peliculas(cine c1){

        if(c1.getCantidad_peliculas()==c1.getCant_salas()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean mismaZona(cine c1){
        if(this.getZona()==c1.getZona(){
            return true;
        }
        else{
            return false;
        }

    }

}