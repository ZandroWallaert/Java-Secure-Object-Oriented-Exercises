package be.howest.ti.design.patterns.builder.map;

import java.util.Map;

public class MapBuilder<K, V> {

    private final Map<K, V> theData;

    public MapBuilder(Map<K, V> anEmptyMap) {
        this.theData = anEmptyMap;
    }

    MapBuilder<K,V> with(K key, V value) {
        this.theData.put(key, value);
        return this;
    }

    MapBuilder<K,V> and(K key, V value) {
        return with(key, value);
    }

    public Map<K, V> build() {
        return theData;
    }
}
