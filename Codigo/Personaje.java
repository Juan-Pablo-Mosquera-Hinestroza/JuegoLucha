import java.util.List;
import java.util.Scanner;

abstract class Personaje {
    protected String nombre;
    protected int puntosDeVida;
    protected final int MAX_DANO = 30;
    protected final int MIN_DANO = 10;
    protected Armas arma;
    protected Proteccion armadura;
    protected List<Ataques> ataques;
    protected int vidaMaxima;

    // Constructor para inicializar los datos del personaje
    public Personaje(String nombre, Armas arma, Proteccion armadura, List<Ataques> ataques) {
        this.nombre = nombre;
        this.arma = arma;
        this.armadura = armadura;
        this.ataques = ataques;
        this.vidaMaxima = 100 + (armadura != null ? armadura.getProteccion() : 0);
        this.puntosDeVida = vidaMaxima;
    }

    // Metodo abstracto para realizar un ataque a otro personaje
    public abstract void atacar(Personaje oponente, Scanner scanner);

    // Metodo para recibir daño (sin reducción por armadura)
    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0; // No se puede tener menos de 0 puntos de vida
        }
        System.out.println(this.nombre + " recibe " + dano + " puntos de daño.");
    }

    // Verifica si el personaje sigue vivo
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    // Devuelve el nombre del personaje
    public String getNombre() {
        return this.nombre;
    }

    // Devuelve los puntos de vida actuales
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }

    public Armas getArma() {
        return arma;
    }

    public Proteccion getArmadura() {
        return armadura;
    }

    public List<Ataques> getAtaques() {
        return ataques;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    // Builder genérico centralizado
    public static class Builder<T extends Personaje> {
        protected String nombre;
        protected Arma arma;
        protected Armadura armadura;

        public Builder<T> conNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public Builder<T> conArma(Arma arma) {
            this.arma = arma;
            return this;
        }
        public Builder<T> conArmadura(Armadura armadura) {
            this.armadura = armadura;
            return this;
        }
        // Este método debe ser sobrescrito en cada subclase para devolver el tipo correcto
        public T build() {
            throw new UnsupportedOperationException("Implementa build() en la subclase");
        }
    }
}
