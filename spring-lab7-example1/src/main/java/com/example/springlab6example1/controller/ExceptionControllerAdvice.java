package com.example.springlab6example1.controller;

import com.example.springlab6example1.exception.ErrorResponse;
import com.example.springlab6example1.exception.NoDataFoundException;
import com.example.springlab6example1.exception.PersonNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    //    @ExceptionHandler({PersonNotFoundException.class})
    @ExceptionHandler({PersonNotFoundException.class, NoDataFoundException.class})
    public ResponseEntity<ErrorResponse> handlePersonNotFound(Exception exception) {
        log.debug("Person not found..");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .code(404)
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleArgumentNotValidException(MethodArgumentNotValidException exception) {
        String invalidFiels = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getField)
                .collect(Collectors.joining(", "));

        String errors = exception.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + " " + e.getDefaultMessage() + " " + e.getRejectedValue())
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(ErrorResponse.builder()
                .code(400)
//                .message("The following fields are invalid: " + invalidFiels)
                .message(errors)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
