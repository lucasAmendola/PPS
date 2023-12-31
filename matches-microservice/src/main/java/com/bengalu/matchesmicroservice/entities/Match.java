package com.bengalu.matchesmicroservice.entities;

import com.bengalu.matchesmicroservice.services.dtos.match.request.MatchRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column(nullable = false)
    private String stadium;

    @Column(nullable = false)
    private String rivalTeam;

    @Column
    private String status; //played, suspended, not played

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SelectedPlayer> players;

    public Match(MatchRequestDTO request) {
        this.date = request.getDate();
        this.stadium = request.getStadium();
        this.rivalTeam = request.getRivalTeam();
        this.players = new ArrayList<>();
    }

    public Match(Date date, String stadium, String rival, String status) {
        this.date = date;
        this.stadium = stadium;
        this.rivalTeam = rival;
        this.status = status;
        this.players = new ArrayList<>();
    }

    public void addPlayer(SelectedPlayer player) {
        this.players.add(player);
        //player.setMatch(this);
    }

    public void removePlayer(SelectedPlayer player) {
        this.players.remove(player);
        //player.setMatch(null);
    }
}
