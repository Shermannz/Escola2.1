package com.teste.escola.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.escola.dto.ScoreDTO;
import com.teste.escola.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreResource {
    @Autowired
    ScoreService service;

    @GetMapping
    public ResponseEntity<List<ScoreDTO>> findAll() {
        List<ScoreDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ScoreDTO> findById(@PathVariable Long id) {
        ScoreDTO entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping
    public ResponseEntity<ScoreDTO> insert(@RequestBody ScoreDTO scoreDTO) {
        ScoreDTO entity = service.insert(scoreDTO);
        return ResponseEntity.ok().body(entity);
    }
}
