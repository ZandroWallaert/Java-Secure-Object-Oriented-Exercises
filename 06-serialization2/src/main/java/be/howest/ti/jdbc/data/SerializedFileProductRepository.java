package be.howest.ti.jdbc.data;

import be.howest.ti.jdbc.domain.Product;
import be.howest.ti.jdbc.util.ShopException;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class SerializedFileProductRepository implements ProductRepository {

    private static final String DATA_FILE = "./data/products.ser";

    @Override
    public List<Product> getProducts() {
        File file = getFile();

        if (file.exists()) {
            return readFromFile(file);
        } else {
            return Collections.emptyList();
        }
    }

    private List<Product> readFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getAnonymousLogger().severe(ex.getMessage());
            throw new ShopException("Unable to get products.");
        }
    }

    @Override
    public void addProduct(Product product) {
        ArrayList<Product> products = new ArrayList<>(getProducts());
        products.add(product);

        File file = getFile();

        try (FileOutputStream fos = new FileOutputStream(file, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(products);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().severe(ex.getMessage());
            throw new ShopException("Unable to add product");
        }
    }

    private File getFile() {
        return new File(DATA_FILE);
    }

}
