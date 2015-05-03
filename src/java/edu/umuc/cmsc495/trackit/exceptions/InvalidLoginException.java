package edu.umuc.cmsc495.trackit.exceptions;

/**
 * Exception for invalid logins.
 * @author CMSC 495 Web Inventory Team
 */
public class InvalidLoginException extends Exception {

    /**
     * Creates a new instance of <code>InvalidLoginexception</code> without
     * detail message.
     */
    public InvalidLoginException() {
    }

    /**
     * Constructs an instance of <code>InvalidLoginexception</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidLoginException(String msg) {
        super(msg);
    }
}
