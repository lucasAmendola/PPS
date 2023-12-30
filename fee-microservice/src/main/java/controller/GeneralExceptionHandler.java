package controller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import service.exception.ConflictExistException;
import service.exception.ErrorDTO;

@RestControllerAdvice(basePackages = "com.bengalu.playermicroservice.controller")
public class GeneralExceptionHandler {
    @ExceptionHandler(ConflictExistException.class)
    public ResponseEntity notFoundException(ConflictExistException exception) {
        return new ResponseEntity(new ErrorDTO(exception.getMessage()), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity notFoundException(ChangeSetPersister.NotFoundException exception) {
        return new ResponseEntity(new ErrorDTO(exception.getMessage()), HttpStatus.CONFLICT);
    }
}
