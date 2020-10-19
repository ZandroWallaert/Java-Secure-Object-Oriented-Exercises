package be.howest.ti.jdbc.data.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static final String URL = "jdbc:mysql://localhost/howest-shop?serverTimezone=UTC";
    private static final String USERNAME = "sooa";
    private static final String PASSWORD = "ilovejava"; // NOSONAR

    private MySqlConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);  // NOSONAR
    }

}
