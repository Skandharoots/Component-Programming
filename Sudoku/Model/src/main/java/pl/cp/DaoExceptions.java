package pl.cp;

public class DaoExceptions extends RuntimeException {

    public DaoExceptions(String message) {
        super(message);
    }

    public DaoExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}
