package server.messages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class JsonMessages {

    @Test
    public void product() throws IOException {
        ProductMessage out = new ProductMessage(123, 456);
        ObjectMapper json = new ObjectMapper();

        String jsonString = json.writeValueAsString(out);
        Logger.getAnonymousLogger().info(jsonString);

        assertTrue(jsonString.contains("\"message-type\":\"product\""));
        Message in = json.readValue(jsonString, Message.class);

        assertEquals(in.getClass(), ProductMessage.class);

    in.accept(new MessageHandlerAdapter() {

            @Override
            public void handleProductMessage(ProductMessage msg) throws IOException {
                assertEquals(out.getNumber1(), msg.getNumber1());
                assertEquals(out.getNumber2(), msg.getNumber2());
            }

        });

    }

    @Test
    public void sum() throws IOException {
        SumMessage out = new SumMessage(123, 456);
        ObjectMapper json = new ObjectMapper();

        String jsonString = json.writeValueAsString(out);
        Logger.getAnonymousLogger().info(jsonString);

        assertTrue(jsonString.contains("\"message-type\":\"sum\""));
        Message in = json.readValue(jsonString, Message.class);

        assertEquals(in.getClass(), SumMessage.class);

        in.accept(new MessageHandlerAdapter() {

            @Override
            public void handleSumMessage(SumMessage msg) throws IOException {
                assertEquals(out.getNumber1(), msg.getNumber1());
                assertEquals(out.getNumber2(), msg.getNumber2());
            }

        });

    }

}