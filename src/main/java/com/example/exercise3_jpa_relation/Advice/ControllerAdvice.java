package com.example.exercise3_jpa_relation.Advice;

import com.example.exercise3_jpa_relation.API.ApiException;
import com.example.exercise3_jpa_relation.API.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    // Handle ApiException
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {

        return ResponseEntity.status(400)
                .body(new ApiResponse(e.getMessage()));
    }

    // Handle Other Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {

        return ResponseEntity.status(500)
                .body(new ApiResponse("Something went wrong"));
    }
}