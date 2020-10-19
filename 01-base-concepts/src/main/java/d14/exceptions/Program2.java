package d14.exceptions;

public class Program2 {

    public static void main(String[] args) {
        new Program2().run();
    }

    private void run() {
        try {
            int i = Integer.parseInt("123");
            int j = Integer.parseInt("Frédéric");
        } catch (NumberFormatException ex) {
            System.out.println("Oops!");
        }
    }
}
