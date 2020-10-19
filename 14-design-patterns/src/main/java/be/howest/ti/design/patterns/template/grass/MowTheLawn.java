package be.howest.ti.design.patterns.template.grass;

import be.howest.ti.design.patterns.template.grass.versions.CheapLawnMower;
import be.howest.ti.design.patterns.template.grass.versions.ExpensiveLawnMower;

public class MowTheLawn {

    public static void main(String[] args) {
        LawnMower a = new CheapLawnMower();
        LawnMower b = new ExpensiveLawnMower();

        run(a);
        run(b);
    }

    private static void run(LawnMower lm) {
        lm.displayToScreen();
        lm.mowTheGrass();
        System.out.println(lm.getMinGrassLength());
    }

}
