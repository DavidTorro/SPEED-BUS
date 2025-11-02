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

    // atributos
    private String plate;
    private int speed = 50;

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
        // si la velocidad actual más la nueva supera el maximo, espera a ser notificado
        while(this.speed + randomSpeed > MAX_SPEED) {
            try {
                wait(); // espera a ser notificado por otro hilo
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // interrumpe el hilo en caso de error y no queda en loop infinito
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        // si no, acelera y lo dice (notify)
        this.speed += randomSpeed;
        System.out.println("Acelero " + randomSpeed + "km/h. Ahora vamos a: " + this.speed + "km/h.");
        notifyAll(); // notifica a los hilos que estan esperando (brake)
    }

    public synchronized void brake(int randomSpeed) {
        // si la velocidad actual menos la nueva es menor al minimo, espera a ser notificado
        while(this.speed - randomSpeed < MIN_SPEED) {
            try {
                wait(); // espera a ser notificado por otro hilo
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // interrumpe el hilo en caso de error y no queda en loop infinito
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        // si no, frena y lo dice
        this.speed -= randomSpeed;
        System.out.println("Freno " + randomSpeed + "km/h. Ahora vamos a: " + this.speed + "km/h.");
        notifyAll(); // notifica a los hilos que estan esperando (accelerate)
    }
}
