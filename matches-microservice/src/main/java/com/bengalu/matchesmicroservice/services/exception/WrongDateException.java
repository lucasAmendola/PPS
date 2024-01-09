package com.bengalu.matchesmicroservice.services.exception;

import lombok.Getter;

@Getter
public class WrongDateException extends RuntimeException {

    private String message;

    public WrongDateException(String entity, String date, String dateNow) {
        this.message = String.format("The date %s from entity %s is must be after or equal to the current date (%s)", date, entity, dateNow);
    }

    public String getMessage() {
        return message;
    }
}
