package com.bengalu.matchesmicroservice.entities;

import com.bengalu.matchesmicroservice.services.dtos.selectedPlayer.request.SelectedPlayerRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SelectedPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long dniPlayer;

    @Column(nullable = false)
    private String surnamePlayer;

    @Column(nullable = false)
    private String namePlayer;


    //@ManyToOne
    //private Match match;

    public SelectedPlayer(SelectedPlayerRequestDTO request) {
        this.dniPlayer = request.getDniPlayer();
        this.surnamePlayer = request.getSurnamePlayer();
        this.namePlayer = request.getNamePlayer();
    }

    public SelectedPlayer(Long dni, String surname, String name) {
        this.dniPlayer = dni;
        this.surnamePlayer = surname;
        this.namePlayer = name;
    }
}
