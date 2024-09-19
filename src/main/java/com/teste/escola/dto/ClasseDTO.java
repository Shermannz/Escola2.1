package com.teste.escola.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.teste.escola.dto.simple.SimpleAlunoDTO;
import com.teste.escola.entities.Aluno;
import com.teste.escola.entities.Classe;

public class ClasseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer number;

	List<SimpleAlunoDTO> alunos = new ArrayList<>();

	public ClasseDTO() {
	}

	public ClasseDTO(Long id, Integer number) {
		this.id = id;
		this.number = number;
	}

	public ClasseDTO(Classe classe) {
		id = classe.getId();
		number = classe.getNumber();
		for (Aluno aluno : classe.getAlunos()) {
			alunos.add(new SimpleAlunoDTO(aluno));
		}
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

	public List<SimpleAlunoDTO> getAlunos() {
		return alunos;
	}

}
