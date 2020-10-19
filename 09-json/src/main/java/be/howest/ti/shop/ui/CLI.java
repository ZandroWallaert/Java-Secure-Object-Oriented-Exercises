package be.howest.ti.shop.ui;

import be.howest.ti.shop.data.MockRepository;
import be.howest.ti.shop.data.Repository;
import be.howest.ti.shop.domain.Product;

public class CLI {

    public static void main(String[] args) {
        new CLI().run();
    }

    private void run() {
        Repository repo = new MockRepository();
        for (Product product : repo.getAllProducts()) {
            System.out.println(product); // NOSONAR
        }
    }


}
