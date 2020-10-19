package d01.objects;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Laptop macbookFrederic = new Laptop("Apple", "spaceGray", 13.0);
        Laptop lenovoMattias = new Laptop("Lenovo", "black", 15.0);

        System.out.println(macbookFrederic);
        System.out.println("-----------------------------");
        System.out.println(lenovoMattias);
    }

}
