package com.teste.escola.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.teste.escola.entities.enums.Subject;

@Entity
@Table(name = "tb_professor")
public class Professor extends User {
	private Subject subject;

	@OneToMany(mappedBy = "professor")
	Set<Aula> aula = new HashSet<>();

	@OneToMany(mappedBy = "professor")
	List<Exercise> exercises = new ArrayList<>();

	public Professor() {
	}

	public Professor(Long id, String name, String email, String password, Subject subject) {
		super(id, name, email, password);
		this.subject = subject;
	}

	public Set<Aula> getAula() {
		return aula;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
