/**
 * @project: README.md
 * @course: 2º DAM
 * @teacher: Antoni Gimenez Rodriguez
 * @author: David Torró Bautista
 * @date: 2023-10-05
 * @description: Modelo de autobús con límites de velocidad (50–80 km/h) y coordinación por turnos
 *               entre acelerar y frenar mediante métodos sincronizados con wait/notifyAll.
*/

package Models;

public class Bus {
    /**
     * constantes
     * nunca he usado constantes en Java, pero creo que así se hace,
     * considero que para este caso es mejor usar constantes que
     * definir los valores directamente en los métodos
     */
    private static final int MIN_SPEED = 50;
    private static final int MAX_SPEED = 80;

    // solucion a los "turnos" de los hilos, usando un booleano para decir si es el turno de acelerar o frenar
    private boolean canBrake = false;

    // atributos
    private String plate;
    private int speed = MIN_SPEED; // velocidad inicial del autobus (50)

    // constructor con velocidad "opcional"
    public Bus(String plate) {
        this.plate = plate;
    }

    // constructor completo (por si se quiere especificar la velocidad a otra)
    public Bus(String plate, int speed) {
        this.plate = plate;
        this.speed = speed;
    }

    // getters y setters
    public String getPlate() {
        return plate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // metodos
    public synchronized void accelerate(int randomSpeed) {
        // si el turno es de frenar, espera a ser notificado
        while(canBrake) {
            try {
                wait(); // espera a ser notificado por otro hilo
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // interrumpe el hilo en caso de error y no queda en loop infinito
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        // SOLO notifica el cambio de turno si ha llegado a la velocidad maxima
        if (this.speed + randomSpeed > MAX_SPEED) {
            canBrake = true; // pasa el turno a frenar
            notifyAll(); // notifica
            return; // uso aqui return para salir del metodo y no acelerar mas alla del maximo
        }

        // si no, acelera y lo dice
        this.speed += randomSpeed;
        System.out.println("Acelero " + randomSpeed + "km/h. Ahora vamos a: " + this.speed + "km/h.");

        if (speed >= MAX_SPEED) {
            canBrake = true; // pasa el turno a frenar
            notifyAll();
            // aqui no uso return porque ya ha acelerado al maximo
        }
    }

    public synchronized void brake(int randomSpeed) {
        // si el turno es de acelerar, espera a ser notificado
        while(!canBrake) {
            try {
                wait(); // espera a ser notificado por otro hilo
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // interrumpe el hilo en caso de error y no queda en loop infinito
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        // SOLO notifica el cambio de turno si ha llegado a la velocidad maxima
        if (this.speed - randomSpeed < MIN_SPEED) {
            canBrake = false; // pasa el turno a acelerar
            notifyAll(); // notifica
            return; // uso aqui return para salir del metodo y no acelerar mas alla del maximo
        }

        // si no, frena y lo dice
        this.speed -= randomSpeed;
        System.out.println("Freno " + randomSpeed + "km/h. Ahora vamos a: " + this.speed + "km/h.");

        if (this.speed <= MIN_SPEED) {
            canBrake = false; // pasa el turno a acelerar
            notifyAll();
            // aqui no uso return porque ya ha acelerado al maximo
        }
    }
}
