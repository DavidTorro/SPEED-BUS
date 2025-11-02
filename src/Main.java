import Models.Bus;
import Models.Speed;

public class Main {
    public static void main(String[] args) throws Exception {
        Bus bus = new Bus("1234ABC");
        Speed accelerateThread = new Speed(bus, true);
        Speed brakeThread = new Speed(bus, false);
        accelerateThread.start();
        brakeThread.start();
    }
}