package com.teste.escola.dto.simple;

import java.io.Serializable;

import com.teste.escola.entities.Classe;

public class SimpleClasseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer number;


	public SimpleClasseDTO() {
	}

	public SimpleClasseDTO(Long id, Integer number) {
		this.id = id;
		this.number = number;
	}

	public SimpleClasseDTO(Classe classe) {
		id = classe.getId();
		number = classe.getNumber();
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

}