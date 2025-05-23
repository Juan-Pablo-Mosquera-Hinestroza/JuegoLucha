public class Capa extends Proteccion {
    public enum TipoCapa {
        HOJAS, TUNICA_DE_PIEL, ESCUDO_ARCANO
    }
    private TipoCapa tipo;

    public Capa(String nombre, String descripcion, int proteccion) {
        super(nombre, descripcion, proteccion);
        this.tipo = getTipoFromNombre(nombre);
    }

    private TipoCapa getTipoFromNombre(String nombre) {
        switch (nombre.toLowerCase()) {
            case "armadura de hojas": return TipoCapa.HOJAS;
            case "túnica de piel": return TipoCapa.TUNICA_DE_PIEL;
            case "escudo arcano": return TipoCapa.ESCUDO_ARCANO;
            default: return null;
        }
    }

    public TipoCapa getTipo() {
        return tipo;
    }
}
