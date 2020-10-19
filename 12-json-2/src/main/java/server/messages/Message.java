package server.messages;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "message-type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HandshakeMessage.class, name = "handshake"),
        @JsonSubTypes.Type(value = ProductMessage.class, name = "product"),
        @JsonSubTypes.Type(value = ResultMessage.class, name = "result"),
        @JsonSubTypes.Type(value = SumMessage.class, name = "sum"),
        @JsonSubTypes.Type(value = TextMessage.class, name = "text")
})
public abstract class Message implements Serializable {

    public abstract void accept(MessageHandler handler) throws IOException;


    public static void main(String[] args) throws JsonProcessingException {
        ProductMessage product = new ProductMessage(123, 456);
        SumMessage sum = new SumMessage(456, 123);
        ObjectMapper json = new ObjectMapper();

        Logger.getAnonymousLogger().info(json.writeValueAsString(product));
        Logger.getAnonymousLogger().info(json.writeValueAsString(sum));
    }

}
