import java.util.Scanner;

public abstract class PersonajeDecorator extends Personaje {
    protected Personaje personaje;

    public PersonajeDecorator(Personaje personaje) {
        super(personaje.getNombre(), personaje.getArma(), personaje.getArmadura(), personaje.getAtaques());
        this.personaje = personaje;
    }

    @Override
    public void atacar(Personaje oponente, Scanner scanner) {
        personaje.atacar(oponente, scanner);
    }

    @Override
    public void recibirDano(int dano) {
        personaje.recibirDano(dano);
    }

    @Override
    public boolean estaVivo() {
        return personaje.estaVivo();
    }

    @Override
    public int getPuntosDeVida() {
        return personaje.getPuntosDeVida();
    }

    @Override
    public int getVidaMaxima() {
        return personaje.getVidaMaxima();
    }

    @Override
    public Armas getArma() {
        return personaje.getArma();
    }

    @Override
    public Proteccion getArmadura() {
        return personaje.getArmadura();
    }

    @Override
    public String getNombre() {
        return personaje.getNombre();
    }

    @Override
    public java.util.List<Ataques> getAtaques() {
        return personaje.getAtaques();
    }
}
