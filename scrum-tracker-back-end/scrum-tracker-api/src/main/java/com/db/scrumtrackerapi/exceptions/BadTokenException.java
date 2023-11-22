package com.db.scrumtrackerapi.exceptions;

public class BadTokenException extends RuntimeException {
    
    public BadTokenException(String message) {
        super(message);
    }
}
