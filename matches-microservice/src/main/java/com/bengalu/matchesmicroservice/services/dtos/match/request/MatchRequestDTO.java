package com.bengalu.matchesmicroservice.services.dtos.match.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@RequiredArgsConstructor
@Data
public class MatchRequestDTO {

    @NotNull(message = "date cannot be null")
    private Date date;

    @NotNull(message = "stadium cannot be null")
    @NotEmpty(message = "the stadium cannot be empty")
    private String stadium;

    @NotNull(message = "rivalTeam cannot be null")
    @NotEmpty(message = "the rivalTeam cannot be empty")
    private String rivalTeam;
}
