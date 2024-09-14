package com.teste.escola.dto;

import com.teste.escola.entities.Professor;

public class SimpleProfessorDTO {
    private String name;
    private String subject;

    public SimpleProfessorDTO() {

    }

    public SimpleProfessorDTO(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public SimpleProfessorDTO(Professor professor) {
        this.name = professor.getName();
        this.subject = professor.getSubject().toString();
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
