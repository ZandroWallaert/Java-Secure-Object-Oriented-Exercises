package d03.polymorphism1;

public class Coffeemaker extends Device {

    private double waterTankCapacity;

    public Coffeemaker(double waterTankCapacity) {
        this.waterTankCapacity = waterTankCapacity;
    }

    public void brewCoffee() {
        // TODO
    }

    @Override
    public String toString() {
        return String.format("Coffeemaker with %.1f liters capacity is currently powered %s.",
                waterTankCapacity, isPoweredOn() ? "on" : "off");
    }
}
