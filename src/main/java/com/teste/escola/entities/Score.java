package com.teste.escola.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.teste.escola.entities.enums.Subject;

@Entity
@Table(name = "tb_score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double score;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    private Subject subject;

    // TODO corrigir relacionamento
    @ManyToMany
    private Set<Exercise> exercises = new HashSet<>();

    public Score(Long id, Double score, Aluno aluno, Subject subject) {
        this.id = id;
        this.score = score;
        this.aluno = aluno;
        this.subject = subject;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
