package be.howest.ti.jdbc.data;

public class Repositories {

    private static final ProductRepository PRODUCTS_REPO = new TextFileProductRepository();

    private Repositories() {
    }

    public static ProductRepository getProductsRepo() {
        return PRODUCTS_REPO;
    }

}
