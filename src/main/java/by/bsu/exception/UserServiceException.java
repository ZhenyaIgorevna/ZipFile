package by.bsu.exception;

/**
 * Created by Yauheniya_Neliub on 2/27/2015.
 */
public class UserServiceException extends RuntimeException {

    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
