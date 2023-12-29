package service.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private String message;
    public NotFoundException(String entity, String typeID, int id) {
        this.message = String.format("The entity %s is not found with %s %s", entity, typeID, id);
    }

}