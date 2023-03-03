package com.example.demoapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    @Column(name = "name", unique = true, length = 32)
    private String name;

    @NotNull
    @Column(name = "password", length = 128)
    private String password;
}
