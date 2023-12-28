package com.bengalu.playermicroservice.service;

import com.bengalu.playermicroservice.domain.Player;
import com.bengalu.playermicroservice.repository.PlayerRepository;
import com.bengalu.playermicroservice.service.DTOs.player.response.PlayerResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("PlayerService")
public class PlayerService {
    private PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<PlayerResponseDTO> getAllPlayers(){
        List<Player> players = this.repository.findAll();
        return players.stream().map(player -> new PlayerResponseDTO(player)).collect(Collectors.toList());
    }
}
