package d02.inheritance;

public class Computer {

    private String brand;
    private String color;
    private boolean poweredOn = false;

    public Computer(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public void powerOn() {
        poweredOn = true;
    }

    public void executeProgram(String program) {
        // TODO
    }

    @Override
    public String toString() {
        return String.format("brand: %s%ncolor: %s%npoweredOn: %s",
                brand, color, poweredOn);
    }
}
