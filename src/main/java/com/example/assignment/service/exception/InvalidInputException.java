package com.example.assignment.service.exception;

public class InvalidInputException extends RuntimeException {  //InvalidInputException inherit RuntimeException
    public InvalidInputException(String message) {
        super(message);
    }
}
