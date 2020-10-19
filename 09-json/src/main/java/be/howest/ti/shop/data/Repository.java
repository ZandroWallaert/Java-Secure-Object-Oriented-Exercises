package be.howest.ti.shop.data;

import be.howest.ti.shop.domain.Category;
import be.howest.ti.shop.domain.Product;
import java.util.List;

public interface Repository {

    List<Product> getAllProducts();
    boolean addProduct(Product product);


    List<Category> getAllCategories();
    Category getCategoryByName(String name);

}
