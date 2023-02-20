package com.teste.escola.services;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.escola.dto.RoleDTO;
import com.teste.escola.entities.Role;
import com.teste.escola.repositories.RoleRepository;
import com.teste.escola.services.exceptions.ResourceNotFoundException;

@Transactional
@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	@Transactional(readOnly = true)
	public Page<RoleDTO> findAll(Pageable pageable) {
		Page<Role> list = repository.findAll(pageable);
		return list.map(x -> new RoleDTO(x));
	}
	
	public RoleDTO findById(Long id) {
		Optional<Role> aluno = repository.findById(id);
		Role alunos = aluno.orElseThrow(() ->  new ResourceNotFoundException("Entity not found"));
		return new RoleDTO(alunos);
	}
	
	
	public RoleDTO insert(RoleDTO dto) {
		Role entity = new Role();
		entity.setAuthority(dto.getAuthority());
		entity = repository.save(entity);
		return new RoleDTO(entity);
	}
	
	public RoleDTO update(Long id, RoleDTO dto) {
		try {
		Role entity = repository.getById(id);
        entity.setAuthority(dto.getAuthority());
        entity = repository.save(entity);
        return new RoleDTO(entity);
	   }catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException("id not found " + id);
	}
	}
	
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
}
