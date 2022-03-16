package com.delonborges.dslearn.resources.exceptions;

import com.delonborges.dslearn.services.exceptions.DatabaseIntegrityViolationException;
import com.delonborges.dslearn.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceStandardError> entityNotFound(ResourceNotFoundException exception,
                                                                HttpServletRequest request) {

        ResourceStandardError error = new ResourceStandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status)
                             .body(error);
    }

    @ExceptionHandler(DatabaseIntegrityViolationException.class)
    public ResponseEntity<ResourceStandardError> databaseIntegrityViolation(DatabaseIntegrityViolationException exception,
                                                                            HttpServletRequest request) {

        ResourceStandardError error = new ResourceStandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Database integrity violation");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status)
                             .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> argumentNotValid(MethodArgumentNotValidException exception,
                                                            HttpServletRequest request) {

        ValidationError error = new ValidationError();
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Argument not valid");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        for (FieldError fieldError : exception.getBindingResult()
                                              .getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(status)
                             .body(error);
    }
}
