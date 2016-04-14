package controller.exceptions;

/**
 * Created by ivan on 11.04.16.
 */
public class InvalidDataException extends Exception {

    public InvalidDataException() {
        super();
    }

    public InvalidDataException(String s) {
        super(s);
    }

    public InvalidDataException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidDataException(Throwable throwable) {
        super(throwable);
    }
}
