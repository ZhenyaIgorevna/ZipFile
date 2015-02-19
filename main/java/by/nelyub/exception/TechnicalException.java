package by.nelyub.exception;

/**
 * Class of exception which can be throw if app work incorrect.
 */
public class TechnicalException extends RuntimeException {
    public TechnicalException() {
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
