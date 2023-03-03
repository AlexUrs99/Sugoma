package com.example.demoapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "game")
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, length = 80)
    private String name;

    @NotNull
    @Column
    private int stock;

    @NotNull
    @Column(precision = 2)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    public void decreaseStock(int quantity) {
        stock -= quantity;
    }
}
