package be.howest.ti.jdbc.util;

public class ShopException extends RuntimeException {

    public ShopException() {
        super();
    }

    public ShopException(String message) {
        super(message);
    }

    public ShopException(String message, Throwable t) {
        super(message, t);
    }

}
