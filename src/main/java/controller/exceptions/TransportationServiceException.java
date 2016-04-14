package controller.exceptions;

/**
 * Created by ivan on 14.04.16.
 * Исключение, возникающее при некорректной работе с сервисом транспортировки
 */
public class TransportationServiceException extends Exception {

    public TransportationServiceException() {
    }

    public TransportationServiceException(String s) {
        super(s);
    }

    public TransportationServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TransportationServiceException(Throwable throwable) {
        super(throwable);
    }

    public TransportationServiceException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
