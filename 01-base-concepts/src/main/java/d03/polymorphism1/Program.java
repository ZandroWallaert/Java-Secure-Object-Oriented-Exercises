package d03.polymorphism1;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Device a = new Computer(15.0, 90);
        Device b = new Coffeemaker(1.2);

        // this does not compile:
        // Coffeemaker c = new Computer(15.0, 90);

        System.out.println(a);
        System.out.println("---------------------------");
        System.out.println(b);
    }
}
