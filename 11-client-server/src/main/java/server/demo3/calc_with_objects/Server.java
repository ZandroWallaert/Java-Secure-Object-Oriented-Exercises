package server.demo3.calc_with_objects;

import server.common.Config;
import server.demo3.calc_with_objects.messages.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Server().run();
    }

    private void run() throws IOException, ClassNotFoundException {
        try (
            ServerSocket serverSock = new ServerSocket(Config.PORT);
            Socket sock = serverSock.accept();
            ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(sock.getInputStream())
        ) {
            while (true) {
                Message msg = (Message) ois.readObject();

                if (msg instanceof HandshakeMessage) {
                    oos.writeObject(new HandshakeMessage());
                } else if (msg instanceof TextMessage) {
                    oos.writeObject(msg); // echo server
                } else if (msg instanceof ProductMessage) {
                    ProductMessage prodMsg = (ProductMessage) msg;

                    int prod = prodMsg.getNumber1() * prodMsg.getNumber2();

                    ResultMessage res = new ResultMessage(prod);

                    oos.writeObject(res);
                } else if (msg instanceof SumMessage) {
                    SumMessage sumMsg = (SumMessage) msg;

                    int sum = sumMsg.getNumber1() + sumMsg.getNumber2();

                    ResultMessage res = new ResultMessage(sum);

                    oos.writeObject(res);
                } else {
                    oos.writeObject(new TextMessage("Invalid command received"));
                }
            }
        }

    }

}
