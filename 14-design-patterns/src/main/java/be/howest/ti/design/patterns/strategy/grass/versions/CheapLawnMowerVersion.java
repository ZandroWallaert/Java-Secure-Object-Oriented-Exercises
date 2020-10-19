package be.howest.ti.design.patterns.strategy.grass.versions;



public class CheapLawnMowerVersion implements Version {

    @Override
    public void mowTheGrass() {
        System.out.println("Grrrrrrrrrrrr, mow mow mow, short. (lots of noise)");
    }

    @Override
    public void displayToScreen() {
        System.out.printf("This is a cheap lawn mower, I cut up to %d cm.%n", getMinGrassLength());
    }

    @Override
    public int getMinGrassLength() {
        return 5; // cm
    }
}
