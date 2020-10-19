package be.howest.ti.shop.data;

import be.howest.ti.shop.domain.Category;
import be.howest.ti.shop.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MockRepositoryTest {


    @BeforeEach
    void initRepo() {
        Repositories.setRepository(new MockRepository());

    }

    @Test
    void getAllProducts() {
        Repository repo = Repositories.getCurrentRepository();
        int oldSize = repo.getAllProducts().size();
        Product p = new Product("p1",0, true, 21, repo.getCategoryByName("c1"));
        repo.addProduct(p);
        assertEquals(oldSize+1, repo.getAllProducts().size());
        assertTrue(repo.getAllProducts().contains(p));
    }
}