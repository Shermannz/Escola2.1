package com.teste.escola.dto;

import com.teste.escola.entities.Exercise;

public class ExerciseDTO {
    private Long id;
    private String challenge;

    public ExerciseDTO() {
    }

    public ExerciseDTO(Long id, String challenge) {
        this.id = id;
        this.challenge = challenge;
    }

    public ExerciseDTO(Exercise exercise) {
        this.id = exercise.getId();
        this.challenge = exercise.getChallenge();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }
}
