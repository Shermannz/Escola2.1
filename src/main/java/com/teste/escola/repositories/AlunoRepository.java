package com.teste.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.escola.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
