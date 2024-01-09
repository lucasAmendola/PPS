package com.bengalu.matchesmicroservice.services.exception;

public class NoUpcomingGamesException extends RuntimeException {

    private String message;
    public NoUpcomingGamesException() {
        this.message = String.format("There are no upcoming games");
    }
}
