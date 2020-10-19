package server.demo5.multiple_clients.messages;

import java.io.IOException;
import java.io.Serializable;

public abstract class Message implements Serializable {

    public abstract void accept(MessageHandler handler) throws IOException;

}
