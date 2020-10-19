package server.demo4.calc_with_double_dispatch.messages;

import java.io.IOException;

public class SumMessage extends TwoNumberMessage {

    public SumMessage(int number1, int number2) {
        super(number1, number2);
    }

    @Override
    public void accept(MessageHandler handler) throws IOException {
        handler.handleSumMessage(this);
    }
}
