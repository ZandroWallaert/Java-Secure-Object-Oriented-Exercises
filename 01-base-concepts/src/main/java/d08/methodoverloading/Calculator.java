package d08.methodoverloading;

public class Calculator {

    public Calculator() {
    }

    public int calcSum(int a, int b) {
        return a + b;
    }

    public int calcSum(int a, int b, int c) {
        return a + b + c;
    }

}
