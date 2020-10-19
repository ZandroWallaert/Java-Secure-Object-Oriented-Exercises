package be.howest.ti.sooa.ui.cli;

import be.howest.ti.sooa.data.ProductRepository;
import be.howest.ti.sooa.data.Repositories;
import be.howest.ti.sooa.domain.Product;
import be.howest.ti.sooa.domain.Review;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        addProducts();
        listProducts();
    }

    private void listProducts() {
        for (Product product : Repositories.getProductRepository().getProducts()) {
            System.out.println(product);
        }
    }

    private void addProducts() {
        ProductRepository repo = Repositories.getProductRepository();

        Product p1 = new Product(1, "cookies", 3.99);
        p1.addReview(new Review(1, "frederic", "The best cookies ever!"));
        p1.addReview(new Review(2, "mattias", "You must try these cookies!"));

        repo.addProduct(p1);

        repo.addProduct(new Product(2, "cheese", 6.99));
        repo.addProduct(new Product(3, "milk", 0.99));
    }

}
