package be.howest.ti.jdbc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private int id;
    private String name;
    private double price;
    private int vat;

    public Product(String name, double price, int vat) {
        this(0, name, price, vat);
    }

    public Product(int id, String name, double price, int vat) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.vat = vat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s @ %.2f (%d%% VAT)", name, price,vat);
    }


    public int getVAT() {
        return vat;
    }
}
