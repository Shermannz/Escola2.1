package com.teste.escola.dto;

import java.util.ArrayList;
import java.util.List;

import com.teste.escola.entities.Exercise;
import com.teste.escola.entities.Score;

public class ScoreDTO {
    private Long id;
    private Double score;

    private AlunoDTO aluno;

    private List<ExerciseDTO> exercises = new ArrayList<>();

    public ScoreDTO() {
    }

    public ScoreDTO(Long id, Double score, AlunoDTO aluno) {
        this.id = id;
        this.score = score;
        this.aluno = aluno;
    }

    public ScoreDTO(Score score) {
        this.id = score.getId();
        this.score = score.getScore();
        this.aluno = new AlunoDTO(score.getAluno());
        for (Exercise exercise : score.getExercises()) {
            exercises.add(new ExerciseDTO(exercise));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public List<ExerciseDTO> getExercises() {
        return exercises;
    }

}
