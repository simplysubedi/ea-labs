package edu.miu.lab6partb.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@NamedQuery(name="course.findBycourseName", query="select s from Student e where s.grade.course.name = :name")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private long studentNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Department department;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    List<Grade> grade = new ArrayList<>();

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Student(String name, long studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Grade> getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", department=" + department +
                ", grade=" + grade +
                '}';
    }
}
