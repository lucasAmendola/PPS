package com.bengalu.matchesmicroservice.repositories;

import com.bengalu.matchesmicroservice.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m WHERE m.status =:status")
    List<Match> findAllByStatus(@Param("status") String status);

    @Query("Select m " +
            "from Match m " +
            "where :status is null or m.status = :status ")
    List<Match> searchAllMatchByStatus(@Param("status") String status);
}
