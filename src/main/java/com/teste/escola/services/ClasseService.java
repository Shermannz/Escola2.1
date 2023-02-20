package com.teste.escola.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.escola.dto.ClasseDTO;
import com.teste.escola.entities.Classe;
import com.teste.escola.repositories.ClasseRepository;
import com.teste.escola.services.exceptions.ResourceNotFoundException;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository repository;
	
	@Transactional
	public Page<ClasseDTO> findAll(Pageable pageable){
		Page<Classe> list = repository.findAll(pageable);
		return list.map(x -> new ClasseDTO(x));
		
	}
	
	@Transactional(readOnly = true)
	public ClasseDTO findById(Long id) {
		Optional<Classe> classe = repository.findById(id);
		Classe classes = classe.orElseThrow(() ->  new ResourceNotFoundException("Entity not found"));
		return new ClasseDTO(classes,classes.getAula(),classes.getAlunos());
	}
	
	@Transactional
	public ClasseDTO insert(ClasseDTO dto) {
		Classe entity = new Classe();
		entity.setNumber(dto.getNumber());
		entity = repository.save(entity);
		return new ClasseDTO(entity);
	}
	
	@Transactional
	public ClasseDTO update(Long id, ClasseDTO dto) {
		try {
		Classe entity = repository.getById(id);
		entity.setNumber(dto.getNumber());
        entity = repository.save(entity);
        return new ClasseDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
		}
	
	@Transactional
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	
	
}
