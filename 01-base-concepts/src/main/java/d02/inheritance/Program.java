package d02.inheritance;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Desktop d = new Desktop("HP", "black");
        Laptop l = new Laptop("Apple", "spaceGray", 15);

        System.out.println(d);
        System.out.println("-----------------------");
        System.out.println(l);
    }

}
