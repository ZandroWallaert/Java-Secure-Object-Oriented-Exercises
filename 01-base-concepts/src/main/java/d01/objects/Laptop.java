package d01.objects;

public class Laptop {

    private String brand;
    private String color;
    private double resolution;
    private boolean poweredOn = false;

    public Laptop(String brand, String color, double resolution) {
        this.brand = brand;
        this.color = color;
        this.resolution = resolution;
    }

    public void powerOn() {
        poweredOn = true;
    }

    public void executeProgram(String program) {
        // TODO
    }

    @Override
    public String toString() {
        return String.format("brand: %s%ncolor: %s%nresolution: %.1f\"%npoweredOn: %s",
                brand, color, resolution, poweredOn);
    }
}
