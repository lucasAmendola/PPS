package com.bengalu.playermicroservice.controller;

import com.bengalu.playermicroservice.service.exception.ConflictExistException;
import com.bengalu.playermicroservice.service.exception.ErrorDTO;
import com.bengalu.playermicroservice.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.bengalu.playermicroservice.controller")
public class GeneralExceptionHandler {
    @ExceptionHandler(ConflictExistException.class)
    public ResponseEntity notFoundException(ConflictExistException exception) {
        return new ResponseEntity(new ErrorDTO(exception.getMessage()), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundException(NotFoundException exception) {
        return new ResponseEntity(new ErrorDTO(exception.getMessage()), HttpStatus.CONFLICT);
    }
}
