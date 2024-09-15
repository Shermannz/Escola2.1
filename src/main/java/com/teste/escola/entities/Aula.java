package com.teste.escola.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.teste.escola.entities.enums.Turn;

@Entity
@Table(name = "tb_aula")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String day;
	private Integer num;
	private Turn turn;

	@ManyToOne
	private Exercise exercise;

	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;

	@ManyToOne
	@JoinColumn(name = "classe_id")
	private Classe classe;

	public Aula() {
	}

	public Aula(Long id, String day, Integer num, Classe classe, Turn turn, Exercise exercise) {
		this.id = id;
		this.day = day;
		this.num = num;
		this.classe = classe;
		this.turn = turn;
		this.exercise = exercise;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	// TODO revisar esse metodo
	public void metodoTeste() {
		for (Aluno aluno : classe.getAlunos()) {
			aluno.getExercises().add(exercise);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id);
	}

}
