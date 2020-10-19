package be.howest.ti.jdbc.data;

import be.howest.ti.jdbc.domain.Product;
import be.howest.ti.jdbc.util.ShopException;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextFileProductRepository implements ProductRepository {

    private static final int[] VAT_CATEGORIES = {6, 12, 21};
    private static final String DIR_NAME = "./data";

    private static final FileFilter VAT_FILE_FILTER = f -> {
        try {
            return f.getName().contains(".txt") && file2Vat(f) > 0;
        } catch(NumberFormatException e) {
            return false;
        }
    };

    private static String vat2fileName(int vat) {
        return String.format("%d.txt", vat);
    }

    private static int file2Vat(File f) {
        String vatAsString = f.getName().replace(".txt","");
        return Integer.parseInt(vatAsString);
    }

    TextFileProductRepository() {
        for(int vat : VAT_CATEGORIES) {
            try {
                File f = new File(DIR_NAME, vat2fileName(vat));
                boolean createFile = f.createNewFile();
                if (createFile) {
                    Logger.getAnonymousLogger().log(Level.INFO,
                            "A file for a new TextFileProductRepository was created for vat: {0}", vat);
                } else {
                    Logger.getAnonymousLogger().log(Level.INFO,
                            "A file for a new TextFileProductRepository already existed for vat:{0}", vat);
                }
            } catch (IOException e) {
                throw new ShopException("Failed to create product repository:" + e.getMessage());
            }
        }

    }


    @Override
    public List<Product> getProducts() {
        List<Product> res = new ArrayList<>();

        File[] productFiles = new File(DIR_NAME).listFiles(VAT_FILE_FILTER);
        assert productFiles != null;
        for (File f : productFiles) {
            res.addAll(getProducts(f));
        }
        return res;
    }

    private List<Product> getProducts(File f) {
        int vat = file2Vat(f);
        try (Scanner in = new Scanner(new FileInputStream(f))) {
            List<Product> res = new ArrayList<>();
            while (in.hasNextLine()) {
                res.add(line2product(in.nextLine(), vat));
            }
            return res;
        } catch (FileNotFoundException e) {
            Logger.getAnonymousLogger().severe("File not found while getting products");
            throw new ShopException("Failed to getProducts");
        }
    }

    private Product line2product(String line, int vat) {
        String[] parts = line.split(";\t");
        if (parts.length != 3) {
            Logger.getAnonymousLogger().severe(() -> "Failed to parse product:" + line);
            throw new ShopException("Failed to read product");
        }

        try {
            return new Product(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    Double.parseDouble(parts[2]),
                    vat
            );
        } catch (NumberFormatException ex) {
            Logger.getAnonymousLogger().severe(() -> "Failed to parse product:" + line);
            throw new ShopException("Failed to read product");
        }
    }

    private String product2line(Product product) {
        return String.format(Locale.US, "%s;\t%s;\t%.2f",
                product.getId(),
                product.getName(),
                product.getPrice());
    }

    @Override
    public void addProduct(Product product) {
        int oldId = product.getId();
        int nextId = getNextId();

        try (PrintStream out =  new PrintStream(
                new FileOutputStream(
                        new File(DIR_NAME, String.format("%d.txt", product.getVAT())), true))) {
            product.setId(nextId);
            out.println(product2line(product));

        } catch (FileNotFoundException e) {
            Logger.getAnonymousLogger().severe("File not found while adding product");
            product.setId(oldId);
            throw new ShopException("Failed to addProduct");
        }
    }

    private int getNextId() {
        int maxId = 0;

        for (Product p : getProducts()) {
            maxId = Math.max(maxId, p.getId());
        }

        return maxId + 1;
    }
}
