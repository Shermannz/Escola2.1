package com.teste.escola.dto.simple;

import com.teste.escola.entities.Professor;

public class SimpleProfessorDTO {
    private Long id;
    private String name;
    private String subject;

    public SimpleProfessorDTO() {

    }

    public SimpleProfessorDTO(Long id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public SimpleProfessorDTO(Professor professor) {
        this.id = professor.getId();
        this.name = professor.getName();
        this.subject = professor.getSubject().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
