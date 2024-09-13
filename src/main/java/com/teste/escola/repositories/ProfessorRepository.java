package com.teste.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.escola.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByEmail(String email);
}
