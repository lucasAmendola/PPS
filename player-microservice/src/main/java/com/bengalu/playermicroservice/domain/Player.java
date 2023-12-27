package com.bengalu.playermicroservice.domain;

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
    private int dni;
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
}
