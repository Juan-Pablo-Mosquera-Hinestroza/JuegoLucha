import java.util.Arrays;
import java.util.Scanner;

public class Berserker extends Personaje {
    public Berserker(String nombre, Armas arma, Proteccion armadura) {
        super(nombre, arma, armadura, Arrays.asList(
            new fisicos("Golpe Poderoso", "Ataque físico fuerte", 15, 0.20, 2.0),
            new fisicos("Estocada Rápida", "Ataque veloz y preciso", 10, 0.40, 1.5),
            new fisicos("Hachazo Brutal", "Ataque devastador con hacha", 20, 0.10, 3.0),
            new fisicos("Ataque Giratorio", "Ataque en área girando", 12, 0.30, 2.0)
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

    // Reemplazar BerserkerBuilder por extensión del builder de Personaje
    public static class Builder extends Personaje.Builder<Berserker> {
        @Override
        public Berserker build() {
            return new Berserker(nombre, arma, armadura);
        }
    }
}