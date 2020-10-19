package server.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

public class ResultMessage extends Message {

    private final int result;

    @JsonCreator
    public ResultMessage(@JsonProperty("result") int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }

    @Override
    public void accept(MessageHandler handler) throws IOException {
        handler.handleResultMessage(this);
    }
}
