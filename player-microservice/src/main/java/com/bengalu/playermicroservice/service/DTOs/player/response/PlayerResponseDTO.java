package com.bengalu.playermicroservice.service.DTOs.player.response;

import com.bengalu.playermicroservice.domain.Player;
import lombok.Data;

import java.util.Date;

@Data
public class PlayerResponseDTO{
    private Integer dni;
    private String name;
    private String surname;
    private Date birthdate;
    private Double height;
    private Double weight;
    private Character skillfullLeg;
    private String position;
    private String bloodType;
    private String adress;
    private String phoneNumber;
    private int category;
    private int insurance;

    public PlayerResponseDTO(Player p){
        this.dni = p.getDni();
        this.name = p.getName();
        this.surname = p.getSurname();
        this.birthdate = p.getBirthdate();
        this.height = p.getHeight();
        this.weight = p.getWeight();
        this.skillfullLeg = p.getSkillfullLeg();
        this.position = p.getPosition();
        this.bloodType = p.getBloodType();
        this.adress = p.getAdress();
        this.phoneNumber = p.getPhoneNumber();
        this.category = p.getCategory();
        this.insurance = p.getInsurance();
    }
}
