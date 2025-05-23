public abstract class Proteccion {
    protected String nombre;
    protected String descripcion;
    protected int proteccion;

    public Proteccion(String nombre, String descripcion, int proteccion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proteccion = proteccion;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getProteccion() { return proteccion; }
}
