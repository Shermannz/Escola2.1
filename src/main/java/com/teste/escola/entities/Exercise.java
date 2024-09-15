package com.teste.escola.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Integer hits;
    private Integer errors;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Exercise() {
    }

    public Exercise(Long id, String challenge, Subject subject, Integer hits, Integer errors, Aluno aluno) {
        this.id = id;
        this.challenge = challenge;
        this.subject = subject;
        this.hits = hits;
        this.errors = errors;
        this.aluno = aluno;
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

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }

}
