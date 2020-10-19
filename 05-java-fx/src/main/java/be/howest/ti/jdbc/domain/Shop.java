package be.howest.ti.jdbc.domain;

import be.howest.ti.jdbc.util.ShopException;

import java.util.HashMap;
import java.util.Map;

public class Shop {

    private final Map<Product, Integer> stock = new HashMap<>();

    public void buy(Product p) {
        int currentStock = getCurrentStock(p);

        if (currentStock <= 0) {
            throw new ShopException("Out of stock");
        }

        stock.put(p, currentStock-1);
    }

    public void restock(Product p, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count must be positive");
        }
        stock.put(p, getCurrentStock(p) + count);
    }

    private int getCurrentStock(Product p) {
        return stock.getOrDefault(p, 0);
    }

    public Product findByName(String name) {
        for(Product p : stock.keySet()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Product p : stock.keySet()) {
            res.append(p).append("\t").append(getCurrentStock(p)).append("\n");
        }
        return res.toString();
    }

}
