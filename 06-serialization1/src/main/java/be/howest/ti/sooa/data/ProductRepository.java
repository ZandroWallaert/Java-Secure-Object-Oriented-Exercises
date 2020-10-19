package be.howest.ti.sooa.data;

import be.howest.ti.sooa.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();
    void addProduct(Product product);

}
