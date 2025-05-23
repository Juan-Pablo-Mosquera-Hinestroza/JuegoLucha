public abstract class Armas {
    protected String nombre;
    protected String descripcion;
    protected int dano;

    public Armas(String nombre, String descripcion, int dano) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dano = dano;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getDano() { return dano; }
}
