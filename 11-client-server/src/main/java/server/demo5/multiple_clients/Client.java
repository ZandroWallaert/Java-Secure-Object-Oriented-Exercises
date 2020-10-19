package server.demo5.multiple_clients;

import server.common.Config;
import server.demo5.multiple_clients.messages.HandshakeMessage;
import server.demo5.multiple_clients.messages.ProductMessage;
import server.demo5.multiple_clients.messages.SumMessage;
import server.demo5.multiple_clients.messages.TextMessage;

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
            ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
        ) {
            HandshakeMessage shake = new HandshakeMessage();
            oos.writeObject(shake);

            System.out.println(id + "> " + ois.readObject());

            TextMessage hello = new TextMessage("hello");
            oos.writeObject(hello);

            System.out.println(id + "> " + ois.readObject());

            SumMessage sum = new SumMessage(5, 3);
            oos.writeObject(sum);

            System.out.println(id + "> " + ois.readObject());

            ProductMessage prod = new ProductMessage(5, 3);
            oos.writeObject(prod);

            System.out.println(id + "> " + ois.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            throw new ConnectionException("Error in client connection.");
        }

    }

}
