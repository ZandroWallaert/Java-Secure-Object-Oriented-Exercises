package d05.abstraction;

public abstract class Device {

    private String brand;

    public Device() {
    }

    public abstract void powerOn();

    @Override
    public String toString() {
        return String.format("Device %s", brand);
    }
}
