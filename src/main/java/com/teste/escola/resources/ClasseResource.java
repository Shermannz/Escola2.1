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

import com.teste.escola.dto.ClasseDTO;
import com.teste.escola.services.ClasseService;

@RestController
@RequestMapping(value = "/classes")
public class ClasseResource {

	@Autowired
	private ClasseService service;
	
	@GetMapping
	public ResponseEntity<Page<ClasseDTO>> findAll(Pageable pageable){
		Page<ClasseDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<ClasseDTO> findById(@PathVariable Long id){
		ClasseDTO classe = service.findById(id);
		return ResponseEntity.ok().body(classe);
	}
	
	@PostMapping
	public ResponseEntity<ClasseDTO> insert(@Valid @RequestBody ClasseDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClasseDTO> update(@PathVariable Long id,@Valid  @RequestBody ClasseDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
