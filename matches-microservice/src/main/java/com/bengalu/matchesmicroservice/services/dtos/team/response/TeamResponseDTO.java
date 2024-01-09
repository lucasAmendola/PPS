package com.bengalu.matchesmicroservice.services.dtos.team.response;

import com.bengalu.matchesmicroservice.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDTO {

    private Long id;
    private String name;
    private String address;
    private String logo;

    public TeamResponseDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.address = team.getAddress();
        this.logo = team.getLogo();
    }
}
