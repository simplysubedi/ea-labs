package edu.miu.lab6partb.domain;

import jakarta.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private int id;
    private String grade;
    @OneToOne(cascade = CascadeType.ALL)
    Course course;

    public Grade(String grade) {
        this.grade = grade;
    }

    public Grade(String grade, Course course) {

        this.grade = grade;
        this.course = course;
    }

    public Grade() {

    }
}
