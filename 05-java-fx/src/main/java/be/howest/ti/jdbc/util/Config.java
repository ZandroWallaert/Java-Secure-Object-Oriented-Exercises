package be.howest.ti.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private static final String CONFIG_FILE = "/config/config.properties";

    private static final Config INSTANCE = new Config();

    private Properties properties = new Properties();

    private Config() {
        try (InputStream ris = getClass().getResourceAsStream(CONFIG_FILE)) {
            properties.load(ris);
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                    "Unable to load config file", ex);
            throw new ShopException("Unable to load configuration.");
        }
    }

    public String readSetting(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String readSetting(String key) {
        return readSetting(key, null);
    }

    public static Config getInstance() {
        return INSTANCE;
    }

}
