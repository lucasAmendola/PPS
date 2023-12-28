package com.bengalu.playermicroservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Fee {
    @Id
    private Long id;
    private Double amount;
    private Date payDay;
    private Boolean paid;
}
