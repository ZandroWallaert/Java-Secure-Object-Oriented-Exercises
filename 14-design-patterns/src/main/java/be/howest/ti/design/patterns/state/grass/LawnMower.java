package be.howest.ti.design.patterns.state.grass;

import be.howest.ti.design.patterns.general.grass.ILawnMower;
import be.howest.ti.design.patterns.state.grass.versions.Version;

public class LawnMower implements ILawnMower {

    private final Version version;


    public LawnMower(Version version) {
        this.version = version;
    }

    @Override
    public void mowTheGrass() {
        System.out.printf("%s, mow mow mow, short. (%s)%n",
                version.soundOnomatopoeia(),
                version.soundDescription()
        );
    }

    @Override
    public void displayToScreen() {
        System.out.printf("This is %s lawn mower, I cut up to %d cm.%n",
                version.priceCategory(),
                version.getMinGrassLength()
        );
    }

    @Override
    public int getMinGrassLength() {
        return version.getMinGrassLength();
    }
}
