package com.bengalu.matchesmicroservice.services.dtos.selectedPlayer.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SelectedPlayerRequestDTO {

    @NotNull(message = "dniPlayer cannot be null")
    private Long dniPlayer;

    @NotNull(message = "surnamePlayer cannot be null")
    @NotEmpty(message = "the surnamePlayer cannot be empty")
    private String surnamePlayer;

    @NotNull(message = "namePlayer cannot be null")
    @NotEmpty(message = "the namePlayer cannot be empty")
    private String namePlayer;

    @NotNull(message = "category cannot be null")
    @NotEmpty(message = "the category cannot be empty")
    private String category;
}
