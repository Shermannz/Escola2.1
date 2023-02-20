package com.teste.escola.services;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.escola.dto.AlunoDTO;
import com.teste.escola.entities.Aluno;
import com.teste.escola.repositories.AlunoRepository;
import com.teste.escola.repositories.ClasseRepository;
import com.teste.escola.services.exceptions.ResourceNotFoundException;

@Transactional
@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private ClasseRepository Crepository;
	
	@Transactional(readOnly = true)
	public Page<AlunoDTO> findAll(Pageable pageable) {
		Page<Aluno> list = repository.findAll(pageable);
		return list.map(x -> new AlunoDTO(x));
	}
	
	public AlunoDTO findById(Long id) {
		Optional<Aluno> aluno = repository.findById(id);
		Aluno alunos = aluno.orElseThrow(() ->  new ResourceNotFoundException("Entity not found"));
		return new AlunoDTO(alunos);
	}
	
	
	public AlunoDTO insert(AlunoDTO dto) {
		Aluno entity = new Aluno();
		copyToEntity(dto, entity);
		entity = repository.save(entity);
		return new AlunoDTO(entity);
	}
	
	public AlunoDTO update(Long id, AlunoDTO dto) {
		try {
		Aluno entity = repository.getById(id);
        copyToEntity(dto, entity);
        entity = repository.save(entity);
        return new AlunoDTO(entity);
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
	
	
	private void copyToEntity(AlunoDTO dto, Aluno entity) {
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setClasse(Crepository.getById(dto.getClasse().getId()));
	}
	
}
