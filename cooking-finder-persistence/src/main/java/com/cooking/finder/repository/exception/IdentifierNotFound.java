package com.cooking.finder.repository.exception;

/**
 * Created by Igor on 15.10.2016.
 */
public class IdentifierNotFound extends RuntimeException {

    public IdentifierNotFound(String msg) {
        super(msg);
    }
}
