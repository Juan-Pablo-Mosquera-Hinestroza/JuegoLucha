public class Armadura {
    private final String nombre;
    private final String descripcion;
    private final int proteccion;

    public Armadura(String nombre, String descripcion, int proteccion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proteccion = proteccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getProteccion() {
        return proteccion;
    }

    @Override
    public String toString() {
        return nombre + " (" + descripcion + ", Protección: " + proteccion + ")";
    }
}
