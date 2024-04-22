package com.learnmongo.mongoDB.mongodb.service;

public class StudentNotFoundResponse {

    private int statusCode;

    public StudentNotFoundResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    private String message;

}
