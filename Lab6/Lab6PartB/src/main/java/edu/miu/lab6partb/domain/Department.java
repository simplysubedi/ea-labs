package edu.miu.lab6partb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department() {

    }
}
