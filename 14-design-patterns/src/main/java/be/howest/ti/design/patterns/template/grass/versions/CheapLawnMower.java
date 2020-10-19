package be.howest.ti.design.patterns.template.grass.versions;

import be.howest.ti.design.patterns.template.grass.LawnMower;

public class CheapLawnMower extends LawnMower {

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
