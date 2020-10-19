package d02.inheritance;

public class Laptop extends Computer {

    private double resolution;

    public Laptop(String brand, String color, double resolution) {
        super(brand, color);
        this.resolution = resolution;
    }

    public void openLid() {
        // TODO
    }

    public void closeLid() {
        // TODO
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nresolution: %f\"", resolution);
    }
}
