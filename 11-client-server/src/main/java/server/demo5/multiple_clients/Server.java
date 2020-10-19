package server.demo5.multiple_clients;

import server.common.Config;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {

    private ServerSocket serverSock;
    private List<Connection> connections = new ArrayList<>();

    public Server() throws IOException {
        serverSock = new ServerSocket(Config.PORT);
    }

    public void run() {
        while (true) {
            try {
                Socket sock = serverSock.accept();
                Connection con = new Connection(connections.size(), sock);

                new Thread(con::run).start();
            } catch (IOException ex) {
                throw new ConnectionException("Unable to create connection.");
            }
        }
    }

}
