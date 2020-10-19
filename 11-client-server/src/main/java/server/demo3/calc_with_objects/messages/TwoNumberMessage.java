package server.demo3.calc_with_objects.messages;

public abstract class TwoNumberMessage extends Message {

    private final int number1;
    private final int number2;

    public TwoNumberMessage(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", number1, number2);
    }
}
