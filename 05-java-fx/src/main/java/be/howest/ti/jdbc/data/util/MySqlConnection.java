package be.howest.ti.jdbc.data.util;

import be.howest.ti.jdbc.util.Config;
import be.howest.ti.jdbc.util.Crypto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";

    private static String url;
    private static String username;
    private static String password;

    static {
        url = Config.getInstance().readSetting(DB_URL);
        username = Crypto.getInstance().decrypt(
                Config.getInstance().readSetting(DB_USERNAME));
        password = Crypto.getInstance().decrypt(
                Config.getInstance().readSetting(DB_PASSWORD)
        );
    }

    private MySqlConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);  // NOSONAR
    }

}
