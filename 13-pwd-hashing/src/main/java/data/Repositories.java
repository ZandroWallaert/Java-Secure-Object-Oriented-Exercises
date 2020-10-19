package data;

public class Repositories {

    private static final UserRepository REPO = new InMemoryUserRepository();

    private Repositories() {
    }

    public static UserRepository getUserRepository() {
        return REPO;
    }

}
