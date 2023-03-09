package edu.miu.lab8partc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private int id;
    private String name;
private int age;

    public Pet(String name) {
        this.name=name;
    }

    public Pet() {

    }
}
