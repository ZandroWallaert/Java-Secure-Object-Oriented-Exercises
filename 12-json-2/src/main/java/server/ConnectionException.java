package server;

public class ConnectionException extends RuntimeException {

    public ConnectionException() {
    }

    public ConnectionException(String msg) {
        super(msg);
    }

}
