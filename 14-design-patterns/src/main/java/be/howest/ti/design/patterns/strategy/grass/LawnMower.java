package be.howest.ti.design.patterns.strategy.grass;

import be.howest.ti.design.patterns.general.grass.ILawnMower;
import be.howest.ti.design.patterns.strategy.grass.versions.Version;

public class LawnMower implements ILawnMower {

    private final Version version;


    public LawnMower(Version version) {
        this.version = version;
    }

    @Override
    public void mowTheGrass() {
        version.mowTheGrass();
    }

    @Override
    public void displayToScreen() {
        version.displayToScreen();
    }

    @Override
    public int getMinGrassLength() {
        return version.getMinGrassLength();
    }
}
