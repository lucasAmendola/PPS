package com.bengalu.playermicroservice.service;

import com.bengalu.playermicroservice.domain.Fee;
import com.bengalu.playermicroservice.domain.Player;
import com.bengalu.playermicroservice.domain.PlayerFee;
import com.bengalu.playermicroservice.repository.FeeRepository;
import com.bengalu.playermicroservice.repository.PlayerFeeRepository;
import com.bengalu.playermicroservice.repository.PlayerRepository;
import com.bengalu.playermicroservice.service.DTOs.player.request.PlayerRequestDTO;
import com.bengalu.playermicroservice.service.DTOs.player.response.PlayerResponseDTO;
import com.bengalu.playermicroservice.service.exception.ConflictExistException;
import com.bengalu.playermicroservice.service.exception.NotFoundException;
import com.bengalu.playermicroservice.service.exception.ReferencedRowException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("PlayerService")
public class PlayerService {
    private PlayerRepository repository;
    private FeeRepository feeRepository;
    private PlayerFeeRepository playerFeeRepository;

    public PlayerService(PlayerRepository repository, FeeRepository feeRepository, PlayerFeeRepository playerFeeRepository) {
        this.repository = repository;
        this.feeRepository = feeRepository;
        this.playerFeeRepository = playerFeeRepository;
    }

    @Transactional(readOnly = true)
    public List<PlayerResponseDTO> getAllPlayers(){
        List<Player> players = this.repository.findAll();
        return players.stream().map(player -> new PlayerResponseDTO(player)).collect(Collectors.toList());
    }
    @Transactional
    public ResponseEntity savePlayer(PlayerRequestDTO playerRequest) {
        if(!this.repository.existsById(playerRequest.getDni())){
            Player newPlayer = new Player(playerRequest);
            this.repository.save(newPlayer);
            return new ResponseEntity(newPlayer.getDni(), HttpStatus.CREATED);
        }
        else
            throw new ConflictExistException("Player", "DNI", playerRequest.getDni());
    }
    @Transactional
    public ResponseEntity updatePlayer(PlayerRequestDTO playerRequest, int id) {
        if(this.repository.existsById(id)){
            Player player = this.repository.findById(playerRequest.getDni()).get();

            player.setName(playerRequest.getName());
            player.setSurname(playerRequest.getSurname());
            player.setBirthdate(playerRequest.getBirthdate());
            player.setAdress(playerRequest.getAdress());
            player.setCategory(playerRequest.getCategory());
            player.setHeight(playerRequest.getHeight());
            player.setWeight(playerRequest.getWeight());
            player.setInsurance(playerRequest.getInsurance());
            player.setPosition(playerRequest.getPosition());
            player.setSkillfullLeg(playerRequest.getSkillfullLeg());
            player.setBloodType(playerRequest.getBloodType());
            player.setPhoneNumber(playerRequest.getPhoneNumber());

            return new ResponseEntity(player.getDni(), HttpStatus.OK);
        }
        else {
            throw new NotFoundException("Player","DNI", id);
        }
    }
    @Transactional
    public ResponseEntity deletePlayer(int id) {
        if(this.repository.existsById(id)){
            List<PlayerFee> fees = this.playerFeeRepository.findPlayerFeeById_Player(id);
            if(fees.isEmpty()){
               this.repository.deleteById(id);
               return new ResponseEntity(id, HttpStatus.OK);
            }
            else {
                throw new ReferencedRowException("Player","fee",id, fees.toString());
            }
        }
        else {
            throw new NotFoundException("Player", "DNI", id);
        }
    }
}
