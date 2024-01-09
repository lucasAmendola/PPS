package com.bengalu.matchesmicroservice.repositories;

import com.bengalu.matchesmicroservice.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
}
