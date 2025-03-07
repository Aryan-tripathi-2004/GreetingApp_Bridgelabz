package org.example.greetingapp.Exception;

public class UserException extends RuntimeException {
    private String message;

    public UserException(String message) {
        super(message);
    }
}
