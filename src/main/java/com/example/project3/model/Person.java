package com.example.project3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private int age;

    @Column(unique = true)
    private String email;

    @Column
    @CreatedDate
    private String password;

    @OneToMany(mappedBy = "customers")
    private List<Task> tasks;

    public Person(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}
