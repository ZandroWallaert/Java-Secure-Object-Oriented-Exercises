package server.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.ConnectionException;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageIO {

    private final OutputStream out;
    private final InputStream in;

    private final ObjectMapper json;

    public MessageIO(Socket socket) throws IOException {
        this.out = socket.getOutputStream();
        this.in = socket.getInputStream();
        this.json = new ObjectMapper()
                .configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false)
                .configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);

    }

    public void writeMessage(Message msg) {
        try {
            json.writeValue(out, msg);
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to write msg:", ex);
        }
    }

    public Message readMessage() {
        try {
            return json.readValue(in, Message.class);
        } catch (EOFException ex) {
            // ignore
            return null;
        } catch (IOException ex) {

            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to read msg:", ex);
            throw new ConnectionException("Unable to process connection.");

        }
    }

}
