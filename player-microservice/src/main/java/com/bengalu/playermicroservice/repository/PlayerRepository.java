package com.bengalu.playermicroservice.repository;

import com.bengalu.playermicroservice.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllByCategory(int cat);
}
