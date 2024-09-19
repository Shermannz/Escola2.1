package com.teste.escola.dto.simple;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teste.escola.entities.Aluno;

public class SimpleAlunoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	@Positive
	private Integer age;

	public SimpleAlunoDTO() {
	}

	public SimpleAlunoDTO(Long id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public SimpleAlunoDTO(Aluno aluno) {
		id = aluno.getId();
		name = aluno.getName();
		age = aluno.getAge();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
