package Ejercicio_7;

public class Libro {
    private String nombre;
    private double precio;
    private Editorial1 editorial;


    public Libro() {

        this.nombre = "Viaje al centro de la tierra";
        this.precio = 478;
        this.editorial = Editorial1.ELATENEO;
    }

    public Libro(String newNombre, double newPrecio, Editorial1 newEditorial) {

        this.nombre = newNombre;
        this.precio = newPrecio;
        this.editorial = newEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Editorial1 getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial1 editorial) {
        this.editorial = editorial;
    }


}
