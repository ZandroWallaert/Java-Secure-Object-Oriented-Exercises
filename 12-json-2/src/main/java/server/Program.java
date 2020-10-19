package server;

import java.io.IOException;

public class Program {

    private static final int NUM_CLIENTS = 3;

    public static void main(String[] args) throws IOException {
        new Program().run();
    }

    private void run() throws IOException {
        Server svr = new Server();
        svr.start();

        for (int i = 0; i < NUM_CLIENTS; i++) {
            Client cli = new Client(i);
            cli.start();
        }
    }
}
