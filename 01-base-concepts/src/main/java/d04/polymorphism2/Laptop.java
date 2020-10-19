package d04.polymorphism2;

public class Laptop implements ElectricalDevice {

    private int batteryPercentage;

    public Laptop(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    @Override
    public void powerOn() {
        // TODO
    }
}
