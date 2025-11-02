/**
 * @project: README.md
 * @course: 2º DAM
 * @teacher: Antoni Gimenez Rodriguez
 * @author: David Torró Bautista
 * @date: 02-11-2025
 * @description: Modelo de autobús simple que modifica la velocidad y muestra “BOOM!!!”
 *               al llegar a 50 o 80 km/h.
 */

package Models;

public class Bus2 {
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
    private int speed = MIN_SPEED; // velocidad inicial del autobus (50)

    // constructor con velocidad "opcional"
    public Bus2(String plate) {
        this.plate = plate;
    }

    // constructor completo (por si se quiere especificar la velocidad a otra)
    public Bus2(String plate, int speed) {
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
        this.speed += randomSpeed;
        System.out.println("Acelero " + randomSpeed + "km/h. Ahora vamos a: " + this.speed + "km/h.");

        /** 
         * como queria volver al menu despues de una explosion, he mirado por ChatGPT
         * y me ha dicho que interrumpiendo el hilo se puede salir del metodo run
         * y volver al menu principal, asi que he implementado eso aqui y en "Speed2.java"
         * (System.out.flush() es para asegurar que se imprima el mensaje antes de interrumpir el hilo)
         * Thread.currentThread().interrupt() es para conservar el estado de interrupcion del hilo
        */ 
        if (speed >= MAX_SPEED) {
            System.out.println("BOOM!!!\n");
            System.out.flush();                 
            Thread.currentThread().interrupt();
            return; // salgo del metodo si hay una explosion    
        }
    }

    public synchronized void brake(int randomSpeed) {
        this.speed -= randomSpeed;
        System.out.println("Freno " + randomSpeed + "km/h. Ahora vamos a: " + this.speed + "km/h.");

        /** 
         * como queria volver al menu despues de una explosion, he mirado por ChatGPT
         * y me ha dicho que interrumpiendo el hilo se puede salir del metodo run
         * y volver al menu principal, asi que he implementado eso aqui y en "Speed2.java"
         * (System.out.flush() es para asegurar que se imprima el mensaje antes de interrumpir el hilo)
         * Thread.currentThread().interrupt() es para conservar el estado de interrupcion del hilo
        */ 
        if (this.speed <= MIN_SPEED) {
            System.out.println("BOOM!!!\n");
            System.out.flush();                 // asegura que se imprima
            Thread.currentThread().interrupt();
            return; // salgo del metodo si hay una explosion
        }
    }
}
