package d12.comparison;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Person m = new Person(32, "De Wael", "Mattias");
        Person f = new Person(39, "Vlummens", "Frédéric");

        System.out.println(m.compareTo(f));
    }

}
