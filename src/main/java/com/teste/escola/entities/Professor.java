package com.teste.escola.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor extends User {
	private String subject;

	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	Set<Aula> aula = new HashSet<>();

	public Professor() {
	}

	public Professor(Long id, String name, Integer age, String subject) {
		super(id, name, name, subject);
		this.subject = subject;
	}

	public Set<Aula> getAula() {
		return aula;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
