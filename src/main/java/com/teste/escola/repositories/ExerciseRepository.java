package com.teste.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.escola.entities.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
