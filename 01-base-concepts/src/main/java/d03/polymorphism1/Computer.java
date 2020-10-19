package d03.polymorphism1;

public class Computer extends Device {

    private double resolution;
    private int batteryPercentage;

    public Computer(double resolution, int batteryPercentage) {
        this.resolution = resolution;
        this.batteryPercentage = batteryPercentage;
    }

    public void openLid() {
        // TODO
    }

    public void closeLid() {
        // TODO
    }

    @Override
    public String toString() {
        return String.format("Computer with battery at %d%%, resolution %.1f\" is currently turned %s",
                batteryPercentage, resolution, isPoweredOn() ? "on" : "off");
    }
}
