package d09.methodoverriding;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Person p = new Person("De Wael", "Mattias");
        Person s = new Student(3, "Vlummens", "Frédéric");

        System.out.println(p);
        System.out.println("--------------------------");
        System.out.println(s);
    }

}
