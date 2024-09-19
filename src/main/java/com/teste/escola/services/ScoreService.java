package com.teste.escola.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.escola.dto.ExerciseDTO;
import com.teste.escola.dto.ScoreDTO;
import com.teste.escola.entities.Exercise;
import com.teste.escola.entities.Score;
import com.teste.escola.repositories.AlunoRepository;
import com.teste.escola.repositories.ExerciseRepository;
import com.teste.escola.repositories.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<ScoreDTO> findAll() {
        List<Score> list = repository.findAll();
        return list.stream().map(x -> new ScoreDTO(x)).toList();
    }

    public ScoreDTO findById(Long id) {
        return new ScoreDTO(repository.findById(id).get());
    }

    public ScoreDTO insert(ScoreDTO dto) {
        Score score = new Score();
        score.setScore(dto.getScore());
        score.setAluno(alunoRepository.findById(dto.getAluno().getId()).get());
        for (ExerciseDTO exerciseDTO : dto.getExercises()) {
            // TODO ideia: só aceitar de determinado professor
            Exercise exercise = exerciseRepository.getById(exerciseDTO.getId());
            score.getExercises().add(exercise);
        }
        return new ScoreDTO(repository.save(score));
    }

}
