package com.example.project3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String username;

    @Column
    private int age;

    @Column(unique = true)
    private String email;

    @Column
    private String role;

    public Person(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}
