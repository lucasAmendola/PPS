package com.bengalu.matchesmicroservice.services.dtos.match.request;

import com.bengalu.matchesmicroservice.entities.Team;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@RequiredArgsConstructor
@Data
public class MatchRequestDTO {

    @NotNull(message = "date cannot be null")
    private Date date;

    @NotNull(message = "time cannot be null")
    private Time time;

    @NotNull(message = "matchDay cannot be null")
    @Min(value = 1, message = "matchDay cannot be less than 0")
    private Long matchDay;

    @NotNull(message = "category cannot be null")
    @NotEmpty(message = "the category cannot be empty")
    private String category;

    @NotNull(message = "localTeam ID cannot be null")
    private Long localTeamId;

    @NotNull(message = "visitingTeam ID cannot be null")
    private Long visitingTeamId;

    @NotNull(message = "status cannot be null")
    @NotEmpty(message = "the status cannot be empty")
    @Pattern(regexp = "not played|played|suspended", message = " the status must to be one of the 3 options: not played, played, suspended.")
    private String status;
}
