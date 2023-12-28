package com.bengalu.playermicroservice.repository;

import com.bengalu.playermicroservice.domain.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepository extends JpaRepository<Fee, Long> {
}
