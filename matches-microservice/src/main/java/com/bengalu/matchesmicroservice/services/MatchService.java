package com.bengalu.matchesmicroservice.services;

import com.bengalu.matchesmicroservice.entities.Match;
import com.bengalu.matchesmicroservice.entities.SelectedPlayer;
import com.bengalu.matchesmicroservice.repositories.MatchRepository;
import com.bengalu.matchesmicroservice.repositories.SelectedPlayerRepository;
import com.bengalu.matchesmicroservice.repositories.TeamRepository;
import com.bengalu.matchesmicroservice.services.dtos.match.request.MatchRequestDTO;
import com.bengalu.matchesmicroservice.services.dtos.match.request.SearchMatchesByStatusDTO;
import com.bengalu.matchesmicroservice.services.dtos.match.response.MatchResponseDTO;
import com.bengalu.matchesmicroservice.services.dtos.selectedPlayer.response.SelectedPlayerResponseDTO;
import com.bengalu.matchesmicroservice.services.exception.NoUpcomingGamesException;
import com.bengalu.matchesmicroservice.services.exception.NotFoundException;
import com.bengalu.matchesmicroservice.services.exception.SameTeamException;
import com.bengalu.matchesmicroservice.services.exception.WrongDateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service("MatchService")
public class MatchService {

    private MatchRepository matchRepository;
    private SelectedPlayerRepository selectedPlayerRepository;
    private TeamRepository teamRepository;

    public MatchService(MatchRepository mr, SelectedPlayerRepository sr, TeamRepository tr) {
        this.matchRepository = mr;
        this.selectedPlayerRepository = sr;
        this.teamRepository = tr;
    }

    /// MATCH FUNCTIONALITIES ///

    /**
     * Get a match by ID
     * @param id
     * @return MatchResponseDTO the match found
     * @throws NotFoundException if there is no match with the proportional ID
     */
    @Transactional(readOnly = true)
    public MatchResponseDTO findMatchById(Long id) {
        return matchRepository.findById(id)
                .map(MatchResponseDTO::new)
                .orElseThrow(() -> new NotFoundException("Match", "Id", id));
    }

    /**
     * Get upcoming match
     * @return MatchResponseDTO the match found
     * @throws NoUpcomingGamesException if there are no upcoming games
     */
    @Transactional(readOnly = true)
    public MatchResponseDTO finduUpcomingMatch() {
        Match match = this.matchRepository.findUpcomingMatch();
        if(match != null) {
            return new MatchResponseDTO(match);
        }
        throw new NoUpcomingGamesException();
    }

    /**
     * Get All the matches history
     *
     * @return List of matches history
     */
    @Transactional(readOnly = true)
    public List<MatchResponseDTO> findAllMatch() {
        List<Match> matches = matchRepository.findAll();
        return matches.stream().map(m-> new MatchResponseDTO(m)).collect(Collectors.toList());
    }

    /**
     * Get all the matches history by status
     *
     * @param requestStatus status to filter the search
     * @return list of matches leaked by status
     */
    @Transactional(readOnly = true)
    public List<MatchResponseDTO> findAllMatchByStatus(SearchMatchesByStatusDTO requestStatus) {
        List<Match> trips = matchRepository.findAllByStatus(requestStatus.getStatus());
        return trips.stream().map(m-> new MatchResponseDTO(m)).collect(Collectors.toList());
    }

    /**
     * Create a new match in the system
     *
     * @param request match information to create
     * @return created match status
     * @throws WrongDateException if request.date() is before the dateNow
     */
    @Transactional
    public ResponseEntity saveMatch(MatchRequestDTO request) {
        if(!request.getVisitingTeam().getName().equals(request.getLocalTeam().getName())) {
            Date dateNow = Date.valueOf(LocalDate.now());
            if(request.getDate().after(dateNow)) {
                this.matchRepository.save(new Match(request));
                return new ResponseEntity(HttpStatus.CREATED);
            }
            throw new WrongDateException("Match", ""+request.getDate()+"",""+dateNow+"");
        }
        throw new SameTeamException();

    }

    /**
     * Update a match by proportional id
     *
     * @param request match information to update
     * @param id match id
     * @return update match status
     * @throws NotFoundException if there is no match with the proportional ID
     */
    @Transactional
    public ResponseEntity updateMatch(MatchRequestDTO request, Long id) {
        //no debe permitir modificar o agregar partido con una fecha anterior a la actual
        Optional<Match> matchExisting = this.matchRepository.findById(id);
        if(matchExisting.get() != null) {
            if(request.getDate() == matchExisting.get().getDate())
            matchExisting.get().setDate(request.getDate());
            matchExisting.get().setMatchDay(request.getMatchDay());
            matchExisting.get().setLocalTeam(request.getLocalTeam());
            matchExisting.get().setVisitingTeam(request.getVisitingTeam());
            matchExisting.get().setStatus(request.getStatus());
            return new ResponseEntity(id, HttpStatus.ACCEPTED);
        }
        throw new NotFoundException("Match", "ID", id);
    }

    /**
     * delete a match by proportional ID
     *
     * @param id
     * @return delete match status
     * @throws NotFoundException if there is no match with the proportional ID
     */
    @Transactional
    public ResponseEntity deleteMatch(Long id) {
        Match match = this.matchRepository.findById(id).get();
        if(match != null) {
            this.matchRepository.delete(match);
            return new ResponseEntity(id, HttpStatus.ACCEPTED);
        }
        throw new NotFoundException("Match", "ID", id);
    }

    /// SELECTED PLAYERS FUNCTIONALITIES ///

    /**
     * Get SelectedPlayer by proportional ID
     *
     * @param id
     * @return SelectedPlayerResponseDTO found SelectedPlayer
     * @throws NotFoundException if there is no selected player with the proportional ID
     */
    @Transactional(readOnly = true)
    public SelectedPlayerResponseDTO findSelectedPlayerById(Long id) {
        return selectedPlayerRepository.findById(id)
                .map(SelectedPlayerResponseDTO::new)
                .orElseThrow(() -> new NotFoundException("SelectedPlayer", "Id", id));
    }

    /**
     * get all selected players
     *
     * @return List<SelectedPlayerResponseDTO> all selected players
     */
    @Transactional(readOnly = true)
    public List<SelectedPlayerResponseDTO> findAllSelectedPlayer() {
        List<SelectedPlayer> selectedPlayers = selectedPlayerRepository.findAll();
        return selectedPlayers.stream().map(s-> new SelectedPlayerResponseDTO(s)).collect(Collectors.toList());
    }

    /**
     * get all selected players by match ID
     *
     * @param id
     * @return List<SelectedPlayerResponseDTO> all selected players by especific match
     * @throws NotFoundException if there is no match with the proportional ID
     */
    @Transactional(readOnly = true)
    public List<SelectedPlayerResponseDTO> findAllSelectedPlayerByMatchId(Long id) {
        Match match = this.matchRepository.findById(id).get();
        if(match != null) {
            return match.getPlayers()
                    .stream()
                    .map(s-> new SelectedPlayerResponseDTO(s)).collect(Collectors.toList());
        }
        throw new NotFoundException("Match", "ID", id);
    }

    /**
     * get all players by match and sorted by category
     *
     * @param matchId
     * @return List<ArrayList<SelectedPlayerResponseDTO>> all selected players by match, separated by category
     */
    /*
    @Transactional(readOnly = true)
    public List<ArrayList<SelectedPlayerResponseDTO>> findAllSelectedPlayerByMatchByCategory(Long matchId) {
        List<SelectedPlayer> players = this.matchRepository.findById(matchId).get().getPlayers();
        //cast
        List<SelectedPlayerResponseDTO> playersResponse = players.stream().map(s-> new SelectedPlayerResponseDTO(s)).collect(Collectors.toList());
        //groups
        Map<String, List<SelectedPlayerResponseDTO>> playersByCategory = playersResponse.stream()
                .collect(Collectors.groupingBy(SelectedPlayerResponseDTO::getCategory));

        List<ArrayList<SelectedPlayerResponseDTO>> result = new ArrayList<>();
        for (Map.Entry<String, List<SelectedPlayerResponseDTO>> entry : playersByCategory.entrySet()) {
            result.add(new ArrayList<>(entry.getValue()));
        }

        return result;
    }

     */

}
