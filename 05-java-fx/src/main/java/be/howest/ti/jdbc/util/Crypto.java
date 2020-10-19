package be.howest.ti.jdbc.util;

import org.jasypt.util.text.StrongTextEncryptor;

public class Crypto {

    private static final String KEY = "HELLO-FROM-HOWEST";

    private static final Crypto INSTANCE = new Crypto();

    private StrongTextEncryptor encryptor = new StrongTextEncryptor();

    private Crypto() {
        encryptor.setPassword(KEY);
    }

    public String encrypt(String in) {
        return encryptor.encrypt(in);
    }

    public String decrypt(String in) {
        return encryptor.decrypt(in);
    }

    public static Crypto getInstance() {
        return INSTANCE;
    }
}
