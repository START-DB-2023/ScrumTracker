package com.db.scrumtrackerapi.controller.advice;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.db.scrumtrackerapi.model.ErrorMessage;
import jakarta.persistence.EntityExistsException;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> manipularExcecoesDeValidacao(ConstraintViolationException ex) {
        ErrorMessage response = new ErrorMessage("Validation failed.", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
    
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErrorMessage> handleEntityExistsException(EntityExistsException ex) {      
        ErrorMessage response = new ErrorMessage("Entity already exists on database.", HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorMessage> handleAuthenticationException(AuthenticationException ex) {
        ErrorMessage response = new ErrorMessage("Authentication failed", HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
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
