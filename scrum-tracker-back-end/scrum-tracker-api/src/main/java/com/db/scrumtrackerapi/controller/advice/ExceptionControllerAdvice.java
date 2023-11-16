package com.db.scrumtrackerapi.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.db.scrumtrackerapi.model.ErrorMessage;
import jakarta.persistence.EntityExistsException;

@ControllerAdvice
public class ExceptionControllerAdvice {
    
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErrorMessage> handleEntityExistsException(EntityExistsException ex) {      
        ErrorMessage response = new ErrorMessage("Entity already exists on database.", HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNameNotFoundExcepiton(UsernameNotFoundException ex) {
        ErrorMessage response = new ErrorMessage("Email wasn't registered on database.", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> serverError(Exception ex) {
        ErrorMessage response = new ErrorMessage("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
