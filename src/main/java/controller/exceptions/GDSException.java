package controller.exceptions;

/**
 * Created by ivan on 14.04.16.
 * Исключение, возникающее при некорректной работе с глобальной дистрибьютерской системой
 */
public class GDSException extends Exception {

    public GDSException() {
    }

    public GDSException(String s) {
        super(s);
    }

    public GDSException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GDSException(Throwable throwable) {
        super(throwable);
    }

    public GDSException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
