package be.howest.ti.jdbc.ui;

import be.howest.ti.jdbc.data.ProductRepository;
import be.howest.ti.jdbc.data.Repositories;
import be.howest.ti.jdbc.domain.Product;

public class CommandLineApp {

    public static void main(String[] args) {
        new CommandLineApp().run();
    }

    private void run() {
        ProductRepository repo = Repositories.getProductsRepo();

        for (Product p : repo.getProducts()) {
            System.out.println(p); // NOSONAR
        }

        repo.addProduct(new Product("Cookie", 3.75, 12));

        for (Product p : repo.getProducts()) {
            System.out.println(p); // NOSONAR
        }
    }

}
