package com.bengalu.matchesmicroservice.services.exception;

public class SameTeamException extends RuntimeException {

    private String message;

    public SameTeamException() {
        this.message = String.format("In %s, the %s and %s cannot be the same team");
    }

    public String getMessage() {
        return message;
    }
}
