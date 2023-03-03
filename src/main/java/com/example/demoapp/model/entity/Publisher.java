package com.example.demoapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "publisher")
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, length = 80)
    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "publisher")
    private List<Game> publishedGames;
}
