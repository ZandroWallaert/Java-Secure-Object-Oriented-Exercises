package util;

public class RestoException extends RuntimeException {

    public RestoException() {
    }

    public RestoException(String message) {
        super(message);
    }

    public RestoException(String message, Throwable t) {
        super(message, t);
    }

}
