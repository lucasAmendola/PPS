package domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.DTOs.fee.request.FeeRequestDTO;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Date payDay;
    @Column(nullable = false)
    private Boolean paid;

    public Fee (FeeRequestDTO f){
        this.amount = f.getAmount();
        this.payDay = f.getPayDay();
        this.paid = f.getPaid();
    }
}
