
public class Rectangulo {


    // Atributos
    private int altura;
    private int ancho;
    

    // Constructores
    public Rectangulo(){ // altura y ancho declarados
        altura = 3;
        ancho = 5;
    } 

    public Rectangulo(int alturaEquis){ // ingresa por parametro una altura, se declara ancho
        altura = alturaEquis;
        ancho = 15;
    }
    
    public Rectangulo(int alturaEquis, int anchoEquis){ // ancho y altura se ingresan por parametro
        altura = alturaEquis;
        ancho = anchoEquis;
    }

    // Métodos
    public int getAltura(){ // devuelve el valor de la altura
        return this.altura;
    }
    
    public int getAncho(){ // devuelve valor del ancho
        return this.ancho;
    } 
    
    public void setAltura(int alturaEquis){ // cambia el valor de la altura se cambia por uno por parametro
        this.altura = alturaEquis;
    }
    
    public void setAncho(int anchoEquis){ // cambia el valor del ancho se cambia por uno por parametro
        this.ancho = anchoEquis;
    }           

    public boolean alturasIguales(Rectangulo rec2){ // compara si la altura del objeto es igual a la ingresada por parametro
        boolean sonIguales = this.getAltura() == rec2.getAltura();

        return sonIguales;
    }

    public boolean anchosIguales(Rectangulo rec2){// compara si el ancho del objeto es igual a la ingresada por parametro
        boolean sonIguales = this.getAncho() == rec2.getAncho();

        return sonIguales;
    }

    public boolean sonIguales(Rectangulo rec2){  // compara si el objeto actual y el ingresado por parametro son iguales
        boolean sonIguales = this.getAltura() == rec2.getAltura() && this.getAncho() == rec2.getAncho();
        return sonIguales;
    }
}