package d10.accessmodifiers.package2;

import d10.accessmodifiers.package1.Employee;

public class Program2 {

    public static void main(String[] args) {
        new Program2().run();
    }

    private void run() {
        Employee e = new Employee(1, "Vlummens",
                "Frederic", "frederic.vlummens@howest.be");

        // e.id = 2; This does not compile
        // e.firstname = "Mattias"; This does not compile
        // e.lastname = "De Wael"; This does not compile
        // e.email = "mattias.de.wael@howest.be"; This does not compile

        System.out.println(e);
    }

}
