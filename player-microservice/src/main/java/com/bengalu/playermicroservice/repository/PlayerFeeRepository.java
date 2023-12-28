package com.bengalu.playermicroservice.repository;

import com.bengalu.playermicroservice.domain.PlayerFee;
import com.bengalu.playermicroservice.domain.PlayerFeeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerFeeRepository extends JpaRepository<PlayerFee, PlayerFeeId> {
    List<PlayerFee> findPlayerFeeById_Player(int id);
}
