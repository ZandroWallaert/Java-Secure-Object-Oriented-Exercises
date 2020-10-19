package be.howest.ti.shop.data;

import be.howest.ti.shop.domain.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @BeforeEach
    public void initRepo() {
        Repositories.setRepository(new MockRepository());
    }

    @Test
    public void toJSON() throws JsonProcessingException {
        Product out = Repositories.getCurrentRepository().getAllProducts().get(0);
        ObjectMapper json = new ObjectMapper();

        String jsonString = json.writeValueAsString(out);
        Logger.getAnonymousLogger().info(jsonString);


        assertTrue(jsonString.contains("name"));
        assertTrue(jsonString.contains("price"));
        assertTrue(jsonString.contains("in-stock"));
        assertTrue(jsonString.contains("vat"));
        assertTrue(jsonString.contains("category"));

    }


    @Test
    public void fromJSON() throws JsonProcessingException {
        Product out = Repositories.getCurrentRepository().getAllProducts().get(0);
        ObjectMapper json = new ObjectMapper();

        String jsonString = json.writeValueAsString(out);
        Logger.getAnonymousLogger().info(jsonString);

        Product in = json.readValue(jsonString, Product.class);

        assertEquals(out, in);
    }

    @Test
    public void fromJSONWithCategory() throws JsonProcessingException {
        Product out = Repositories.getCurrentRepository().getAllProducts().get(0);
        ObjectMapper json = new ObjectMapper();

        String jsonString = json.writeValueAsString(out);
        Logger.getAnonymousLogger().info(jsonString);

        Product in = json.readValue(jsonString, Product.class);

        assertEquals(
                out.getCategory().getProducts().size(),
                in.getCategory().getProducts().size()
        );
    }

}