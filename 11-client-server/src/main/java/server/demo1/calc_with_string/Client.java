package server.demo1.calc_with_string;

import server.common.Config;

import java.io.IOException;
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
            PrintStream sockOut = new PrintStream(sock.getOutputStream());
        ) {
            String input = stdIn.nextLine();
            while (!input.equals("STOP")) {
                sockOut.println(input);
                String result = sockIn.nextLine();
                System.out.println(result);
                input = stdIn.nextLine();
            }
        }
    }

}
