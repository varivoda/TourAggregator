package controller.exceptions;

/**
 * Created by ivan on 14.04.16.
 * Исключение, возникающее при некорректной работе с сервисом по бронированию отелей
 */
public class HotelServiceException extends Exception {

    public HotelServiceException() {
    }

    public HotelServiceException(String s) {
        super(s);
    }

    public HotelServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public HotelServiceException(Throwable throwable) {
        super(throwable);
    }

    public HotelServiceException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
