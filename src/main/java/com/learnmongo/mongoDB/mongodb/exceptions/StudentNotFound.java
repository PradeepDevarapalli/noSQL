package com.learnmongo.mongoDB.mongodb.exceptions;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound() {
    }

    public StudentNotFound(String message) {
        super(message);
    }

    public StudentNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFound(Throwable cause) {
        super(cause);
    }

    public StudentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
