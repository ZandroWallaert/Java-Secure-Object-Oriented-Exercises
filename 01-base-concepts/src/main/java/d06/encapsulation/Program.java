package d06.encapsulation;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Laptop l = new Laptop();
        l.setResolution(15); // OK
        l.setResolution(9);  // this will cause an exception
    }

}
