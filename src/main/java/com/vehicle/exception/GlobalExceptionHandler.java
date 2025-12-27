package com.vehicle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException methodArgumentNotValidException) {

        Map<String, String> errors = new HashMap<>();

        methodArgumentNotValidException.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

        @ExceptionHandler(ResidentNotFoundException.class)
        public ResponseEntity<String> handlerResidentNotFound(ResidentNotFoundException residentNotFoundException)
        {
            return new ResponseEntity<>(residentNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
        }

}