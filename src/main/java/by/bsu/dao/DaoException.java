package by.bsu.dao;

/**
 * Created by Yauheniya_Neliub on 2/24/2015.
 */
public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException() {
    }
}
