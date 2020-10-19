package be.howest.ti.shop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Objects;

public class Product {

    private final String name;
    private final double price;

    private final boolean inStock;
    private final int vat;

    public Category getCategory() {
        return category;
    }

    private final Category category;


    @JsonCreator
    public Product(
            @JsonProperty("name") String name,
            @JsonProperty("price") double price,
            @JsonProperty("in-stock") boolean inStock,
            @JsonProperty("vat") int vat,
            @JsonProperty("category") Category category

    ) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.vat = vat;
        this.category = category;
        this.category.register(this);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public int getVat() {
        return vat;
    }

    @JsonProperty("in-stock")
    public boolean isInStock() {
        return inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", vat=" + vat +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                inStock == product.inStock &&
                vat == product.vat &&
                name.equals(product.name) &&
                category.equals(product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, inStock, vat, category);
    }
}
