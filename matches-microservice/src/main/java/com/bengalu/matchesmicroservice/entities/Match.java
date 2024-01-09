package com.bengalu.matchesmicroservice.entities;

import com.bengalu.matchesmicroservice.services.dtos.match.request.MatchRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
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

    @Column
    private Time time;

    @Column
    private Long matchDay;

    @Column
    private Team localTeam;

    @Column
    private Team visitingTeam;

    @Column
    private String status; //played, suspended, not played

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SelectedPlayer> players;

    public Match(MatchRequestDTO request) {
        this.date = request.getDate();
        this.time = request.getTime();
        this.matchDay = request.getMatchDay();
        this.localTeam = request.getLocalTeam();
        this.visitingTeam = request.getVisitingTeam();
        this.status = request.getStatus();
        this.players = new ArrayList<>();
    }

    public Match(Date date, Time time, Long matchDay, String stadium, String rival, Team localTeam, Team visitingTeam,String status) {
        this.date = date;
        this.time = time;
        this.matchDay = matchDay;
        this.localTeam = localTeam;
        this.visitingTeam = visitingTeam;
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
