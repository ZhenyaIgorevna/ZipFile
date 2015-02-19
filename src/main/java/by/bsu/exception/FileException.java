package by.bsu.exception;

/**
 * Created by Yauheniya_Neliub on 1/23/2015.
 */
public class FileException extends Exception {
    public FileException() {
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
