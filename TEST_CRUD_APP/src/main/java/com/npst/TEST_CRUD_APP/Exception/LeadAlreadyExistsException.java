package com.npst.TEST_CRUD_APP.Exception;

public class LeadAlreadyExistsException extends RuntimeException {

    public LeadAlreadyExistsException(String message) {
        super(message);
    }
}