package controller.exceptions;

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