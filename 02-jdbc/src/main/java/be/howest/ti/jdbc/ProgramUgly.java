package be.howest.ti.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramUgly {

    private static final String URL = "jdbc:mysql://localhost/howest-shop?serverTimezone=UTC";
    private static final String USERNAME = "howest-shop-user";
    private static final String PASSWORD = "howest-shop-password";

    private static final String SQL_ADD_PRODUCT = "insert into product(name, price) values(?, ?)";
    private static final String SQL_GET_PRODUCTS = "select * from product";

    public static void main(String[] args) {
        new ProgramUgly().run();
    }

    private void run() {
        addProduct("smartphone", 599);
        addProduct("laptop", 799);
        addProduct("tablet", 399);

        List<String> products = getProducts();

        for (String product : products) {
            System.out.println(product);
        }
    }

    private void addProduct(String name, double price) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(SQL_ADD_PRODUCT)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("An error occured adding the product.");
        }
    }

    private List<String> getProducts() {
        List<String> products = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(SQL_GET_PRODUCTS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                products.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println("An error retrieving the products.");
        }

        return products;
    }

}
