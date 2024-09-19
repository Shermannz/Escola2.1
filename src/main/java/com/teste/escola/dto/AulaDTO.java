package com.teste.escola.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teste.escola.dto.simple.SimpleClasseDTO;
import com.teste.escola.dto.simple.SimpleProfessorDTO;
import com.teste.escola.entities.Aula;
import com.teste.escola.entities.enums.Turn;

public class AulaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank
	private String day;
	@NotBlank
	@Positive
	private Integer num;
	private Turn turn;
	private SimpleProfessorDTO professor;
	private ExerciseDTO exercise;
	private SimpleClasseDTO classe;

	public AulaDTO() {
	}

	public AulaDTO(Long id, String day, Integer num, Turn turn, SimpleProfessorDTO professor, ExerciseDTO exercise,
			SimpleClasseDTO classe) {
		this.id = id;
		this.day = day;
		this.num = num;
		this.turn = turn;
		this.professor = professor;
		this.exercise = exercise;
		this.classe = classe;
	}

	public AulaDTO(Aula aula) {
		this.id = aula.getId();
		this.day = aula.getDay();
		this.num = aula.getNum();
		this.turn = aula.getTurn();
		this.professor = new SimpleProfessorDTO(aula.getProfessor());
		this.classe = new SimpleClasseDTO(aula.getClasse());
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

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public SimpleProfessorDTO getProfessor() {
		return professor;
	}

	public void setProfessor(SimpleProfessorDTO professor) {
		this.professor = professor;
	}

	public ExerciseDTO getExercise() {
		return exercise;
	}

	public void setExercise(ExerciseDTO exercise) {
		this.exercise = exercise;
	}

	public SimpleClasseDTO getClasse() {
		return classe;
	}

	public void setClasse(SimpleClasseDTO classe) {
		this.classe = classe;
	}

}
