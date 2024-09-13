package com.teste.escola.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.teste.escola.entities.Aula;
import com.teste.escola.entities.Professor;

public class ProfessorDTO extends UserDTO {
	@NotBlank
	private String subject;

	List<AulaDTO> aula = new ArrayList<>();

	public ProfessorDTO() {
	}

	public ProfessorDTO(Long id, String name, String email, String password, String subject) {
		super(id, name, email);
		this.subject = subject;
	}

	public ProfessorDTO(Professor professor) {
		setId(professor.getId());
		setName(professor.getName());
		setEmail(professor.getEmail());
		setPassword(professor.getPassword());
		this.subject = professor.getSubject();
	}

	public ProfessorDTO(Professor professor, Set<Aula> aula) {
		this(professor);
		professor.getAula().forEach(au -> this.aula.add(new AulaDTO(au)));
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

	public Set<RoleDTO> getRole() {
		return role;
	}

}
