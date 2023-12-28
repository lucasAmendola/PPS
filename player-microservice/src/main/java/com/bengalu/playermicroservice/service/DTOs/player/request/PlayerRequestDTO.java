package com.bengalu.playermicroservice.service.DTOs.player.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Data
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class PlayerRequestDTO {
    @NotNull(message = "dni cannot be null")
    @NotEmpty(message = "dni cannot be empty")
    private Integer dni;
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "surname cannot be null")
    @NotEmpty(message = "surname cannot be empty")
    private String surname;
    @NotNull(message = "birthdate cannot be null")
    @NotEmpty(message = "birthdate cannot be empty")
    private Date birthdate;
    @NotNull(message = "height cannot be null")
    @NotEmpty(message = "height cannot be empty")
    private Double height;
    @NotNull(message = "weight cannot be null")
    @NotEmpty(message = "weight cannot be empty")
    private Double weight;
    @NotNull(message = "skillfullLeg cannot be null")
    @NotEmpty(message = "skillfullLeg cannot be empty")
    private Character skillfullLeg;
    @NotNull(message = "position cannot be null")
    @NotEmpty(message = "position cannot be empty")
    private String position;
    @NotNull(message = "bloodType cannot be null")
    @NotEmpty(message = "bloodType cannot be empty")
    private String bloodType;
    @NotNull(message = "adress cannot be null")
    @NotEmpty(message = "adress cannot be empty")
    private String adress;
    @NotNull(message = "phoneNumber cannot be null")
    @NotEmpty(message = "phoneNumber cannot be empty")
    private String phoneNumber;
    @NotNull(message = "category cannot be null")
    @NotEmpty(message = "category cannot be empty")
    private int category;
    @NotNull(message = "insurance cannot be null")
    @NotEmpty(message = "insurance cannot be empty")
    private int insurance;
}
