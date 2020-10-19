package server;

import server.common.Config;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private ServerSocket serverSock;

    Server() throws IOException {
        serverSock = new ServerSocket(Config.PORT);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket sock = serverSock.accept();
                Connection con = new Connection(sock);

                new Thread(con).start(); // connection implements Runnable, no method reference needed.
            } catch (IOException ex) {
                throw new ConnectionException("Unable to create connection.");
            }
        }
    }

}
