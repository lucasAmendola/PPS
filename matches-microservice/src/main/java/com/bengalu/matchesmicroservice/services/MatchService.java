package com.bengalu.matchesmicroservice.services;

import com.bengalu.matchesmicroservice.repositories.MatchRepository;
import com.bengalu.matchesmicroservice.repositories.SelectedPlayerRepository;
import org.springframework.stereotype.Service;

@Service("MatchService")
public class MatchService {

    private MatchRepository matchRepository;
    private SelectedPlayerRepository selectedPlayerRepository;

    public MatchService(MatchRepository mr, SelectedPlayerRepository sr) {
        this.matchRepository = mr;
        this.selectedPlayerRepository = sr;
    }
}
