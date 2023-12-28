package com.bengalu.playermicroservice.controller;

import com.bengalu.playermicroservice.domain.Player;
import com.bengalu.playermicroservice.service.DTOs.player.response.PlayerResponseDTO;
import com.bengalu.playermicroservice.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private PlayerService service;
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<PlayerResponseDTO> getAllPlayers(){
        return this.service.getAllPlayers();
    }
}
