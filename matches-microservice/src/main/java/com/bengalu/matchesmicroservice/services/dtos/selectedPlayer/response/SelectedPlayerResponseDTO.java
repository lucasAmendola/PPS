package com.bengalu.matchesmicroservice.services.dtos.selectedPlayer.response;

import com.bengalu.matchesmicroservice.entities.SelectedPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedPlayerResponseDTO {

    private Long dniPLayer;
    private String surNamePlayer;
    private String namePlayer;
    private String category;

    public SelectedPlayerResponseDTO(SelectedPlayer selectedPlayer) {
        this.dniPLayer = selectedPlayer.getDniPlayer();
        this.surNamePlayer = selectedPlayer.getSurnamePlayer();
        this.namePlayer = selectedPlayer.getNamePlayer();
        this.category = selectedPlayer.getCategory();
    }
}
