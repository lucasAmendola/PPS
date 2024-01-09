package com.bengalu.matchesmicroservice.entities;

import com.bengalu.matchesmicroservice.services.dtos.team.request.TeamRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String logo;

    public Team(TeamRequestDTO request) {
        this.name = request.getName();
        this.address = request.getAddress();
        this.logo = request.getLogo();
    }

    public Team(String name, String address, String logo) {
        this.name = name;
        this.address = address;
        this.logo = logo;
    }
}
