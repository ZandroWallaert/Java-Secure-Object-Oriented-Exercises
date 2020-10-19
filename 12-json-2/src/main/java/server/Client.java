package server;

import server.common.Config;
import server.messages.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {

    private int id;

    public Client(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try (
            Socket sock = new Socket(Config.ADDRESS, Config.PORT);
        ) {
            MessageIO io = new MessageIO(sock);

            HandshakeMessage shake = new HandshakeMessage();
            io.writeMessage(shake);

            System.out.println(id + "> " + io.readMessage());

            TextMessage hello = new TextMessage("hello");
            io.writeMessage(hello);

            System.out.println(id + "> " + io.readMessage());

            SumMessage sum = new SumMessage(5, 3);
            io.writeMessage(sum);

            System.out.println(id + "> " + io.readMessage());

            ProductMessage prod = new ProductMessage(5, 3);
            io.writeMessage(prod);

            System.out.println(id + "> " + io.readMessage());
        } catch (IOException ex) {
            throw new ConnectionException("Error in client connection.");
        }

    }

}
