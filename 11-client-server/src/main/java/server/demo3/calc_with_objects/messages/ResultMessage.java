package server.demo3.calc_with_objects.messages;

public class ResultMessage extends Message {

    private final int result;

    public ResultMessage(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}
