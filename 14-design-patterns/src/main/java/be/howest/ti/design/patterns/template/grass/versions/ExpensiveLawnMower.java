package be.howest.ti.design.patterns.template.grass.versions;

import be.howest.ti.design.patterns.template.grass.LawnMower;

public class ExpensiveLawnMower extends LawnMower {

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
