package controller.exceptions;

/**
 * Created by ivan on 14.04.16.
 */
public class RentCarServiceException extends Exception {

    public RentCarServiceException() {
    }

    public RentCarServiceException(String s) {
        super(s);
    }

    public RentCarServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public RentCarServiceException(Throwable throwable) {
        super(throwable);
    }

    public RentCarServiceException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
