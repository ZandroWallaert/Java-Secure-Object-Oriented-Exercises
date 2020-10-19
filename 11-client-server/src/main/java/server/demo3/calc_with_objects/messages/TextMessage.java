package server.demo3.calc_with_objects.messages;

public class TextMessage extends Message {

    private final String message;

    public TextMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

}
