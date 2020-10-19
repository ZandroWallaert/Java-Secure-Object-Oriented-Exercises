package server.messages;


import java.io.IOException;

public class MessageHandlerAdapter  implements MessageHandler {
    @Override
    public void handleHandshakeMessage(HandshakeMessage msg) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handleSumMessage(SumMessage msg) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handleProductMessage(ProductMessage msg) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handleTextMessage(TextMessage msg) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handleResultMessage(ResultMessage msg) throws IOException {
        throw new UnsupportedOperationException();
    }
}
