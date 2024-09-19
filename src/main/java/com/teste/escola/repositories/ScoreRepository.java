package com.teste.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.escola.entities.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

}
