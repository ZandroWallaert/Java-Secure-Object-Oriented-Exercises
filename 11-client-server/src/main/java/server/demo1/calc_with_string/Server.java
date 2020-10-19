package server.demo1.calc_with_string;

import server.common.Config;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) throws IOException {
        new Server().run();
    }

    private void run() throws IOException {
        Logger.getAnonymousLogger().info("Initializing server...");

        try (
                ServerSocket serverSock = new ServerSocket(Config.PORT);
                Socket sock = serverSock.accept();
                Scanner in = new Scanner(sock.getInputStream());
                PrintStream out = new PrintStream(sock.getOutputStream());
        ) {
            Logger.getAnonymousLogger().info("Connection established!");

            while (in.hasNextLine()) {
                String line = in.nextLine();

                if (line.equals("hello")) {
                    out.println("hello");
                } else if (line.startsWith("sum")) {
                    out.println(calcSum(line));
                } else if (line.startsWith("prod")) {
                    out.println(calcProd(line));
                } else {
                    out.printf("error: unknown command %s%n", line);
                }
            }
        }

        Logger.getAnonymousLogger().info("Terminating server...");
    }

    private int calcSum(String line) {
        String[] data = line.split(" ");

        int operand1 = Integer.parseInt(data[1]);
        int operand2 = Integer.parseInt(data[2]);

        return operand1 + operand2;
    }

    private int calcProd(String line) {
        String[] data = line.split(" ");

        int operand1 = Integer.parseInt(data[1]);
        int operand2 = Integer.parseInt(data[2]);

        return operand1 * operand2;
    }

}
