package com.teste.escola.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teste.escola.entities.Aula;
import com.teste.escola.entities.Professor;

public class ProfessorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	 @NotBlank
	private String name;
	 @NotBlank
	 @Positive
	private Integer age;
	 @NotBlank
	private String subject;

	List<AulaDTO> aula = new ArrayList<>();

	public ProfessorDTO() {
	}

	public ProfessorDTO(Long id, String name, Integer age, String subject) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.subject = subject;
	}

	public ProfessorDTO(Professor professor) {
		this.id = professor.getId();
		this.name = professor.getName();
		this.age = professor.getAge();
		this.subject = professor.getSubject();
	}
	public ProfessorDTO(Professor professor,Set<Aula> aula) {
		this(professor);
		professor.getAula().forEach(au -> this.aula.add(new AulaDTO(au)));
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<AulaDTO> getAula() {
		return aula;
	}


}
