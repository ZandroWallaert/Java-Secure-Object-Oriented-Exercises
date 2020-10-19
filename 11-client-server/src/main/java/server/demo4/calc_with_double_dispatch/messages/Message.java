package server.demo4.calc_with_double_dispatch.messages;

import java.io.IOException;
import java.io.Serializable;

public abstract class Message implements Serializable {

    public abstract void accept(MessageHandler handler) throws IOException;

}
