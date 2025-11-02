package Models;

public class Bus {
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
}
