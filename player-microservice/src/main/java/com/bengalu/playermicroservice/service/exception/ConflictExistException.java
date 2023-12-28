package com.bengalu.playermicroservice.service.exception;

import lombok.Getter;

@Getter
public class ConflictExistException extends RuntimeException {

    private String message;
    public ConflictExistException(String entity, String attribute, int id) {
        this.message = String.format("There is already a %s entity with %s %s.", entity, attribute, id);
    }

}