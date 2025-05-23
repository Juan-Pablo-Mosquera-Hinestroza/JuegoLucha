public class Arma {
    private final String nombre;
    private final String descripcion;
    private final int daño;

    public Arma(String nombre, String descripcion, int daño) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.daño = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDaño() {
        return daño;
    }

    public int getDano() {
        return getDaño();
    }

    @Override
    public String toString() {
        return nombre + " (" + descripcion + ", Daño: " + daño + ")";
    }
}
