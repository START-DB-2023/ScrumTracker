package com.db.scrumtrackerapi.exceptions;

public class BadPasswordException extends RuntimeException {
    
    public BadPasswordException(String message) {
        super(message);
    }
}


