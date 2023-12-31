package com.bengalu.matchesmicroservice.services.dtos.match.response;

import com.bengalu.matchesmicroservice.entities.Match;
import com.bengalu.matchesmicroservice.services.dtos.selectedPlayer.response.SelectedPlayerResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponseDTO {

    private Date date;
    private String stadium;
    private String rivalTeam;
    private ArrayList<SelectedPlayerResponseDTO> selectedPlayers;

    public MatchResponseDTO(Match match) {
        this.date = match.getDate();
        this.stadium = match.getStadium();
        this.rivalTeam = match.getRivalTeam();
        this.selectedPlayers = null;
    }
}
