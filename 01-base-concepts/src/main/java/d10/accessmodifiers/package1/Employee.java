package d10.accessmodifiers.package1;

public class Employee extends Person {

    private int id;
    String email;

    public Employee(int id, String lastname, String firstname, String email) {
        super(lastname, firstname);
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        // This does not work, because lastname is private
        // return String.format("#%d; %s %s; %s",
        //         id, lastname, firstname, email);

        return String.format("%d; %s; %s", id, firstname, email);
    }
}
