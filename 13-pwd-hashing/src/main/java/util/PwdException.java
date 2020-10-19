package util;

public class PwdException extends RuntimeException {

    public PwdException() {
    }

    public PwdException(String message) {
        super(message);
    }

    public PwdException(String message, Throwable t) {
        super(message, t);
    }

}
