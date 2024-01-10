package com.bengalu.matchesmicroservice.services.dtos.match.response;

import com.bengalu.matchesmicroservice.entities.Match;
import com.bengalu.matchesmicroservice.entities.SelectedPlayer;
import com.bengalu.matchesmicroservice.entities.Team;
import com.bengalu.matchesmicroservice.services.dtos.selectedPlayer.response.SelectedPlayerResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponseDTO {

    private Long id;
    private Date date;
    private Long matchDay;
    private String category;
    private Team localTeam;
    private Team visitingTeam;
    private String status;
    private List<SelectedPlayer> selectedPlayers;

    public MatchResponseDTO(Match match, Team local, Team visiting) {
        this.id = match.getId();
        this.date = match.getDate();
        this.matchDay = match.getMatchDay();
        this.category = match.getCategory();
        this.localTeam = local;
        this.visitingTeam = visiting;
        this.status = match.getStatus();
        this.selectedPlayers = match.getPlayers();
    }
}
