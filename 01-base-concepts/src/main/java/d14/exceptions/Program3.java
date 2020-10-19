package d14.exceptions;

public class Program3 {

    public static void main(String[] args) {
        new Program3().run();
    }

    private void run() {
        transferMoney("ABC", "XYZ", 1000);
        transferMoney("XYZ", "ABC", -25);
    }

    private void transferMoney(String fromAccount, String toAccount, double amount) {
        if (Math.signum(amount) > 0) {
            // transfer the money
        } else {
            throw new IllegalArgumentException("You may only transfer positive amounts.");
        }
    }

}
