package com.bengalu.matchesmicroservice.services.dtos.team.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class TeamRequestDTO {

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "the name cannot be empty")
    private String name;

    @NotNull(message = "address cannot be null")
    @NotEmpty(message = "the address cannot be empty")
    private String address;

    @NotNull(message = "logo cannot be null")
    @NotEmpty(message = "the logo cannot be empty")
    private String logo;
}
