package server.demo0.echo_with_string;

import server.common.Config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        new Client().run();
    }

    private void run() throws IOException {
        try (
                Scanner stdIn = new Scanner(System.in);
                Socket sock = new Socket(Config.ADDRESS, Config.PORT);
                Scanner sockIn = new Scanner(sock.getInputStream());
                PrintStream sockOut = new PrintStream(sock.getOutputStream())
        ) {
            String input = stdIn.nextLine();

            while (!input.equals("STOP")) {
                sockOut.println(input);
                String response = sockIn.nextLine();
                System.out.printf("Server responded with: %s%n", response);
                input = stdIn.nextLine();
            }
        }

    }

}
