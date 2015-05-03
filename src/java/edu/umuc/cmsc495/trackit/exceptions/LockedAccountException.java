package edu.umuc.cmsc495.trackit.exceptions;

/**
 * Exception for locked accounts.
 * @author CMSC 495 Web Inventory Team
 */
public class LockedAccountException extends Exception {

    /**
     * Creates a new instance of <code>LockedAccountException</code> without
     * detail message.
     */
    public LockedAccountException() {
    }

    /**
     * Constructs an instance of <code>LockedAccountException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LockedAccountException(String msg) {
        super(msg);
    }
}
