package d07.composition;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        Computer c = new Computer();

        int i = 5;
        int j = 3;

        System.out.println(c.calcSum(i, j));
    }

}
