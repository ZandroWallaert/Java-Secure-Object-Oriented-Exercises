package server.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

public class SumMessage extends TwoNumberMessage {

    @JsonCreator
    public SumMessage(
            @JsonProperty("number1") int number1,
            @JsonProperty("number2") int number2
    ) {
        super(number1, number2);
    }

    @Override
    public void accept(MessageHandler handler) throws IOException {
        handler.handleSumMessage(this);
    }
}
