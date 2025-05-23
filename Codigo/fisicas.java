public class fisicas extends Armas {
    public enum TipoFisica {
        ESPADA, HACHA, LANZA
    }
    private TipoFisica tipo;

    public fisicas(String nombre, String descripcion, int dano) {
        super(nombre, descripcion, dano);
        this.tipo = getTipoFromNombre(nombre);
    }

    private TipoFisica getTipoFromNombre(String nombre) {
        switch (nombre.toLowerCase()) {
            case "espada": return TipoFisica.ESPADA;
            case "hacha": return TipoFisica.HACHA;
            case "lanza": return TipoFisica.LANZA;
            default: return null;
        }
    }

    public TipoFisica getTipo() {
        return tipo;
    }
}
