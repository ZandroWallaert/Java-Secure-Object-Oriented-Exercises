package be.howest.ti.shop.data;

import be.howest.ti.shop.domain.Category;
import be.howest.ti.shop.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MockRepository implements Repository {

    private final List<Category> categories;
    private final List<Product> products;

    public MockRepository() {
        categories = new ArrayList<>();

        Category food = getCategoryByName("food");
        Category nonFood = getCategoryByName("non-food");

        products = new ArrayList<>(Arrays.asList(
                new Product("Cheese (Gouda)", 3.99, true, 6, food),
                new Product("Cheese (Parmesan)", 13.99, false, 21, food),
                new Product("Caviar", 130.99, false, 21, food),
                new Product("Paper box", 1.99, true, 21, nonFood)
        ));
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public boolean addProduct(Product product) {
        if (products.contains(product)) { // keep unique
            return false;
        }

        return products.add(product);
    }

    @Override
    public List<Category> getAllCategories() {
        return Collections.unmodifiableList(categories);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categories.stream()
                .filter(c->c.getName().equals(name))
                .findAny()
                .orElseGet(()->createNewCategory(name));
    }


    private Category createNewCategory(String name) {
        Category c = new Category(name);
        categories.add(c);
        return c;
    }
}
