package d06.encapsulation;

public class Laptop {

    private static final int MINIMUM_RESOLUTION = 10;
    private static final int DEFAULT_RESOLUTION = 15;

    private int resolution = DEFAULT_RESOLUTION;

    public Laptop() {
    }

    public void setResolution(int resolution) {
        if (isValidResolution(resolution)) {
            this.resolution = resolution;
        } else {
            throw new IllegalArgumentException("Resolution must be equal to or greather than " + MINIMUM_RESOLUTION);
        }
    }

    private boolean isValidResolution(int resolution) {
        return resolution >= MINIMUM_RESOLUTION;
    }

}
