package com.examly.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles POST /api/roles with NO BODY -> returns 400 instead of 500
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleNoBody(HttpMessageNotReadableException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Default fallback for any other exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOther(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong");
    }
}
