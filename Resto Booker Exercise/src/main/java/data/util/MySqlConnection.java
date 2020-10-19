package data.util;

import util.Config;
import util.Crypto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        URL = Config.getInstance().readSetting(Config.KEY_DB_URL);

        String usernameEncrypted = Config.getInstance().readSetting(Config.KEY_DB_USERNAME);
        USERNAME = Crypto.getInstance().decrypt(usernameEncrypted);

        String passwordEncrypted = Config.getInstance().readSetting(Config.KEY_DB_PASSWORD);
        PASSWORD = Crypto.getInstance().decrypt(passwordEncrypted);
    }

    private MySqlConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
