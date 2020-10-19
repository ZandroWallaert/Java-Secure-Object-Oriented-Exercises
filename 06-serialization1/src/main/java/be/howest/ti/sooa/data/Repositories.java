package be.howest.ti.sooa.data;

public final class Repositories {

    private static final ProductRepository REPO = new SerializedProductRepository();

    private Repositories() {
    }

    public static ProductRepository getProductRepository() {
        return REPO;
    }

}
