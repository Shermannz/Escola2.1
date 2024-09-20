package com.teste.escola.dto;

import com.teste.escola.entities.Exercise;

public class ExerciseDTO {
    private Long id;
    private String challenge;
    private int successes;
    private int mistakes;

    public ExerciseDTO() {
    }

    public ExerciseDTO(Long id, String challenge, int successes, int mistakes) {
        this.id = id;
        this.challenge = challenge;
        this.successes = successes;
        this.mistakes = mistakes;
    }

    public ExerciseDTO(Exercise exercise) {
        this.id = exercise.getId();
        this.challenge = exercise.getChallenge();
        this.successes = exercise.getSuccesses();
        this.mistakes = exercise.getMistakes();
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

    public int getSuccesses() {
        return successes;
    }

    public void setSuccesses(int successes) {
        this.successes = successes;
    }

    public int getMistakes() {
        return mistakes;
    }

    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

}
