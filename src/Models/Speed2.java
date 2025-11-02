/**
 * @project: README.md
 * @course: 2º DAM
 * @teacher: Antoni Gimenez Rodriguez
 * @author: David Torró Bautista
 * @date: 02-11-2025
 * @description: Variante de hilo que opera sobre Bus2 (acelerar/frenar)
 *               y finaliza cuando se alcanza un límite que provoca una “explosión”.
 */

package Models;

public class Speed2 extends Thread { // extiende de Thread para poder correr en hilos diferentes
    // atributos
    private Bus2 bus;
    private int speed;
    // booleano para saber si está acelerando o frenando (true = acelerando, false = frenando)
    private boolean accelerating;

    // constructor con velocidad "opcional"
    public Speed2(Bus2 bus, boolean accelerating) {
        this.bus = bus;
        this.accelerating = accelerating;
    }

    // constructor completo (por si se quiere especificar la velocidad a otra)
    public Speed2(Bus2 bus, int speed, boolean accelerating) {
        this.bus = bus;
        this.speed = speed;
        this.accelerating = accelerating;
    }

    // getters y setters
    public Bus2 getBus() {
        return bus;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getAccelerating() {
        return accelerating;
    }

    public void setBus(Bus2 bus) {
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
    public void run(){
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
            } catch (InterruptedException ie) { // captura la interrupcion del hilo (ChatGPT)
                Thread.currentThread().interrupt(); // conserva el estado
                break; // sale del bucle al menu principal
            } catch (Exception ex) {
                Thread.currentThread().interrupt(); // interrumpe el hilo en caso de error y no queda en loop infinito
                System.out.println("ERROR: " + ex.getMessage());
            }
        } while (true);
    }
}