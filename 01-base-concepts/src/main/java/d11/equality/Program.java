package d11.equality;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Employee f1 = new Employee(1, "Vlummens", "Frédéric");
        Employee f2 = new Employee(1, "Vlummens", "Frédéric");

        Employee m1 = new Employee(2, "De Wael", "Mattias");

        System.out.println(String.format("f1 equals f2? %s", f1.equals(f2)));
        System.out.println(String.format("f1 equals m1? %s", f1.equals(m1)));
    }

}
