package com.teste.escola.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teste.escola.dto.ProfessorDTO;
import com.teste.escola.entities.Professor;
import com.teste.escola.repositories.ProfessorRepository;
import com.teste.escola.services.exceptions.ResourceNotFoundException;
@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;
	
	public Page<ProfessorDTO> findAll(Pageable pageable) {
		Page<Professor> list = repository.findAll(pageable);
		return list.map(x -> new ProfessorDTO(x,x.getAula()));
	}
	
	public ProfessorDTO findById(Long id) {
		Optional<Professor> professor = repository.findById(id);
		Professor prof = professor.orElseThrow(() ->  new ResourceNotFoundException("Entity not found"));
		return new ProfessorDTO(prof,prof.getAula());
	}
	
	
	public ProfessorDTO insert(ProfessorDTO dto) {
		Professor entity = new Professor();
		copyToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProfessorDTO(entity);
	}
	
	public ProfessorDTO update(Long id, ProfessorDTO dto) {
		try {
		Professor entity = repository.getById(id);
        copyToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProfessorDTO(entity);
	    }catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException("id not found " + id);
	}}
	
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	
	private void copyToEntity(ProfessorDTO dto, Professor entity) {
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setSubject(dto.getSubject());
	}
	
}
