package be.howest.ti.jdbc.data;

public class Repositories {

    private static final ProductRepository PRODUCTS_REPO = new MySqlProductRepository();

    private Repositories() {
    }

    public static ProductRepository getProductsRepo() {
        return PRODUCTS_REPO;
    }

}
