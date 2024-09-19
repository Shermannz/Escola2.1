package com.teste.escola.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.escola.dto.AulaDTO;
import com.teste.escola.dto.simple.SimpleAulaDTO;
import com.teste.escola.entities.Aula;
import com.teste.escola.repositories.AulaRepository;
import com.teste.escola.repositories.ClasseRepository;
import com.teste.escola.repositories.ExerciseRepository;
import com.teste.escola.repositories.ProfessorRepository;
import com.teste.escola.services.exceptions.ResourceNotFoundException;

@Transactional
@Service
public class AulaService {

	@Autowired
	private AulaRepository repository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private ClasseRepository classeRepository;

	@Autowired
	private ExerciseRepository exerciseRepository;

	public Page<SimpleAulaDTO> findAll(Pageable pageable) {
		Page<Aula> aula = repository.findAll(pageable);
		return aula.map(x -> new SimpleAulaDTO(x));
	}

	public SimpleAulaDTO findById(Long id) {
		Optional<Aula> aula = repository.findById(id);
		Aula aulas = aula.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new SimpleAulaDTO(aulas);
	}

	public AulaDTO insert(AulaDTO dto) {
		Aula entity = new Aula();
		copyToEntity(dto, entity);
		entity = repository.save(entity);
		return new AulaDTO(entity);
	}

	public AulaDTO update(Long id, AulaDTO dto) {
		try {
			Aula aula = repository.getById(id);
			copyToEntity(dto, aula);
			aula = repository.save(aula);
			return new AulaDTO(aula);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	private void copyToEntity(AulaDTO dto, Aula entity) {
		entity.setDay(dto.getDay());
		entity.setNum(dto.getNum());
		entity.setProfessor(professorRepository.getById(dto.getProfessor().getId()));
		entity.setClasse(classeRepository.getById(dto.getClasse().getId()));
		entity.setExercise(exerciseRepository.getById(dto.getExercise().getId()));
	}

}
