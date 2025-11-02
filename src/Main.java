/**
 * @project: README.md
 * @course: 2º DAM
 * @teacher: Antoni Gimenez Rodriguez
 * @author: David Torró Bautista
 * @date: 02-11-2025
 * @description: Clase principal que muestra un menú y lanza las simulaciones 
 *               de un autobús que acelera y frena en hilos separados.
 *               Hay dos modos: uno con loop infinito y otro con posibles explosiones.
 *               INSPO: SPEED Movie (1994)
*/

import Models.Bus;
import Models.Bus2;
import Models.Speed;
import Models.Speed2;

public class Main {
    // Scanner 
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    // metodo main
    public static void main(String[] args) throws Exception {
        System.out.println("***INICIO DEL PROGRAMA***\n");

        boolean ok = false;
        int input = 0;

        do {
            menuInicial();
            try {
                input = scanner.nextInt(); scanner.nextLine();
                input = Integer.parseInt(String.valueOf(input)); // ver si hay error de formato

                switch (input) {
                    case 1:
                        opcionLoopInfinito();
                        break;
                    case 2:
                        opcionConExplosiones();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...\n");
                        ok = true;
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.\n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: " + ex.getMessage() + ". Intente de nuevo.");
            }
        } while (!ok);

        System.out.println("***FINAL DEL PROGRAMA***");
        System.exit(0);
    }

    //metodos de la clase
    public static void menuInicial() {
        System.out.println("----- SPEED - BUS -----");
        System.out.println("1. Iniciar simulacion (loop infinito)");
        System.out.println("2. Iniciar simulacion (con explosiones)");
        System.out.println("3. Salir");
        System.out.println("Seleccione una opcion: ");
    }

    public static void opcionLoopInfinito() {
        Bus bus = new Bus("1234ABC");
        // Bus bus = new Bus("1234ABC", 50);
        // Bus bus = new Bus("1234ABC", 80);
        Speed accelerateThread = new Speed(bus, true);
        Speed brakeThread = new Speed(bus, false);
        accelerateThread.start();
        brakeThread.start();
    }

    public static void opcionConExplosiones() {
        Bus2 bus = new Bus2("1234ABC"); // bus con velocidad inicial 50
        Bus2 bus2 = new Bus2("1234ABC", 80); // bus con velocidad inicial 80

        System.out.println("\nIniciando simulacion con posibles explosiones...");
        System.out.println("Que quieres probar, acelerar o frenar?");
        String opcion = scanner.nextLine();
        
        try {
            if (opcion.equalsIgnoreCase("acelerar")) {
                Speed2 accelerateThread = new Speed2(bus, true);
                accelerateThread.start();
                accelerateThread.join(); // espera a que termine el hilo (ChatGPT)      
            } else if (opcion.equalsIgnoreCase("frenar")) {
                Speed2 brakeThread = new Speed2(bus2, false);
                brakeThread.start();
                brakeThread.join(); // espera a que termine el hilo (ChatGPT)
            } else {
                System.out.println("Opcion no valida. Saliendo a menu principal...\n");
                return;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // conserva el estado de interrupcion (ChatGPT)
        }

        System.out.println("Simulacion terminada. Volviendo al menu...\n");
    }
}