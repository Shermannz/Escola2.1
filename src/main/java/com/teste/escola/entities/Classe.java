package com.teste.escola.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_classe")
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer number;
	
	@OneToMany(mappedBy = "classe",cascade = CascadeType.ALL)
	Set<Aluno> alunos = new HashSet<>();

	@OneToMany(mappedBy = "classe",cascade = CascadeType.ALL)
	Set<Aula> aula = new HashSet<>();
	
	public Classe() {
	}

	public Classe(Long id, Integer number) {
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Set<Aula> getAula() {
		return aula;
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
		Classe other = (Classe) obj;
		return Objects.equals(id, other.id);
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}
	
	
}
