package d03.polymorphism1;

public class Device {

    private String brand;
    private boolean poweredOn = false;

    public Device() {
    }

    public void powerOn() {
        poweredOn = true;
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("Device %s is turned %s",
                brand, poweredOn ? "on" : "off");
    }
}
