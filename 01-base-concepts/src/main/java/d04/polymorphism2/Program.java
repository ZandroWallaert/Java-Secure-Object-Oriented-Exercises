package d04.polymorphism2;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        ElectricalDevice a = new Laptop(99);
        ElectricalDevice b = new ReadingLight(1000);

        a.powerOn();
        b.powerOn();
    }

}
