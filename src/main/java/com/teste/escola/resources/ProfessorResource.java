package com.teste.escola.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.escola.dto.ProfessorDTO;
import com.teste.escola.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {

	@Autowired
	ProfessorService service;

	@GetMapping
	public ResponseEntity<Page<ProfessorDTO>> findAll(Pageable pageable) {
		Page<ProfessorDTO> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<ProfessorDTO> findById(@PathVariable Long id) {
		ProfessorDTO prof = service.findById(id);
		return ResponseEntity.ok().body(prof);
	}

	@PostMapping
	public ResponseEntity<ProfessorDTO> insert(@Valid @RequestBody ProfessorDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProfessorDTO> update(@PathVariable Long id, @Valid @RequestBody ProfessorDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
