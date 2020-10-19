package be.howest.ti.design.patterns.template.grass;

import be.howest.ti.design.patterns.general.grass.ILawnMower;

public abstract class LawnMower implements ILawnMower {
    
    @Override
    public void mowTheGrass() {
        System.out.printf("%s, mow mow mow, short. (%s)%n",
                soundOnomatopoeia(),
                soundDescription());
    }

    @Override
    public void displayToScreen() {
        System.out.printf("This is %s lawn mower, I cut up to %d cm.%n",
                priceCategory(),
                getMinGrassLength()
        );
    }

    public abstract String soundDescription();
    protected abstract String soundOnomatopoeia();
    protected abstract String priceCategory();



}
