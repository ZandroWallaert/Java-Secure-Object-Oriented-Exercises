package be.howest.ti.design.patterns.state.grass.versions;

public class CheapLawnMowerVersion implements Version {

    @Override
    public String soundOnomatopoeia() {
        return "Grrrrrrrrrrrr";
    }

    @Override
    public String soundDescription() {
        return "lots of noise";
    }

    @Override
    public String priceCategory() {
        return "a cheap";
    }

    @Override
    public int getMinGrassLength() {
        return 5; // cm
    }
}
