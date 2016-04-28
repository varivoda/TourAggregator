package controller.exceptions;

/**
 * Created by ivan on 14.04.16.
 * Исключение, возникающее при некорректной работе с сервисом по бронированию отелей
 */
public class ResidentLocationServiceException extends Exception {

    public ResidentLocationServiceException() {
    }

    public ResidentLocationServiceException(String s) {
        super(s);
    }

    public ResidentLocationServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ResidentLocationServiceException(Throwable throwable) {
        super(throwable);
    }

    public ResidentLocationServiceException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
