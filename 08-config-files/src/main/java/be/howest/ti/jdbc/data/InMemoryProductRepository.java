package be.howest.ti.jdbc.data;

import be.howest.ti.jdbc.domain.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public void addProduct(Product product) {
        if (product.getId() != 0) { // check for default id
            throw new IllegalStateException("Product already in repo?");
        }

        product.setId((products.size() * 100) + 99); // needed to ensure working of equals/hashcode
        products.add(product);
    }
}
