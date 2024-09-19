package com.teste.escola.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.escola.dto.ExerciseDTO;
import com.teste.escola.entities.Exercise;
import com.teste.escola.repositories.ExerciseRepository;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository repository;

    public ExerciseDTO findById(Long id) {
        return new ExerciseDTO(repository.findById(id).get());
    }

    public List<ExerciseDTO> findAll() {
        List<Exercise> list = repository.findAll();
        return list.stream().map(x -> new ExerciseDTO(x)).toList();
    }

    public ExerciseDTO insert(ExerciseDTO dto) {
        Exercise exercise = new Exercise();
        exercise.setChallenge(dto.getChallenge());
        repository.save(exercise);
        return new ExerciseDTO(exercise);
    }

    public ExerciseDTO update(Long id, ExerciseDTO dto) {
        Exercise exercise = repository.findById(id).get();
        exercise.setChallenge(dto.getChallenge());
        repository.save(exercise);
        return new ExerciseDTO(exercise);
    }

}
