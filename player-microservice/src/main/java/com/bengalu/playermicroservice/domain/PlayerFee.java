package com.bengalu.playermicroservice.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class PlayerFee{
    @EmbeddedId
    private PlayerFeeId id;

    public PlayerFee(PlayerFeeId id) {
        this.id = id;
    }
}
