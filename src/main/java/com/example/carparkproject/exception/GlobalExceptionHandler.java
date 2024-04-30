package com.example.carparkproject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->
        {
            //Convert error to FieldError because this error is FieldError
            String fildName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fildName,errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptions(Exception ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }
}
