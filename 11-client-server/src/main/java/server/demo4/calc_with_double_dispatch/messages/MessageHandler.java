package server.demo4.calc_with_double_dispatch.messages;

import java.io.IOException;

public interface MessageHandler {

    void handleHandshakeMessage(HandshakeMessage msg) throws IOException;
    void handleSumMessage(SumMessage msg) throws IOException;
    void handleProductMessage(ProductMessage msg) throws IOException;
    void handleTextMessage(TextMessage msg) throws IOException;
    void handleResultMessage(ResultMessage msg) throws IOException;

}
