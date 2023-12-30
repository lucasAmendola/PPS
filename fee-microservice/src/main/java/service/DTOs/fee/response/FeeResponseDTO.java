package service.DTOs.fee.response;

import domain.Fee;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class FeeResponseDTO {

    private Double amount;
    private Date payDay;
    private Boolean paid;
    private int playerID;

    public FeeResponseDTO(Fee f){
        this.amount = f.getAmount();
        this.payDay = f.getPayDay();
        this.paid = f.getPaid();
        this.playerID = f.getPlayerID();
    }
}
