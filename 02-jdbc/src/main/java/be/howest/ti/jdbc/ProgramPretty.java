package be.howest.ti.jdbc;

import be.howest.ti.jdbc.data.Repositories;
import be.howest.ti.jdbc.domain.Product;

import java.util.List;

public class ProgramPretty {

    public static void main(String[] args) {
        new ProgramPretty().run();
    }

    private void run() {
        addProducts();
        showProducts();
    }

    private void addProducts() {
        Product p1 = new Product("smartphone", 599);
        Product p2 = new Product("laptop", 799);
        Product p3 = new Product("tablet", 399);

        Repositories.getProductsRepo().addProduct(p1);
        Repositories.getProductsRepo().addProduct(p2);
        Repositories.getProductsRepo().addProduct(p3);
    }

    private void showProducts() {
        List<Product> products = Repositories.getProductsRepo().getProducts();

        for (Product product : products) {
            System.out.println(product);
        }
    }

}
