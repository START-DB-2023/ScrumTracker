package com.db.scrumtrackerapi.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.db.scrumtrackerapi.exceptions.BadEmailException;
import com.db.scrumtrackerapi.exceptions.BadPasswordException;
import com.db.scrumtrackerapi.exceptions.EntityAlreadyExistsException;
import com.db.scrumtrackerapi.exceptions.EntityNotFoundException;
import com.db.scrumtrackerapi.model.dto.ErrorMessageDTO;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorMessageDTO response = new ErrorMessageDTO("Validation failed.", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(TokenExpiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorMessageDTO> handleExpiredTokensException(TokenExpiredException ex) {
        ErrorMessageDTO response = new ErrorMessageDTO("This token has expired.", HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
    
    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorMessageDTO> handleEntityExistsException(EntityAlreadyExistsException ex) {      
        ErrorMessageDTO response = new ErrorMessageDTO("Entity already exists on database.", HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleEntityNotFoundException(EntityNotFoundException ex) {      
        ErrorMessageDTO response = new ErrorMessageDTO("Entity already exists on database.", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(BadPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorMessageDTO> handleAuthenticationException(BadPasswordException ex) {
        ErrorMessageDTO response = new ErrorMessageDTO("Authentication failed", HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(BadEmailException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleUserNameNotFoundExcepiton(BadEmailException ex) {
        ErrorMessageDTO response = new ErrorMessageDTO("Email wasn't registered on database.", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDTO> serverError(Exception ex) {
        ErrorMessageDTO response = new ErrorMessageDTO("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
