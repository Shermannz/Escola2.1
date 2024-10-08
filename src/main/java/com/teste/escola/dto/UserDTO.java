package com.teste.escola.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.teste.escola.entities.User;

public class UserDTO {
	private Long id;
	@NotBlank
	@Size(min = 5, max = 60, message = "5 ate 6 caracteres")
	private String name;
	@NotBlank
	@Email(message = "Entrar com email valido")
	private String email;
	private String password;
	Set<RoleDTO> role = new HashSet<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		user.getRoles().forEach(x -> this.role.add(new RoleDTO(x)));
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDTO> getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
