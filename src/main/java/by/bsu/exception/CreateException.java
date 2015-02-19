package by.bsu.exception;

/**
 * Created by Yauheniya_Neliub on 2/12/2015.
 */
public class CreateException extends Exception {
    public CreateException() {
    }

    public CreateException(String message) {
        super(message);
    }

    public CreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
