package be.howest.ti.design.patterns.strategy.grass.versions;

public class ExpensiveLawnMowerVersion implements Version {

    @Override
    public void mowTheGrass() {
        System.out.println("sssssss, mow mow mow, short. (nice and quiet)");
    }

    @Override
    public void displayToScreen() {
        System.out.printf("This is an expensive lawn mower, I cut up to %d cm.%n", getMinGrassLength());
    }

    @Override
    public int getMinGrassLength() {
        return 1; // cm
    }
}
