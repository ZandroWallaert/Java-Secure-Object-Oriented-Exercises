package be.howest.ti.shop.data;

public class Repositories {


    private static Repository repo;

    public static void setRepository(Repository repo) {
        Repositories.repo = repo;
    }

    public static Repository getCurrentRepository() {
        return repo;
    }

}
