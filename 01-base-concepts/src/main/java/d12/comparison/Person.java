package d12.comparison;

public class Person implements Comparable<Person> {

    private int age;
    private String lastname;
    private String firstname;

    public Person(int age, String lastname, String firstname) {
        this.age = age;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return String.format("%s %s (age: %d)",
                lastname, firstname, age);
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }

}

