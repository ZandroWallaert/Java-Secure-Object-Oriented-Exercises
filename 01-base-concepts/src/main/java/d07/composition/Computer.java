package d07.composition;

public class Computer {

    private CPU cpu;

    public Computer() {
        cpu = new CPU();
    }

    public int calcSum(int i, int j) {
        return cpu.calcSum(i, j);
    }

}
