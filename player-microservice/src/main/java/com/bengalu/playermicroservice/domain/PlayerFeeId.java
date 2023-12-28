package com.bengalu.playermicroservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class PlayerFeeId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "Fk_player_PlayerFee"))
    private Player player;
    @ManyToOne
    @JoinColumn(name = "fee_id", foreignKey = @ForeignKey(name = "FK_fee_PlayerFee"))
    private Fee fee;

    public PlayerFeeId(Player player, Fee fee) {
        super();
        this.player=player;
        this.fee=fee;
    }
}
