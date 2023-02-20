package com.teste.escola.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teste.escola.entities.Aula;

public class AulaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	 @NotBlank
	private String day;
	 @NotBlank
	 @Positive
	private Integer num;
	private ProfessorDTO professor;
	private ClasseDTO classe;
	
	public AulaDTO() {
	}

	public AulaDTO(Long id, String day, Integer num, ProfessorDTO professor, ClasseDTO classe) {
		this.id = id;
		this.day = day;
		this.num = num;
		this.professor = professor;
		this.classe = classe;
	}

	public AulaDTO(Aula aula) {
		this.id = aula.getId();
		this.day = aula.getDay();
		this.num = aula.getNum();
		this.professor = new ProfessorDTO(aula.getProfessor());
		this.classe = new ClasseDTO(aula.getClasse());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public ProfessorDTO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorDTO professor) {
		this.professor = professor;
	}

	public ClasseDTO getClasse() {
		return classe;
	}

	public void setClasse(ClasseDTO classe) {
		this.classe = classe;
	}
	
	
	
}
