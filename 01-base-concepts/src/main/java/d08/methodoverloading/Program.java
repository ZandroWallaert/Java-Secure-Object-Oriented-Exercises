package d08.methodoverloading;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Calculator c = new Calculator();

        System.out.println(c.calcSum(5, 3));
        System.out.println(c.calcSum(5, 3, 2));
    }

}
