package Ejercicio_7;

public class Editorial1 {

    public enum Editorial {
        KAPELUSZ("Kapelusz"), SUDAMERICANA("Sudamericana"), ATLANTIDA("Atlantida"), ELATENEO("El Ateneo"),
        INTERZONA("Interzona"), SURYALIANZA("Sur y Alianza");

        private String nombre;

        private Editorial(String newNombre) {

            this.nombre = newNombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

}
