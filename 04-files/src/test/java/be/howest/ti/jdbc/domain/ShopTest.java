package be.howest.ti.jdbc.domain;

import be.howest.ti.jdbc.data.InMemoryProductRepository;
import be.howest.ti.jdbc.data.ProductRepository;
import be.howest.ti.jdbc.util.ShopException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


class ShopTest {

    private static ProductRepository repo;

    private Shop s;
    private Product p1;
    private Product p2;
    private Product p3;


    @BeforeAll
    static void createProductRepo() {
        Logger.getAnonymousLogger().info("In createProductRepo");
        repo = new InMemoryProductRepository();
        repo.addProduct(new Product("smartphone", 599));
        repo.addProduct(new Product("laptop", 799));
        repo.addProduct(new Product("tablet", 399));
    }

    @BeforeEach
    void createShop() {
        Logger.getAnonymousLogger().info("In createShop");
        List<Product> all = repo.getProducts();

        assertTrue(all.size() >= 3, "Need at least 3 products for this test");

        p1 = all.get(0);
        p2 = all.get(1);
        p3 = all.get(2);

        s = new Shop();
        s.restock(p1, 3);
        s.restock(p2, 1);
    }

    @Test
    void buy() {
        s.buy(p1);
        s.buy(p1);
        s.buy(p1);

        assertThrows(ShopException.class, () -> s.buy(p1));

        s.buy(p2);

        assertThrows(ShopException.class, () -> s.buy(p3));
    }

    @Test
    void restockNegative() {
        assertThrows(IllegalArgumentException.class, () -> s.restock(p1, -3));
    }

    @Test
    void findByName() {
        assertEquals(p1, s.findByName(p1.getName()));
        assertEquals(p2, s.findByName(p2.getName()));
        assertNull(s.findByName(p3.getName()));
    }
}