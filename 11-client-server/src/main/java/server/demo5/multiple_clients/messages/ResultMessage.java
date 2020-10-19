package server.demo5.multiple_clients.messages;

import java.io.IOException;

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

    @Override
    public void accept(MessageHandler handler) throws IOException {
        handler.handleResultMessage(this);
    }
}
