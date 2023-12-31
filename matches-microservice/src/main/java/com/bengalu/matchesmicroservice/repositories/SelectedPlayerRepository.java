package com.bengalu.matchesmicroservice.repositories;

import com.bengalu.matchesmicroservice.entities.SelectedPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectedPlayerRepository extends JpaRepository<SelectedPlayer, Long> {
}
