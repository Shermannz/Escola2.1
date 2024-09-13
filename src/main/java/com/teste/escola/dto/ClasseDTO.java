package com.teste.escola.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.teste.escola.entities.Aluno;
import com.teste.escola.entities.Aula;
import com.teste.escola.entities.Classe;

public class ClasseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	@NotBlank
	private Integer number;

	List<AlunoDTO> alunos = new ArrayList<>();

	List<AulaDTO> aula = new ArrayList<>();

	public ClasseDTO() {
	}

	public ClasseDTO(Long id, Integer number) {
		this.id = id;
		this.number = number;
	}

	public ClasseDTO(Classe classe) {
		id = classe.getId();
		number = classe.getNumber();
	}

	public ClasseDTO(Classe classe, Set<Aula> aula, Set<Aluno> alunos) {
		id = classe.getId();
		number = classe.getNumber();
		aula.forEach(x -> this.aula.add(new AulaDTO(x)));
		alunos.forEach(x -> this.alunos.add(new AlunoDTO(x)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<AlunoDTO> getAlunos() {
		return alunos;
	}

	public List<AulaDTO> getAula() {
		return aula;
	}
}
