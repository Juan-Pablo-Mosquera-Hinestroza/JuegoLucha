public class magicas extends Armas {
    public enum TipoMagica {
        BASTON, VARITA, BACULO
    }
    private TipoMagica tipo;

    public magicas(String nombre, String descripcion, int dano) {
        super(nombre, descripcion, dano);
        this.tipo = getTipoFromNombre(nombre);
    }

    private TipoMagica getTipoFromNombre(String nombre) {
        switch (nombre.toLowerCase()) {
            case "bastón mágico":
            case "bastón":
                return TipoMagica.BASTON;
            case "varita":
                return TipoMagica.VARITA;
            case "báculo de roble":
            case "báculo":
                return TipoMagica.BACULO;
            default: return null;
        }
    }

    public TipoMagica getTipo() {
        return tipo;
    }
}
