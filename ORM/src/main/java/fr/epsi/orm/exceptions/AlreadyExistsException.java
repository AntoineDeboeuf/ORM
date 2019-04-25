package fr.epsi.orm.exceptions;

public class AlreadyExistsException extends Exception {

    private static final long serialVersionUID = 4466964357831306478L;

    public AlreadyExistsException(String message) {
        super(message);
    }
}
