package d10.accessmodifiers.package1;

import d10.accessmodifiers.package1.Employee;

public class Program1 {

    public static void main(String[] args) {
        new Program1().run();
    }

    private void run() {
        Employee e = new Employee(1, "Vlummens",
                "Frederic", "frederic.vlummens@howest.be");

        // e.id = 2; This does not compile
        e.firstname = "Mattias";
        // e.lastname = "De Wael"; This does not compile
        e.email = "mattias.de.wael@howest.be";

        System.out.println(e);
    }

}
