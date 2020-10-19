package server.demo2.echo_with_objects;

import server.common.Config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Server().run();
    }

    private void run() throws IOException, ClassNotFoundException {
        Logger.getAnonymousLogger().info("Initializing server...");

        try (
            ServerSocket serverSock = new ServerSocket(Config.PORT);
            Socket sock = serverSock.accept();
            ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
        ) {
            Logger.getAnonymousLogger().info("Connection established!");

            while (true) {
                oos.writeObject(ois.readObject());
            }
        }
    }

}
