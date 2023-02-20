package com.teste.escola.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teste.escola.entities.Aluno;

public class AlunoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	 @NotBlank
	private String name;
	 @NotBlank
	 @Positive
	private Integer age;
	
	private ClasseDTO classe;
	
	public AlunoDTO() {
	}

	public AlunoDTO(Long id, String name, Integer age, ClasseDTO classe) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.classe = classe;
	}
	public AlunoDTO(Aluno aluno) {
		id = aluno.getId();
		name = aluno.getName();
		age = aluno.getAge();
		classe = new ClasseDTO(aluno.getClasse());
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

	public ClasseDTO getClasse() {
		return classe;
	}

	public void setClasse(ClasseDTO classe) {
		this.classe = classe;
	}
	
	
}
