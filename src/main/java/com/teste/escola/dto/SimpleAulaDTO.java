package com.teste.escola.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teste.escola.entities.Aula;

public class SimpleAulaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank
	private Integer classe;
	@NotBlank
	@Positive
	private Integer num;
	@NotBlank
	private String day;
	private SimpleProfessorDTO professor;
	@NotBlank
	private String turn;

	public SimpleAulaDTO() {
	}

	public SimpleAulaDTO(Long id, String day, Integer num, SimpleProfessorDTO professor, ClasseDTO classe,
			String turn) {
		this.id = id;
		this.day = day;
		this.num = num;
		this.professor = professor;
		this.classe = classe.getNumber();
		this.turn = turn;
	}

	public SimpleAulaDTO(Aula aula) {
		this.id = aula.getId();
		this.day = aula.getDay();
		this.num = aula.getNum();
		this.professor = new SimpleProfessorDTO(aula.getProfessor());
		this.classe = aula.getClasse().getNumber();
		this.turn = aula.getTurn().toString();
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

	public SimpleProfessorDTO getProfessor() {
		return professor;
	}

	public void setProfessor(SimpleProfessorDTO professor) {
		this.professor = professor;
	}

	public Integer getClasse() {
		return classe;
	}

	public void setClasse(Integer classe) {
		this.classe = classe;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

}
