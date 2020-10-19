package server.demo4.calc_with_double_dispatch.messages;

import java.io.IOException;

public class ProductMessage extends TwoNumberMessage {

    public ProductMessage(int number1, int number2) {
        super(number1, number2);
    }


    @Override
    public void accept(MessageHandler handler) throws IOException {
        handler.handleProductMessage(this);
    }
}
