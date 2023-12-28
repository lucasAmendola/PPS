package com.bengalu.playermicroservice.controller;

import com.bengalu.playermicroservice.domain.Player;
import com.bengalu.playermicroservice.service.DTOs.player.request.PlayerRequestDTO;
import com.bengalu.playermicroservice.service.DTOs.player.response.PlayerResponseDTO;
import com.bengalu.playermicroservice.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private PlayerService service;
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity createPlayer(@RequestBody @Valid PlayerRequestDTO request){
        return this.service.savePlayer(request);
    }

    @GetMapping("/")
    public List<PlayerResponseDTO> getAllPlayers(){
        return this.service.getAllPlayers();
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePlayer(@RequestBody @Valid PlayerRequestDTO requestDTO, @PathVariable int id){
        return this.service.updatePlayer(requestDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlayer(@PathVariable int id){
        return this.service.deletePlayer(id);
    }
}
