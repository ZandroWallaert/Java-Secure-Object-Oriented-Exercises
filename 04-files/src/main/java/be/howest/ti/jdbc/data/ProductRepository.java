package be.howest.ti.jdbc.data;

import be.howest.ti.jdbc.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();
    void addProduct(Product product);

}
