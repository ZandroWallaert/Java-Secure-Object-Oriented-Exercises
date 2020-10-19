package be.howest.ti.jdbc.ui.cli;

import org.jasypt.util.text.StrongTextEncryptor;

public class Program {
    public static void main(String[] args) {
        StrongTextEncryptor encryptor = new StrongTextEncryptor();
        encryptor.setPassword("HELLO-FROM-HOWEST");

        String toEncrypt = "Frédéric";
        System.out.printf("To encrypt: %s%n", toEncrypt);

        String encrypted = encryptor.encrypt(toEncrypt);
        System.out.printf("Encrypted : %s%n", encrypted);

        String decrypted = encryptor.decrypt(encrypted);
        System.out.printf("Decrypted : %s%n", decrypted);
    }
}
