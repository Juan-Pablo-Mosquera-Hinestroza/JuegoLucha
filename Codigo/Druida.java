import java.util.Arrays;
import java.util.Scanner;

public class Druida extends Personaje {
    public Druida(String nombre, Armas arma, Proteccion armadura) {
        super(nombre, arma, armadura, Arrays.asList(
            new magicos("Bola de Fuego", "Ataque de fuego mágico", 19, 0.25, 2.0),
            new magicos("Rayo Helado", "Ataque de hielo", 16, 0.35, 1.7),
            new magicos("Explosión Arcana", "Explosión de energía arcana", 23, 0.15, 2.5),
            new magicos("Descarga Eléctrica", "Ataque eléctrico", 18, 0.30, 2.0)
        ));
    }

    @Override
    public void atacar(Personaje oponente, Scanner scanner) {
        System.out.println("Elige el ataque para " + this.getNombre() + ":");
        for (int i = 0; i < this.getAtaques().size(); i++) {
            Ataques atk = this.getAtaques().get(i);
            System.out.println((i + 1) + ". " + atk.getNombre() + " | Daño base: " + atk.getDanoBase() + " + Daño arma: " + this.getArma().getDano()
                    + " | Prob. crítico: " + (int) (atk.getProbCritico() * 100) + "% | Multiplicador crítico: x" + atk.getMultiplicadorCritico());
        }
        int idx = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print("Selecciona el número de ataque: ");
            idx = scanner.nextInt() - 1;
            scanner.nextLine();
            if (idx >= 0 && idx < this.getAtaques().size()) {
                valido = true;
            } else {
                System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
        Ataques ataque = this.getAtaques().get(idx);
        int danoTotal = ataque.getDanoBase() + this.getArma().getDano();
        boolean critico = Math.random() < ataque.getProbCritico();
        if (critico) {
            danoTotal = (int) (danoTotal * ataque.getMultiplicadorCritico());
            System.out.println("¡CRÍTICO! El ataque inflige daño multiplicado.");
        }
        oponente.recibirDano(danoTotal);
        System.out.println(this.getNombre() + " usa " + ataque.getNombre() + " y causa " + danoTotal + " puntos de daño (arma: " + this.getArma().getNombre() + ").");
        System.out.println("\u001B[31m" + oponente.getNombre() + " ahora tiene " + oponente.getPuntosDeVida() + "/" + oponente.getVidaMaxima() + " puntos de vida.\u001B[0m");
    }

    // Reemplazar DruidaBuilder por extensión del builder de Personaje
    public static class Builder extends Personaje.Builder<Druida> {
        @Override
        public Druida build() {
            return new Druida(nombre, arma, armadura);
        }
    }
}