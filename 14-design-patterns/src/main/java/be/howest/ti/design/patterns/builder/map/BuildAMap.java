package be.howest.ti.design.patterns.builder.map;

import java.util.HashMap;
import java.util.Map;

public class BuildAMap {

    public static void main(String[] args) {
        Map<String, Integer> data = new MapBuilder<>(new HashMap<String, Integer>())
                .with("een", 1)
                .and("twee", 2)
                .and("drie", 3)
                .and("vier", 4)
                .and("vijf", 5)
                .build();

        System.out.println(data);
    }

}
