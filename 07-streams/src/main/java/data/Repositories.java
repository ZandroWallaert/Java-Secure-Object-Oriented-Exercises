package data;

public class Repositories {

    private static final PersonRepository PERSON_REPO = new InMemoryPersonRepository();

    private Repositories() {
    }

    public static PersonRepository getPersonRepo() {
        return PERSON_REPO;
    }
}
