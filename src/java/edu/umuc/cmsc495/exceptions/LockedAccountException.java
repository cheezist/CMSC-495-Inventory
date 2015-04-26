/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umuc.cmsc495.exceptions;

/**
 *
 * @author Christian
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
