package server.demo5.multiple_clients;

import java.io.IOException;

public class Program {

    private static final int NUM_CLIENTS = 3;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Program().run();
    }

    private void run() throws IOException, ClassNotFoundException {
        Server svr = new Server();
        svr.start();

        for (int i = 0; i < NUM_CLIENTS; i++) {
            Client cli = new Client(i);
            cli.start();
        }
    }
}
