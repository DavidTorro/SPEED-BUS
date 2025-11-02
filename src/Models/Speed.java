/**
 * @project: README.md
 * @course: 2º DAM
 * @teacher: Antoni Gimenez Rodriguez
 * @author: David Torró Bautista
 * @date: 02-11-2025
 * @description: Hilo que, en cada iteración, acelera o frena un Bus con
 *               un incremento aleatorio (1-10) y espera 1 segundo entre cambios.
 *               Útil para la simulación en paralelo.
 */

package Models;

public class Speed extends Thread { // extiende de Thread para poder correr en hilos diferentes
    // atributos
    private Bus bus;
    private int speed;
    // booleano para saber si está acelerando o frenando (true = acelerando, false = frenando)
    private boolean accelerating;

    // constructor con velocidad "opcional"
    public Speed(Bus bus, boolean accelerating) {
        this.bus = bus;
        this.accelerating = accelerating;
    }

    // constructor completo (por si se quiere especificar la velocidad a otra)
    public Speed(Bus bus, int speed, boolean accelerating) {
        this.bus = bus;
        this.speed = speed;
        this.accelerating = accelerating;
    }

    // getters y setters
    public Bus getBus() {
        return bus;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getAccelerating() {
        return accelerating;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAccelerating(boolean accelerating) {
        this.accelerating = accelerating;
    }

    // metodos de la clase
    // metodo run (de Thread) que se ejecuta al iniciar el hilo (@override)
    @Override
    public void run() {
        do {
            // generador de velocidad aleatoria entre 1 y 10
            int randomSpeed = (int) (Math.random() * 10) + 1;

            try {
                if (accelerating) {
                    bus.accelerate(randomSpeed);
                } else {
                    bus.brake(randomSpeed);
                }
                Thread.sleep(1000); // espera 1 segundo entre cada cambio de velocidad
            } catch (Exception ex) {
                Thread.currentThread().interrupt(); // interrumpe el hilo en caso de error y no queda en loop infinito
                System.out.println("ERROR: " + ex.getMessage());
            }
        } while (true);
    }
}