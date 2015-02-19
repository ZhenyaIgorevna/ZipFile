package by.nelyub.exception;

/**
 * Class of exception which can be throw in dao class.
 */
public class DaoException extends Exception{
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {

        super(message, cause);
    }
}
