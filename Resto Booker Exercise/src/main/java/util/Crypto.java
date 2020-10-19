package util;

import org.jasypt.util.text.StrongTextEncryptor;

public class Crypto {

    private static final String KEY = "HELLO-FROM-HOWEST";
    private static final Crypto INSTANCE = new Crypto();

    private final StrongTextEncryptor encryptor = new StrongTextEncryptor();

    private Crypto() {
        encryptor.setPassword(KEY);
    }

    public static Crypto getInstance() {
        return INSTANCE;
    }

    public String encrypt(String data) {
        return encryptor.encrypt(data);
    }

    public String decrypt(String data) {
        return encryptor.decrypt(data);
    }

}
