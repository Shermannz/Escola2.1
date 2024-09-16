package com.teste.escola.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.teste.escola.entities.enums.Subject;

@Entity
@Table(name = "tb_exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String challenge;
    private Subject subject;
    // TODO corrigir relacionamento
    @ManyToMany
    private Set<Score> exercises = new HashSet<>();

    public Exercise() {
    }

    public Exercise(Long id, String challenge, Subject subject) {
        this.id = id;
        this.challenge = challenge;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
