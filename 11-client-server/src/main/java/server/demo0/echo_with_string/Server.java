package server.demo0.echo_with_string;

import server.common.Config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) throws IOException {
        new Server().run();
    }

    private void run() throws IOException  {
        Logger.getAnonymousLogger().info("Initializing server...");

        try (
                ServerSocket serverSock = new ServerSocket(Config.PORT);
                Socket sock = serverSock.accept();
                Scanner in = new Scanner(sock.getInputStream());
                PrintStream out = new PrintStream(sock.getOutputStream())
        ) {
            Logger.getAnonymousLogger().info("Connection established!");

            while (in.hasNextLine()) {
                out.println(in.nextLine());
            }
        }

    }

}
