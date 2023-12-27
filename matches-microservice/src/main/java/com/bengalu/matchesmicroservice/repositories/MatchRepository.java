package com.bengalu.matchesmicroservice.repositories;

import com.bengalu.matchesmicroservice.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
