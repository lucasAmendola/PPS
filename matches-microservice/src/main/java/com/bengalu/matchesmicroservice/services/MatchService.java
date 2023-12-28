package com.bengalu.matchesmicroservice.services;

import com.bengalu.matchesmicroservice.entities.Match;
import com.bengalu.matchesmicroservice.repositories.MatchRepository;
import com.bengalu.matchesmicroservice.repositories.SelectedPlayerRepository;
import com.bengalu.matchesmicroservice.services.dtos.match.response.MatchResponseDTO;
import com.bengalu.matchesmicroservice.services.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("MatchService")
public class MatchService {

    private MatchRepository matchRepository;
    private SelectedPlayerRepository selectedPlayerRepository;

    public MatchService(MatchRepository mr, SelectedPlayerRepository sr) {
        this.matchRepository = mr;
        this.selectedPlayerRepository = sr;
    }

    /***
     *
     * @param id
     * @return MatchResponseDTO
     */
    @Transactional(readOnly = true)
    public MatchResponseDTO findMatchById(Long id) {
        return matchRepository.findById(id)
                .map(MatchResponseDTO::new)
                .orElseThrow(() -> new NotFoundException("Match", "Id", id));
    }

    /***
     *
     * @return List of MatchResponseDTO
     */
    @Transactional(readOnly = true)
    public List<MatchResponseDTO> findAllMatch() {
        List<Match> trips = matchRepository.findAll();
        return trips.stream().map(m-> new MatchResponseDTO(m)).collect(Collectors.toList());
    }

    /***
     *
     * @param status
     * @return list of MatchResponseDTO
     */
    @Transactional(readOnly = true)
    public List<MatchResponseDTO> findAllMatchByStatus(String status) {
        List<Match> trips = matchRepository.findAllByStatus(status);
        return trips.stream().map(m-> new MatchResponseDTO(m)).collect(Collectors.toList());
    }
}
