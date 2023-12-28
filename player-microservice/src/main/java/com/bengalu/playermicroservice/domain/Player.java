package com.bengalu.playermicroservice.domain;

import com.bengalu.playermicroservice.service.DTOs.player.request.PlayerRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Player {
    @Id
    private Integer dni;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private Date birthdate;
    @Column(nullable = false)
    private Double height;
    @Column(nullable = false)
    private Double weight;
    @Column(nullable = false)
    private Character skillfullLeg;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String bloodType;
    @Column(nullable = false)
    private String adress;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private int category;
    @Column(nullable = false)
    private int insurance;

    public Player(PlayerRequestDTO playerRequest) {
        this.dni = playerRequest.getDni();
        this.name = playerRequest.getName();
        this.surname = playerRequest.getSurname();
        this.birthdate = playerRequest.getBirthdate();
        this.height = playerRequest.getHeight();
        this.weight = playerRequest.getWeight();
        this.skillfullLeg = playerRequest.getSkillfullLeg();
        this.position = playerRequest.getPosition();
        this.bloodType = playerRequest.getBloodType();
        this.adress = playerRequest.getAdress();
        this.phoneNumber = playerRequest.getPhoneNumber();
        this.category = playerRequest.getCategory();
        this.insurance = playerRequest.getInsurance();
    }
}
