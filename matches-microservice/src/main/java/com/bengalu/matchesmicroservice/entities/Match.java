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

    @Column(nullable = false)
    private String category;

    @Column
    private Long localTeamId;

    @Column
    private Long visitingTeamId;

    @Column(nullable = false)
    private String status; //played, suspended, not played

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SelectedPlayer> players;

    public Match(MatchRequestDTO request) {
        this.date = request.getDate();
        this.time = request.getTime();
        this.matchDay = request.getMatchDay();
        this.category = request.getCategory();
        this.localTeamId = request.getLocalTeamId();
        this.visitingTeamId = request.getVisitingTeamId();
        this.status = request.getStatus();
        this.players = new ArrayList<>();
    }

    public Match(Date date, Time time, Long matchDay, String category, Long local, Long visiting,String status) {
        this.date = date;
        this.time = time;
        this.matchDay = matchDay;
        this.category = category;
        this.localTeamId = local;
        this.visitingTeamId = visiting;
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
