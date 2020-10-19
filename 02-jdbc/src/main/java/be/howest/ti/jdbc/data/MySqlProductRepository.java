package be.howest.ti.jdbc.data;

import be.howest.ti.jdbc.data.util.MySqlConnection;
import be.howest.ti.jdbc.domain.Product;
import be.howest.ti.jdbc.util.ShopException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlProductRepository implements ProductRepository {

    private static final String SQL_GET_PRODUCTS = "select * from product";
    private static final String SQL_ADD_PRODUCT = "insert into product(name, price) values(?, ?)";

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public List<Product> getProducts() {
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_GET_PRODUCTS);
             ResultSet rs = stmt.executeQuery()) {

            List<Product> products = new ArrayList<>();

            while (rs.next()) {
                Product product = resultSetToProduct(rs);
                products.add(product);
            }

            return products;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new ShopException("Unable to retrieve products from database.");
        }
    }

    @Override
    public void addProduct(Product product) {
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_ADD_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());

            stmt.executeUpdate();

            try (ResultSet autoId = stmt.getGeneratedKeys()) {
                autoId.next();
                product.setId(autoId.getInt(1));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw new ShopException("Unable to add product to database.");
        }
    }

    private Product resultSetToProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
    }

}
