package be.howest.ti.design.patterns.factory.grass;

import be.howest.ti.design.patterns.general.grass.ILawnMower;
import be.howest.ti.design.patterns.strategy.grass.LawnMower;
import be.howest.ti.design.patterns.strategy.grass.versions.CheapLawnMowerVersion;
import be.howest.ti.design.patterns.template.grass.versions.CheapLawnMower;

public interface LawnMowerFactory {

    ILawnMower create();






    class StrategyLawnMowerFactory implements LawnMowerFactory {

        @Override
        public ILawnMower create() {
            return new LawnMower(new CheapLawnMowerVersion());
        }
    }





    class TemplateLawnMowerFactory implements LawnMowerFactory {

        @Override
        public ILawnMower create() {
            return new CheapLawnMower();
        }
    }

    static LawnMowerFactory factory(String appearance) {
        switch (appearance) {
            case "Strategy":
                return new StrategyLawnMowerFactory();
            case "Template":
                return new TemplateLawnMowerFactory();
            default:
                throw new IllegalArgumentException("unknown " + appearance);
        }
    }

}
