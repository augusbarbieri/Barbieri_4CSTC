public class Rectangulo {

    // Atributos
    private int altura;
    private int ancho;


    // Constructores
    public Rectangulo(){
        altura = 3;
        ancho = 5;
    }

    public Rectangulo(int alturaEquis){
        altura = alturaEquis;
        ancho = 15;
    }

    public Rectangulo(int alturaEquis, int anchoEquis){
        altura = alturaEquis;
        ancho = anchoEquis;
    }


    // Métodos
    public int getAltura(){
        return this.altura;
    }

    public int getAncho(){
        return this.ancho;
    }

    public void setAltura(int alturaEquis){
        this.altura = alturaEquis;
    }

    public void setAncho(int anchoEquis){
        this.ancho = anchoEquis;
    }

    public boolean alturasIguales(Rectangulo rec2){
        boolean sonIguales = this.getAltura() == rec2.getAltura();

        return sonIguales;
    }

    public boolean anchosIguales(Rectangulo rec2){
        boolean sonIguales = this.getAncho() == rec2.getAncho();

        return sonIguales;
    }

    public boolean sonIguales(Rectangulo rec2){
        boolean sonIguales = this.getAltura() == rec2.getAltura() &&
                this.getAncho() == rec2.getAncho();
        return sonIguales;
    }
}
