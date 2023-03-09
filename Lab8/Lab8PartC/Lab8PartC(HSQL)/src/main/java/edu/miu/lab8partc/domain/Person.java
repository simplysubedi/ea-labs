package edu.miu.lab8partc.domain;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    List<Pet>pets=new ArrayList<>();

    public Person(String firstName, String lastName, List<Pet> pets) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
    }

    public Person() {

    }
}
