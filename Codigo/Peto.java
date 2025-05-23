public class Peto extends Proteccion {
    public enum TipoPeto {
        PESADA, LIGERA, COTA_DE_MALLA, DE_METAL
    }
    private TipoPeto tipo;

    public Peto(String nombre, String descripcion, int proteccion) {
        super(nombre, descripcion, proteccion);
        this.tipo = getTipoFromNombre(nombre);
    }

    private TipoPeto getTipoFromNombre(String nombre) {
        switch (nombre.toLowerCase()) {
            case "pesada": return TipoPeto.PESADA;
            case "ligera": return TipoPeto.LIGERA;
            case "cota de malla": return TipoPeto.COTA_DE_MALLA;
            case "de metal": return TipoPeto.DE_METAL;
            default: return null;
        }
    }

    public TipoPeto getTipo() {
        return tipo;
    }
}
