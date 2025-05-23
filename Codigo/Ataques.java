public abstract class Ataques {
    protected String nombre;
    protected String descripcion;
    protected int danoBase;
    protected double probCritico;
    protected double multiplicadorCritico;

    public Ataques(String nombre, String descripcion, int danoBase, double probCritico, double multiplicadorCritico) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.danoBase = danoBase;
        this.probCritico = probCritico;
        this.multiplicadorCritico = multiplicadorCritico;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getDanoBase() { return danoBase; }
    public double getProbCritico() { return probCritico; }
    public double getMultiplicadorCritico() { return multiplicadorCritico; }
}
