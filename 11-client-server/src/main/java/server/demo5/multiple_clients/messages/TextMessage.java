package server.demo5.multiple_clients.messages;

import java.io.IOException;

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

    @Override
    public void accept(MessageHandler handler) throws IOException {
        handler.handleTextMessage(this);
    }
}
