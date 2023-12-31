package com.bengalu.matchesmicroservice.services.exception;

import lombok.Getter;

@Getter
public class WebClientConflict extends RuntimeException{

    private String message;

    public WebClientConflict(String message){
        this.message = message;
    }
}
