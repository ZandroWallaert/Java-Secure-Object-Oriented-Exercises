package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    public static final String KEY_DB_URL = "db.url";
    public static final String KEY_DB_USERNAME = "db.username";
    public static final String KEY_DB_PASSWORD = "db.password";
    public static final String KEY_BOOKINGS_FILE = "bookings.file";

    private static final String CONFIG_FILE = "/config/config.properties";
    private static final Config INSTANCE = new Config();
    private Properties properties = new Properties();

    private Config() {
        try (InputStream ris = getClass().getResourceAsStream(CONFIG_FILE)) {
            properties.load(ris);
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                    "Unable to read config file", ex);
            throw new RestoException("Unable to load configuration.");
        }
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public String readSetting(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String readSetting(String key) {
        return readSetting(key, null);
    }

    public void writeSetting(String key, String value) {
        properties.setProperty(key, value);
        storeSettingsToFile();
    }

    private void storeSettingsToFile() {
        String path = getClass().getResource(CONFIG_FILE).getPath();

        try (FileOutputStream fos = new FileOutputStream(path)) {
            properties.store(fos, null);
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                    "Unable to write config file", ex);
            throw new RestoException("Unable to save configuration.");
        }
    }

}
