package server.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

public class TextMessage extends Message {

    private final String message;

    @JsonCreator
    public TextMessage(@JsonProperty("message") String message) {
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
