package server;

import server.messages.*;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements MessageHandler, Runnable {

    private final MessageIO io;

    Connection(Socket socket) {
        try {
            io = new MessageIO(socket);
        } catch (IOException ex) {
            throw new ConnectionException("Unable to initialize connection.");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = io.readMessage();
                msg.accept(this);
            }
        } catch (EOFException ex) {
            // ignore
        } catch (IOException  ex) {
            throw new ConnectionException("Unable to process connection.");
        }
    }

    @Override
    public void handleHandshakeMessage(HandshakeMessage msg) throws IOException {
        io.writeMessage(msg);
    }

    @Override
    public void handleSumMessage(SumMessage msg) throws IOException {
        io.writeMessage(new ResultMessage(msg.getNumber1() + msg.getNumber2()));
    }

    @Override
    public void handleProductMessage(ProductMessage msg) throws IOException {
        io.writeMessage(new ResultMessage(msg.getNumber1() * msg.getNumber2()));
    }

    @Override
    public void handleTextMessage(TextMessage msg) throws IOException {
        io.writeMessage(msg);
    }

    @Override
    public void handleResultMessage(ResultMessage msg) throws IOException {
        io.writeMessage(new TextMessage("Unable to handle result message"));
    }
}
