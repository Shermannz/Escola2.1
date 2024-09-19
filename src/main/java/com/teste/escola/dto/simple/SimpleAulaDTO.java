package com.teste.escola.dto.simple;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teste.escola.dto.ClasseDTO;
import com.teste.escola.dto.ExerciseDTO;
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
	@NotBlank
	private String turn;
	private SimpleProfessorDTO professor;
	private ExerciseDTO exercise;

	public SimpleAulaDTO() {
	}

	public SimpleAulaDTO(Long id, ClasseDTO classe, String day, Integer num, String turn, SimpleProfessorDTO professor,
			ExerciseDTO exercise) {
		this.id = id;
		this.classe = classe.getNumber();
		this.day = day;
		this.num = num;
		this.turn = turn;
		this.professor = professor;
		this.exercise = exercise;
	}

	public SimpleAulaDTO(Aula aula) {
		this.id = aula.getId();
		this.classe = aula.getClasse().getNumber();
		this.day = aula.getDay();
		this.num = aula.getNum();
		this.turn = aula.getTurn().toString();
		this.professor = new SimpleProfessorDTO(aula.getProfessor());
		this.exercise = new ExerciseDTO(aula.getExercise());

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

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
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

	public ExerciseDTO getExercise() {
		return exercise;
	}

	public void setExercise(ExerciseDTO exercise) {
		this.exercise = exercise;
	}

}
