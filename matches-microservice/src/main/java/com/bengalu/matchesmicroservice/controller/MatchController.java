package com.bengalu.matchesmicroservice.controller;

import com.bengalu.matchesmicroservice.services.MatchService;
import com.bengalu.matchesmicroservice.services.dtos.match.response.MatchResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/matches")
public class MatchController {

    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("")
    public List<MatchResponseDTO> getAllMatch() {
        return this.matchService.findAllMatch();
    }

    @GetMapping("/id")
    public MatchResponseDTO getMatchById(@PathVariable Long id) {
        return this.matchService.findMatchById(id);
    }
}
