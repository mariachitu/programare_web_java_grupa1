package com.example.springlab6example1.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super();
    }

    public NoDataFoundException(String message) {
        super(message);
    }
}
