package com.teste.escola.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.escola.dto.ExerciseDTO;
import com.teste.escola.services.ExerciseService;

@RestController
@RequestMapping(value = "/exercises")
public class ExerciseResource {

	@Autowired
	ExerciseService service;

	@GetMapping
	public ResponseEntity<List<ExerciseDTO>> findAll() {
		List<ExerciseDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<ExerciseDTO> findById(@PathVariable Long id) {
		ExerciseDTO entity = service.findById(id);
		return ResponseEntity.ok().body(entity);
	}

	@PostMapping
	public ResponseEntity<ExerciseDTO> insert(@RequestBody ExerciseDTO exerciseDTO) {
		ExerciseDTO entity = service.insert(exerciseDTO);
		return ResponseEntity.ok().body(entity);
	}

	@PutMapping
	public ResponseEntity<ExerciseDTO> update(@PathVariable Long id, @RequestBody ExerciseDTO exerciseDTO) {
		ExerciseDTO entity = service.update(id, exerciseDTO);
		return ResponseEntity.ok().body(entity);
	}
}
