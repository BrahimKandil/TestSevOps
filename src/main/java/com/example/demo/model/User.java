package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class User {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Constructors
    public User() {}

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public User(String name) {
        this.name = name;
    }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }
}
