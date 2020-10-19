package server.demo4.calc_with_double_dispatch;

import server.common.Config;
import server.demo4.calc_with_double_dispatch.messages.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements MessageHandler {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Server().run();
    }

    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private void run() throws IOException, ClassNotFoundException {
        try (
            ServerSocket serverSock = new ServerSocket(Config.PORT);
            Socket sock = serverSock.accept();
        ) {
            oos = new ObjectOutputStream(sock.getOutputStream());
            ois = new ObjectInputStream(sock.getInputStream());

            while (true) {
                Message msg = (Message) ois.readObject();
                msg.accept(this);
            }
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
