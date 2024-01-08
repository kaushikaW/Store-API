package com.example.storeapi.exception;

public class ApiNotFoundError extends RuntimeException {
    public ApiNotFoundError(String message) {
        super(message);
    }

    public ApiNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }
}
