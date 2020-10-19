package server.demo5.multiple_clients;

import server.demo5.multiple_clients.messages.*;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection implements MessageHandler {

    private int id;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Connection(int id, Socket socket) {
        try {
            this.id = id;
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            throw new ConnectionException("Unable to initialize connection.");
        }
    }

    public void run() {
        try {
            while (true) {
                Message msg = (Message) ois.readObject();
                msg.accept(this);
            }
        } catch (EOFException ex) {
            // ignore
        } catch (IOException | ClassNotFoundException ex) {
            throw new ConnectionException("Unable to process connection.");
        }
    }

    @Override
    public void handleHandshakeMessage(HandshakeMessage msg) throws IOException {
        oos.writeObject(msg);
    }

    @Override
    public void handleSumMessage(SumMessage msg) throws IOException {
        oos.writeObject(new ResultMessage(msg.getNumber1() + msg.getNumber2()));
    }

    @Override
    public void handleProductMessage(ProductMessage msg) throws IOException {
        oos.writeObject(new ResultMessage(msg.getNumber1() * msg.getNumber2()));
    }

    @Override
    public void handleTextMessage(TextMessage msg) throws IOException {
        oos.writeObject(msg);
    }

    @Override
    public void handleResultMessage(ResultMessage msg) throws IOException {
        oos.writeObject(new TextMessage("Unable to handle result message"));
    }
}
