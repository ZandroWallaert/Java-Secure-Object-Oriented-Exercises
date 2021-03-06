package server.demo4.calc_with_double_dispatch;

import server.common.Config;
import server.demo4.calc_with_double_dispatch.messages.HandshakeMessage;
import server.demo4.calc_with_double_dispatch.messages.ProductMessage;
import server.demo4.calc_with_double_dispatch.messages.SumMessage;
import server.demo4.calc_with_double_dispatch.messages.TextMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Client().run();
    }

    private void run() throws IOException, ClassNotFoundException {
        try (
            Socket sock = new Socket(Config.ADDRESS, Config.PORT);
            ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
        ) {
            HandshakeMessage shake = new HandshakeMessage();
            oos.writeObject(shake);

            System.out.println(ois.readObject());

            TextMessage hello = new TextMessage("hello");
            oos.writeObject(hello);

            System.out.println(ois.readObject());

            SumMessage sum = new SumMessage(5, 3);
            oos.writeObject(sum);

            System.out.println(ois.readObject());

            ProductMessage prod = new ProductMessage(5, 3);
            oos.writeObject(prod);

            System.out.println(ois.readObject());
        }


    }

}
