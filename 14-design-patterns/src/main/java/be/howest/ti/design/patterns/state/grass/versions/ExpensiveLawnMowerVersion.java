package be.howest.ti.design.patterns.state.grass.versions;

public class ExpensiveLawnMowerVersion implements Version {

    @Override
    public String soundOnomatopoeia() {
        return "sssssss";
    }

    @Override
    public String soundDescription() {
        return "nice and quiet";
    }

    @Override
    public String priceCategory() {
        return "an expensive";
    }

    @Override
    public int getMinGrassLength() {
        return 1; // cm
    }
}
