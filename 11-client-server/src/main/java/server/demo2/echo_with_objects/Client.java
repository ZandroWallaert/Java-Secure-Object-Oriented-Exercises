package server.demo2.echo_with_objects;

import server.common.Config;
import server.demo2.echo_with_objects.messages.Message;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Client().run();
    }

    private void run() throws IOException, ClassNotFoundException {
        try (
            Scanner stdIn = new Scanner(System.in);
            Socket sock = new Socket(Config.ADDRESS, Config.PORT);
            ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
        ) {
            String line = stdIn.nextLine();

            while (!line.equals("STOP")) {
                Message out = new Message(line);
                oos.writeObject(out);
                Message in = (Message) ois.readObject();
                System.out.println(in);

                line = stdIn.nextLine();
            }
        }
    }

}
