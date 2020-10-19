package server.demo2.echo_with_objects.messages;

import java.io.Serializable;

public class Message implements Serializable {

    private final String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}
