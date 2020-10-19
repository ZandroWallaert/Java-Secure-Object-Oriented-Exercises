package server.demo5.multiple_clients.messages;

import java.io.IOException;

public class HandshakeMessage extends Message {

    @Override
    public String toString() {
        return "HELLO";
    }

    @Override
    public void accept(MessageHandler handler) throws IOException {
        handler.handleHandshakeMessage(this);
    }
}
