import java.util.Scanner;

public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    // Constructor para inicializar los personajes
    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    // Modificado: turno permite usar poción como acción
    private void turno(Personaje atacante, Personaje defensor, Scanner scanner) {
        System.out.println("\u001B[32mTurno de " + atacante.getNombre() + ". Puntos de vida de " + defensor.getNombre() + ": "
        + defensor.getPuntosDeVida() + "/" + defensor.getVidaMaxima() + "\u001B[0m");
        if (atacante instanceof Mochila) {
            Mochila m = (Mochila) atacante;
            boolean puedeCurar = m.tienePocion();
            System.out.println("Elige la acción para " + atacante.getNombre() + ":");
            System.out.println("1. Atacar");
            if (puedeCurar) {
                System.out.println("2. Usar poción de curación (+30 vida, 1 solo uso)");
            }
            int idx = -1;
            boolean valido = false;
            while (!valido) {
                System.out.print("Selecciona el número de acción: ");
                idx = scanner.nextInt();
                scanner.nextLine();
                if (idx == 1) {
                    valido = true;
                } else if (puedeCurar && idx == 2) {
                    valido = true;
                } else {
                    System.out.println("Opción inválida. Intenta de nuevo.");
                }
            }
            if (puedeCurar && idx == 2) {
                boolean usada = m.usarPocion();
                if (usada) {
                    System.out.println("¡Has usado tu turno para curarte!");
                } else {
                    System.out.println("No se pudo usar la poción. Pierdes el turno.");
                }
                return;
            } else {
                atacante.atacar(defensor, scanner);
            }
        } else {
            atacante.atacar(defensor, scanner);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Opciones predeterminadas para Berserker
        fisicas.TipoFisica[] tiposArmasBerserker = fisicas.TipoFisica.values();
        Peto.TipoPeto[] tiposProteccionesBerserker = Peto.TipoPeto.values();
        magicas.TipoMagica[] tiposArmasDruida = magicas.TipoMagica.values();
        Capa.TipoCapa[] tiposProteccionesDruida = Capa.TipoCapa.values();

        // --- JUGADOR 1 ---
        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Elige el tipo de personaje para jugador 1 (1=Berserker, 2=Druida): ");
        int tipo1 = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Personaje jugador1;
        if (tipo1 == 2) {
            // Mostrar armas druida
            System.out.println("Opciones de arma para Druida:");
            for (int i = 0; i < tiposArmasDruida.length; i++) {
                System.out.println((i + 1) + ". " + tiposArmasDruida[i]);
            }
            System.out.print("Elige el arma: ");
            int armaIdx = scanner.nextInt() - 1;
            // Mostrar protecciones druida
            System.out.println("Opciones de protección para Druida:");
            for (int i = 0; i < tiposProteccionesDruida.length; i++) {
                System.out.println((i + 1) + ". " + tiposProteccionesDruida[i]);
            }
            System.out.print("Elige la protección: ");
            int proteccionIdx = scanner.nextInt() - 1;
            scanner.nextLine();
            jugador1 = new Druida.Builder()
                    .conNombre(nombre1)
                    .conArma(new magicas(tiposArmasDruida[armaIdx].name(), tiposArmasDruida[armaIdx].name(), 10))
                    .conArmadura(new Capa(tiposProteccionesDruida[proteccionIdx].name(), tiposProteccionesDruida[proteccionIdx].name(), 5))
                    .build();
        } else {
            // Mostrar armas berserker
            System.out.println("Opciones de arma para Berserker:");
            for (int i = 0; i < tiposArmasBerserker.length; i++) {
                System.out.println((i + 1) + ". " + tiposArmasBerserker[i]);
            }
            System.out.print("Elige el arma: ");
            int armaIdx = scanner.nextInt() - 1;
            // Mostrar protecciones berserker
            System.out.println("Opciones de protección para Berserker:");
            for (int i = 0; i < tiposProteccionesBerserker.length; i++) {
                System.out.println((i + 1) + ". " + tiposProteccionesBerserker[i]);
            }
            System.out.print("Elige la protección: ");
            int proteccionIdx = scanner.nextInt() - 1;
            scanner.nextLine();
            jugador1 = new Berserker.Builder()
                    .conNombre(nombre1)
                    .conArma(new fisicas(tiposArmasBerserker[armaIdx].name(), tiposArmasBerserker[armaIdx].name(), 8))
                    .conArmadura(new Peto(tiposProteccionesBerserker[proteccionIdx].name(), tiposProteccionesBerserker[proteccionIdx].name(), 8))
                    .build();
        }
        // Decorar con mochila
        jugador1 = new Mochila(jugador1);

        // --- JUGADOR 2 ---
        System.out.print("Introduce el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Elige el tipo de personaje para jugador 2 (1=Berserker, 2=Druida): ");
        int tipo2 = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Personaje jugador2;
        if (tipo2 == 2) {
            // Mostrar armas druida
            System.out.println("Opciones de arma para Druida:");
            for (int i = 0; i < tiposArmasDruida.length; i++) {
                System.out.println((i + 1) + ". " + tiposArmasDruida[i]);
            }
            System.out.print("Elige el arma: ");
            int armaIdx = scanner.nextInt() - 1;
            // Mostrar protecciones druida
            System.out.println("Opciones de protección para Druida:");
            for (int i = 0; i < tiposProteccionesDruida.length; i++) {
                System.out.println((i + 1) + ". " + tiposProteccionesDruida[i]);
            }
            System.out.print("Elige la protección: ");
            int proteccionIdx = scanner.nextInt() - 1;
            scanner.nextLine();
            jugador2 = new Druida.Builder()
                    .conNombre(nombre2)
                    .conArma(new magicas(tiposArmasDruida[armaIdx].name(), tiposArmasDruida[armaIdx].name(), 10))
                    .conArmadura(new Capa(tiposProteccionesDruida[proteccionIdx].name(), tiposProteccionesDruida[proteccionIdx].name(), 5))
                    .build();
        } else {
            // Mostrar armas berserker
            System.out.println("Opciones de arma para Berserker:");
            for (int i = 0; i < tiposArmasBerserker.length; i++) {
                System.out.println((i + 1) + ". " + tiposArmasBerserker[i]);
            }
            System.out.print("Elige el arma: ");
            int armaIdx = scanner.nextInt() - 1;
            // Mostrar protecciones berserker
            System.out.println("Opciones de protección para Berserker:");
            for (int i = 0; i < tiposProteccionesBerserker.length; i++) {
                System.out.println((i + 1) + ". " + tiposProteccionesBerserker[i]);
            }
            System.out.print("Elige la protección: ");
            int proteccionIdx = scanner.nextInt() - 1;
            scanner.nextLine();
            jugador2 = new Berserker.Builder()
                    .conNombre(nombre2)
                    .conArma(new fisicas(tiposArmasBerserker[armaIdx].name(), tiposArmasBerserker[armaIdx].name(), 8))
                    .conArmadura(new Peto(tiposProteccionesBerserker[proteccionIdx].name(), tiposProteccionesBerserker[proteccionIdx].name(), 8))
                    .build();
        }
        // Decorar con mochila
        jugador2 = new Mochila(jugador2);

        // Crea el juego con los personajes seleccionados y comienza la pelea
        JuegoLucha juego = new JuegoLucha(jugador1, jugador2);
        juego.iniciarPelea();
    }


    // Metodo para iniciar la pelea
    public void iniciarPelea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "...");
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2, scanner);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1, scanner);
            }
        }
        // Mostrar el resultado de la pelea
        if (jugador1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " ha ganado la pelea.");
        } else {
            System.out.println(jugador2.getNombre() + " ha ganado la pelea.");
        }
    }
}
