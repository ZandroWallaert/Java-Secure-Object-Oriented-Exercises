package be.howest.ti.design.patterns.strategy.grass;

import be.howest.ti.design.patterns.strategy.grass.versions.CheapLawnMowerVersion;
import be.howest.ti.design.patterns.strategy.grass.versions.ExpensiveLawnMowerVersion;

public class MowTheLawn {

    public static void main(String[] args) {
        LawnMower a = new LawnMower(new CheapLawnMowerVersion());
        LawnMower b = new LawnMower(new ExpensiveLawnMowerVersion());

        run(a);
        run(b);
    }

    private static void run(LawnMower lm) {
        lm.displayToScreen();
        lm.mowTheGrass();
        System.out.println(lm.getMinGrassLength());
    }

}
