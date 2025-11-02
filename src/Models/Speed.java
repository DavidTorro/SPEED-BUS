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
}