package be.howest.ti.sooa.data;

import be.howest.ti.sooa.domain.Product;
import be.howest.ti.sooa.util.ShopException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SerializedProductRepository implements ProductRepository {
    private static final String DATA_FILE = "./data/products.ser";

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<Product> getProducts() {
        File file = new File(DATA_FILE);

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                List<Product> products = (List<Product>) ois.readObject();
                return Collections.unmodifiableList(products);
            } catch (IOException | ClassNotFoundException ex) {
                logger.log(Level.SEVERE, ex.getMessage());
                throw new ShopException("Unable to retrieve products.");
            }
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public void addProduct(Product product) {
        List<Product> products = new ArrayList<>(getProducts());
        products.add(product);

        File file = new File(DATA_FILE);

        try (FileOutputStream fos = new FileOutputStream(file, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new ShopException("Unable to add product.");
        }
    }
}
