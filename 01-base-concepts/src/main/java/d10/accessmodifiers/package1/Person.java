package d10.accessmodifiers.package1;

public class Person {

    private String lastname;
    protected String firstname;

    public Person(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return String.format("%s %s", lastname, firstname);
    }
}
