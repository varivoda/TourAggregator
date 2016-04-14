package controller.exceptions;

/**
 * Created by ivan on 13.04.16.
 * Ошибка, возникающая при отсутсвии запрашиваемого клиента
 * в базе данных
 */

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException() {
        super();
    }

    public AccountNotFoundException(String s) {
        super(s);
    }

    public AccountNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
