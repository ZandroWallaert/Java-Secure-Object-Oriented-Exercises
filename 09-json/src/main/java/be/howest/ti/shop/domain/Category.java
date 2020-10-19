package be.howest.ti.shop.domain;

import be.howest.ti.shop.data.json.util.StringToCategoryConverter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Category {


    @JsonValue
    private final String name;

    @JsonDeserialize(converter = Foo.class)
    private final Set<Product> products;

    @JsonCreator
    private Category(
            @JsonProperty("name") String name,
            @JsonProperty("products") Set<Product> products

    ) {
        this.name = name;
        this.products = products;
    }

    @JsonCreator
    public Category(
            @JsonProperty("name") String name
    ) {
        this(name, new HashSet<>());
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }

    @JsonIgnore
    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }

    void register(Product product) {
        products.add(product);
    }
}
